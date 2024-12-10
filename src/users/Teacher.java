package users;

import java.util.Comparator;
import java.util.Vector;

import academicUtilites.Course;
import enums.Faculty;
import enums.MarkType;
import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import utils.Complaint;

public class Teacher extends Employee implements CanViewCourse, CanViewStudents {
    private Integer teacherId;
    private Faculty faculty;
    private TeacherType teacherType;
    private Vector<Double> ratings;

    private Integer getTeacherId() {
        return this.teacherId;
    }

    private void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    private Faculty getFaculty() {
        return this.faculty;
    }

    private void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    private TeacherType getTeacherType() {
        return this.teacherType;
    }

    private void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    private Vector<Double> getRatings() {
        return this.ratings;
    }

    private void setRatings(Vector<Double> ratings) {
        this.ratings = ratings;
    }

    public void putMarks(Course c, Student s, double mark, MarkType mt) {
        // TODO
    }

    public double getRaiting() {
        // TODO
        return 0.0;
    }

    public void markAttendance(Course c, Vector<Student> st, boolean present) {
        // TODO
    }

    public void sendComplaint(Complaint comp) {
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
