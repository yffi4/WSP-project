package academicUtilites;

import java.util.HashMap;
import java.util.Vector;
import enums.Period;
import users.Student;

public class Course extends Subject {

    private String name;
    private Integer year;
    private Period period;
    private Vector<Lesson> lessons;
    private Vector<Student> enrolledStudents;
    private HashMap<Student, GradeBook> gradeBook = new HashMap<Student, GradeBook>();

    public Course() {
        this.lessons = new Vector<>();
        this.enrolledStudents = new Vector<>();
    }

    public Course(String name, Integer year, Period period) {
        this.name = name;
        this.year = year;
        this.period = period;
        this.lessons = new Vector<>();
        this.enrolledStudents = new Vector<>();
    }

    public HashMap<Student, GradeBook> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(HashMap<Student, GradeBook> gradeBook) {
        this.gradeBook = gradeBook;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Period getPeriod() {
        return period;
    }

    public Vector<Lesson> getLessons() {
        return new Vector<>(lessons);
    }

    public double getClassMaxAndMin() {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (Lesson lesson : lessons) {
            double value = lesson.getSomeMetric1();
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        return max - min;
    }

    public String outputBarChart() {
        StringBuilder chart = new StringBuilder();
        for (Lesson lesson : lessons) {
            chart.append(lesson.getName()).append(": ");
            int value = (int) lesson.getSomeMetric1();
            for (int i = 0; i < value; i++) {
                chart.append("*");
            }
            chart.append("\n");
        }
        return chart.toString();
    }

    public double getClassAvg() {
        double sum = 0.0;
        for (Lesson lesson : lessons) {
            sum += lesson.getSomeMetric1();
        }
        return lessons.isEmpty() ? 0 : sum / lessons.size();
    }

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

    public Vector<Student> getEnrolledStudents() {
        return new Vector<>(enrolledStudents);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public void setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setEnrolledStudents(Vector<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void addLesson(Lesson lesson) {
        if (lesson != null) {
            this.lessons.add(lesson);
        }
    }

    public void removeLesson(Lesson lesson) {
        this.lessons.remove(lesson);
    }

    public void enrollStudent(Student student) {
        if (student != null) {
            this.enrolledStudents.add(student);
        }
    }

    public void disenrollStudent(Student student) {
        this.enrolledStudents.remove(student);
    }
}
