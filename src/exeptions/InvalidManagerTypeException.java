package exeptions

diagram;


/**
* @generated
*/
public class InvalidManagerTypeException extends EmployeeException implements CanViewCourse, CanViewStudents {
    
    /**
    * @generated
    */
    private TeacherType teacherType;
    
    
    
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
    
    
}
