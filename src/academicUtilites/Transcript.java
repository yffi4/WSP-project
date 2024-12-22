package academicUtilites;

import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

import Database.Database;
import users.Student;

public class Transcript extends GradeReport {

    public Transcript(Course course, Mark mark) {
        super(course, mark);
    }

    public static Vector<GradeReport> getGradeReport(Student student) {

        Vector<GradeReport> gradeReports = new Vector<>();

        // Получаем список курсов, которые студент посещал ранее
        Vector<Course> completedCourses = student.ViewMyCourses()
                .stream()
                .filter(course -> course.getYear() < Database.DATA.getYear() ||
                        (course.getYear() == Database.DATA.getYear() &&
                                course.getPeriod().compareTo(Database.DATA.getPeriod()) < 0))
                .collect(Collectors.toCollection(Vector::new));

        // Формируем отчеты по оценкам для каждого курса
        for (Course course : completedCourses) {
            HashMap<Student, GradeBook> gradebook = course.getGradeBook();
            if (gradebook.containsKey(student)) {
                Mark mark = gradebook.get(student).getMark();
                gradeReports.add(new Transcript(course, mark));
            }
        }

        return gradeReports;
    }
    
    public static double getTotalGPA(Vector<GradeReport> transcript) {
        int sumOfCredits = 0;
        double sumOfGPAs = 0.0;

        for (GradeReport report : transcript) {
            int credits = report.getCourse().getEcts();
            double gpa = report.getMark().getGPA();

            sumOfCredits += credits;
            sumOfGPAs += credits * gpa;
        }

        return (sumOfCredits == 0 ? 0 : sumOfGPAs / sumOfCredits);
    }
    
    public String getStatistics(Vector<GradeReport> reports) {
        return "";
    }
}
