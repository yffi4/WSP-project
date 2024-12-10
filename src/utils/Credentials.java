package utils;

import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;

public abstract class Credentials extends EmployeePostComplaint implements CanViewCourse, CanViewStudents{
	
    private TeacherType teacherType;
    private String username;
    private String password;

    private TeacherType getTeacherType() {
        return this.teacherType;
    }

    private void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    private String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void putMarks() {
        // TODO
    }

    public double getRaiting() {
        // TODO
        return 0.0;
    }

    public void markAttendance() {
        // TODO
    }

    public String hashPassword() {
        // TODO
        return "";
    }

    public String generateRandomPassword() {
        // TODO
        return "";
    }

    public void generateUsername() {
        // TODO
    }
}
