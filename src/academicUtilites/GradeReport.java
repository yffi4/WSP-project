package academicUtilites;

import java.util.Vector;

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
    
    public Vector<GradeReport> getGradeReport(Student student5) {
        return new Vector<>();
    }
}
