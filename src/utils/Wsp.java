package utils;

import java.util.Comparator;
import java.util.Vector;

import academicUtilites.Course;
import enums.Language;
import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import users.Student;
import users.User;

public class Wsp extends EmployeePostComplaint implements CanViewCourse, CanViewStudents {
    private TeacherType teacherType;
    private Language language;
    private User loggedUser;

    private TeacherType getTeacherType() {
        return this.teacherType;
    }

    private void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    private Language getLanguage() {
        return this.language;
    }

    private void setLanguage(Language language) {
        this.language = language;
    }

    private User getLoggedUser() {
        return this.loggedUser;
    }

    private void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
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

    public void run() {
        // TODO
    }

    public void generateUsername() {
        // TODO
    }

    public void save() {
        // TODO
    }

	@Override
	public Vector<Student> viewStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Student> viewStudent(Comparator<Student> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Course> viewCourse() {
		// TODO Auto-generated method stub
		return null;
	}
}
