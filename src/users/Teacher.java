package users

diagram;


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
    
    
    
    /**
    * @generated
    */
    private Integer getTeacherId() {
        return this.teacherId;
    }
    
    /**
    * @generated
    */
    private Integer setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    
    /**
    * @generated
    */
    private Faculty getFaculty() {
        return this.faculty;
    }
    
    /**
    * @generated
    */
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    /**
    * @generated
    */
    private TeacherType getTeacherType() {
        return this.teacherType;
    }
    
    /**
    * @generated
    */
    private TeacherType setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }
    
    /**
    * @generated
    */
    private Vector<Double> getRatings() {
        return this.ratings;
    }
    
    /**
    * @generated
    */
    private Vector<Double> setRatings(Vector<Double> ratings) {
        this.ratings = ratings;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void putMarks() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public double getRaiting() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void markAttendance() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void sendComplaint() {
        //TODO
        return null;
    }
    
    
}
