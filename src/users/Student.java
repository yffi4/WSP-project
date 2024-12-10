package users;

import academicUtilites.Course;
import academicUtilites.GPA;
import academicUtilites.GradeReport;
import enums.Faculty;
import papers.ResearchProject;
import permissions.CanViewCourse;
import permissions.CanViewTeachers;
import utils.Post;

import java.util.Comparator;
import java.util.Vector;




/**
* @generated
*/
public class Student extends User implements CanViewCourse, CanViewTeachers {
    
    /**
    * @generated
    */
    private String studentId;
    
    /**
    * @generated
    */
    private Faculty faculty;
    
    /**
    * @generated
    */
    private Researcher ResearcherSupervisor;

    public Student(String name, String lastName) {
        super(name, lastName);
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
    
    /**
    * @generated
    */
    public Vector<Course> ViewMyCourses() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public Vector<GradeReport> ViewMarks() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public Vector<GradeReport> ViewTranscript() {
        //TODO
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
    
    /**
    * @generated
    */
    public ResearchProject getDiplomaProject() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void startOrganisation () {

    }
    
    /**
    * @generated
    */
    public GPA getGPA() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean lastYearStudent() {
        //TODO
        return false;
    }


    @Override
    public void update(Post p) {

    }

    @Override
    public Vector<Course> viewCourse() {
        return null;
    }

    @Override
    public Vector<Teacher> viewTeacher() {
        return null;
    }

    @Override
    public Vector<Teacher> viewTeacher(Comparator<Teacher> comparator) {
        return null;
    }

    @Override
    public void becomeResearcher() {

    }
}
