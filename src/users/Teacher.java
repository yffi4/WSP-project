package users;




import java.util.Comparator;
import java.util.Vector;



import academicUtilites.Course;
import enums.Faculty;
import enums.MarkType;
import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import utils.Complaint;

public class Teacher extends Employee implements CanViewCourse, CanViewStudents {
    private Integer teacherId;
    private Faculty faculty;
    private TeacherType teacherType;
    private Vector<Double> ratings;


    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    private TeacherType getTeacherType() {
        return teacherType;
    }

    private void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    private Vector<Double> getRatings() {
        return ratings;
    }

    private void setRatings(Vector<Double> ratings) {
        this.ratings = ratings;
    }

    
    public double getRaiting() {
        // TODO
        return 0.0;
    }

    

	

	

	

    public Teacher(String name, String lastName) {
        super(name, lastName);
    }


    //                          Operations                                  
    
    /**
    * @generated
    */
    public void putMarks() {

    }
    
    /**
    * @generated
    */
//    public double getRaiting() {
//        return null;
//    }
    
    /**
    * @generated
    */
    public void markAttendance() {

    }
    
    /**
    * @generated
    */
    public void sendComplaint() {

    }


    @Override
    public Vector<Course> viewCourse() {
        return null;
    }

    @Override
    public Vector<Student> viewStudent() {
        return null;
    }

}
