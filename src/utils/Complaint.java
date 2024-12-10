package utils;

import enums.Urgency;
import users.Student;
import users.User;


/**
* @generated
*/
public class Complaint extends Post {
    
    /**
    * @generated
    */
    private Urgency urgencyLevel;
    
    /**
    * @generated
    */
    private Student student;

    public Complaint() {
        super();
    }
    public Complaint(String content, User author, Student student, Urgency urgencyLevel){
        super(content, author);
        this.student = student;
        this.urgencyLevel = urgencyLevel;
    }
    public Urgency getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(Urgency urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
