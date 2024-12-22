package users;

import enums.Faculty;
import enums.StudentType;

public class Master extends Student {
    private StudentType studentType;

    public Master(String name, String lastName, Faculty facultyType) {
        super(name, lastName);
    }

    private StudentType getStudentType() {
        return this.studentType;
    }

    private void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
}
