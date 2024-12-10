package utils;

import java.util.Comparator;
import java.util.Vector;

import academicUtilites.Course;
import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import users.Student;

public class Request extends EmployeePostPostComplaint implements CanViewCourse, CanViewStudents {
    private TeacherType teacherType;
    private Boolean isSigned;

    private TeacherType getTeacherType() {
        return this.teacherType;
    }

    private void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    private Boolean getIsSigned() {
        return this.isSigned;
    }

    private void setIsSigned(Boolean isSigned) {
        this.isSigned = isSigned;
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
