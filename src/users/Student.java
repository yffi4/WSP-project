package users;







import utils.Post;

import java.io.IOException;
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


    

    public Student(String name, String lastName) {
        super(name, lastName);
    }

    public Student(String firstName, String lastName, Faculty facultyType) {
        super(firstName, lastName);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Researcher getResearcherSupervisor() {
        return ResearcherSupervisor;
    }

    public void setResearcherSupervisor(Researcher researcherSupervisor) {
        ResearcherSupervisor = researcherSupervisor;
    }


    //                          Operations
    
    /**
    * @generated
    */
    public void RegisterForCourse() {


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

    
    /**
    * @generated
    */
    public void RateTeacher() {

    }
    
    /**
    * @generated
    */
    public void pickResearcherSupervisor() {


    }

    public ResearchProject getDiplomaProject() {
        // TODO
        return null;
    }


   
        // TODO

    
    /**
    * @generated
    */
    public void startOrganisation () {


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
        return null;
    }


    @Override
	public Vector<Course> viewCourse() {
		// TODO Auto-generated method stub
		return null;
	}


    @Override
    public void update(Post p) {

    }

    @Override
    public void run() throws IOException {

    }


    @Override
    public void becomeResearcher() {

    }

    @Override
    public void deleteResearchAccount() {

    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
