package academicUtilites;

import java.util.HashMap;
import java.util.Vector;

import Database.Database;
import enums.Period;
import users.Student;

public class Course extends Subject {


    private  int limit;
    private HashMap<Student, GradeBook> gradeBook = new HashMap<Student, GradeBook>();

    private String name;
    private Integer year;
    private Period period;
    private Vector<Lesson> lessons = new Vector<>();
    private Vector<Student> enrolledStudents = new Vector<>();

    public Course() {}

    public Course(String name, Integer year, Period period) {
        this.name = name;
        this.year = year;
        this.period = period;
    }

    public Course(String code, String name, Integer ects, Vector<Object> subjectType, int limit) {
        super(code, ects, name, subjectType);
        this.limit=limit;
        this.period= Database.DATA.getPeriod();
        this.year=Database.DATA.getYear();
    }


    // Getter and Setter Methods
    public String getName() {
        return name;
    }

    public HashMap<Student, GradeBook> getGradeBook() {
        return gradeBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Vector<Lesson> getLessons() {
        return new Vector<>(lessons);
    }

    public void setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Vector<Student> getEnrolledStudents() {
        return new Vector<>(enrolledStudents);
    }

    public void setEnrolledStudents(Vector<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    // Methods for Adding and Removing Lessons
    public void addLesson(Lesson lesson) {
        if (lesson != null) {
            this.lessons.add(lesson);
        }
    }

    public void removeLesson(Lesson lesson) {
        this.lessons.remove(lesson);
    }

    // Methods for Adding and Removing Students
    public void enrollStudent(Student student) {
        if (student != null && !enrolledStudents.contains(student)) {
            this.enrolledStudents.add(student);
        }
    }

    public void disenrollStudent(Student student) {
        this.enrolledStudents.remove(student);
    }

    // Calculation for Class Average
    public double getClassAvg() {
        double sum = 0.0;
        for (Lesson lesson : lessons) {
            sum += lesson.getSomeMetric();
        }
        return lessons.isEmpty() ? 0 : sum / lessons.size();
    }

    // Finding Differences from Max to Min of Class
    public double getClassMaxAndMin() {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (Lesson lesson : lessons) {
            double value = lesson.getSomeMetric();
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        return max - min;
    }

    // Generating Text for Bar Chart
    public String outputBarChart() {
        StringBuilder chart = new StringBuilder();
        for (Lesson lesson : lessons) {
            chart.append(lesson.getName()).append(": ");
            int value = (int) lesson.getSomeMetric();
            for (int i = 0; i < value; i++) {
                chart.append("*");
            }
            chart.append("\n");
        }
        return chart.toString();
    }

    // Displaying Report
    public String displayReport() {
        StringBuilder report = new StringBuilder();
        report.append("Course Report:\n");
        report.append("Name: ").append(name).append("\n");
        report.append("Year: ").append(year).append("\n");
        report.append("Period: ").append(period).append("\n");
        report.append("Number of Lessons: ").append(lessons.size()).append("\n");
        report.append("Enrolled Students: ").append(enrolledStudents.size()).append("\n");
        report.append("Average Metric: ").append(getClassAvg()).append("\n");
        return report.toString();
    }



}
