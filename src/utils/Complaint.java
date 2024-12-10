package utils;

import enums.Urgency;
import users.Student;

public class Complaint extends Post implements Comparable<Post> {
    private Urgency urgencyLevel;
    private Student student;

    private Urgency getUrgencyLevel() {
        return this.urgencyLevel;
    }

    private void setUrgencyLevel(Urgency urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    private Student getStudent() {
        return this.student;
    }

    private void setStudent(Student student) {
        this.student = student;
    }

}
