package users;

import enums.StudentType;

public class Master extends Student {
    private StudentType studentType;

    private StudentType getStudentType() {
        return this.studentType;
    }

    private void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
}
