package users;

import enums.StudentType;

public class PhDStudent extends Student {
    private StudentType studentType;

    private StudentType getStudentType() {
        return this.studentType;
    }

    private void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
}
