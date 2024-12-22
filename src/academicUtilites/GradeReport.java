package academicUtilites;

import java.util.Vector;
import java.util.stream.Collectors;

import Database.Database;
import users.Student;

public class GradeReport {
    
    private Course course;
    private Mark mark;
    
    public GradeReport() {
    }
    
    public GradeReport(Course course, Mark mark) {
        this.course = course;
        this.mark = mark;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Mark getMark() {
        return mark;
    }
    
    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public static Vector<GradeReport> getGradeReport(Student student) {
        Vector<GradeReport> gradeReports = new Vector<GradeReport>();
        Vector<Course> courses = student.viewCourse().stream().
                filter(n->n.getPeriod()== Database.DATA.getPeriod() && n.getYear()==Database.DATA.getYear()).collect(Collectors.toCollection(Vector<Course>::new));

        for(Course course : courses) {
            gradeReports.add(new GradeReport(course, course.getGradeBook().get(student).getMark()));
        }
        return gradeReports;
    }
}
