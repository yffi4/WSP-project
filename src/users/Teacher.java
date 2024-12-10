package users;

import academicUtilites.Course;
import enums.Faculty;
import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;

import java.util.Comparator;
import java.util.Vector;



/**
* @generated
*/
public class Teacher extends Employee implements CanViewCourse, CanViewStudents {
    
    /**
    * @generated
    */
    private Integer teacherId;
    
    /**
    * @generated
    */
    private Faculty faculty;
    
    /**
    * @generated
    */
    private TeacherType teacherType;
    
    /**
    * @generated
    */
    private Vector<Double> ratings;

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

    @Override
    public Vector<Student> viewStudent(Comparator<Student> comparator) {
        return null;
    }
}
