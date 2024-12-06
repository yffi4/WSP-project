package users

diagram;


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
    
    
    
    /**
    * @generated
    */
    private String getStudentId() {
        return this.studentId;
    }
    
    /**
    * @generated
    */
    private String setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    /**
    * @generated
    */
    private Faculty getFaculty() {
        return this.faculty;
    }
    
    /**
    * @generated
    */
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    /**
    * @generated
    */
    private Researcher getResearcherSupervisor() {
        return this.ResearcherSupervisor;
    }
    
    /**
    * @generated
    */
    private Researcher setResearcherSupervisor(Researcher ResearcherSupervisor) {
        this.ResearcherSupervisor = ResearcherSupervisor;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void RegisterForCourse() {
        //TODO
        return null;
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
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void pickResearcherSupervisor() {
        //TODO
        return null;
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
        //TODO
        return null;
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
    
    
}
