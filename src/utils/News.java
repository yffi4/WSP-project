package utils;

import java.util.Comparator;
import java.util.Vector;

import academicUtilites.Course;
import enums.NewsTopic;
import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import users.Student;


public class News extends EmployeePostPostComplaint implements CanViewCourse, CanViewStudents {
    private TeacherType teacherType;
    private NewsTopic topic;
    private Vector<Post> comments;

    private TeacherType getTeacherType() {
        return this.teacherType;
    }

    private void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    private NewsTopic getTopic() {
        return this.topic;
    }

    private void setTopic(NewsTopic topic) {
        this.topic = topic;
    }

    private Vector<Post> getComments() {
        return this.comments;
    }

    private void setComments(Vector<Post> comments) {
        this.comments = comments;
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

    public News autoGenerate() {
        // TODO
        return null;
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
