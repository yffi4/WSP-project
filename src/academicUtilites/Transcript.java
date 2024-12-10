package academicUtilites;

import java.util.Vector;

import users.Student;

public class Transcript extends GradeReport {
    
    public Vector<GradeReport> getGradeReport(Student student) {
        return new Vector<>();
    }
    
    public GPA getTotalGPA() {
        return null;
    }
    
    public String getStatistics(Vector<GradeReport> reports) {
        return "";
    }
}
