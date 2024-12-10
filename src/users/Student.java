package users;

import java.util.Comparator;
import java.util.Vector;

import academicUtilites.Course;
import academicUtilites.GPA;
import academicUtilites.GradeReport;
import enums.Faculty;
import papers.ResearchProject;
import permissions.CanViewCourse;
import permissions.CanViewTeachers;

public class Student extends User implements CanViewCourse, CanViewTeachers {
    private String studentId;
    private Faculty faculty;
    private Researcher ResearcherSupervisor;

    private String getStudentId() {
        return this.studentId;
    }

    private void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private Faculty getFaculty() {
        return this.faculty;
    }

    private void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    private Researcher getResearcherSupervisor() {
        return this.ResearcherSupervisor;
    }

    private void setResearcherSupervisor(Researcher ResearcherSupervisor) {
        this.ResearcherSupervisor = ResearcherSupervisor;
    }

    public void RegisterForCourse(Course c) {
        // TODO
    }

    public Vector<Course> ViewMyCourses() {
        // TODO
        return null;
    }

    public Vector<GradeReport> ViewMarks() {
        // TODO
        return null;
    }

    public Vector<GradeReport> ViewTranscript() {
        // TODO
        return null;
    }

    public void RateTeacher(Teacher t, Integer rating) {
        // TODO
    }

    public void pickResearcherSupervisor(Researcher r) {
        // TODO
    }

    public ResearchProject getDiplomaProject() {
        // TODO
        return null;
    }

    public void startOrganisation(String name) {
        // TODO
    }

    public GPA getGPA() {
        // TODO
        return null;
    }

    public boolean lastYearStudent() {
        // TODO
        return false;
    }

	@Override
	public Vector<Teacher> viewTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Teacher> viewTeacher(Comparator<Teacher> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Course> viewCourse() {
		// TODO Auto-generated method stub
		return null;
	}
}
