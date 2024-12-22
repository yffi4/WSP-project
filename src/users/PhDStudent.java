package users;

import enums.Faculty;
import enums.StudentType;

public class PhDStudent extends Student {
    private StudentType studentType;

    public PhDStudent(String name, String lastName, Faculty facultyType) {
        super(name, lastName);
    }

    private StudentType getStudentType() {
        return this.studentType;
    }

    private void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
}
