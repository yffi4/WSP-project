package users

diagram;


/**
* @generated
*/
public class ResearcherSupervisor extends Researcher {
    
    /**
    * @generated
    */
    private Integer hIndex;
    
    /**
    * @generated
    */
    private Vector<ResearchProject> supervisedProjects;
    
    /**
    * @generated
    */
    private Vector<Student> supervisedStudents;
    
    /**
    * @generated
    */
    private Vector<ResearhPaper> superisedResearchPapers;
    
    
    
    /**
    * @generated
    */
    private Integer getHIndex() {
        return this.hIndex;
    }
    
    /**
    * @generated
    */
    private Integer setHIndex(Integer hIndex) {
        this.hIndex = hIndex;
    }
    
    /**
    * @generated
    */
    private Vector<ResearchProject> getSupervisedProjects() {
        return this.supervisedProjects;
    }
    
    /**
    * @generated
    */
    private Vector<ResearchProject> setSupervisedProjects(Vector<ResearchProject> supervisedProjects) {
        this.supervisedProjects = supervisedProjects;
    }
    
    /**
    * @generated
    */
    private Vector<Student> getSupervisedStudents() {
        return this.supervisedStudents;
    }
    
    /**
    * @generated
    */
    private Vector<Student> setSupervisedStudents(Vector<Student> supervisedStudents) {
        this.supervisedStudents = supervisedStudents;
    }
    
    /**
    * @generated
    */
    private Vector<ResearhPaper> getSuperisedResearchPapers() {
        return this.superisedResearchPapers;
    }
    
    /**
    * @generated
    */
    private Vector<ResearhPaper> setSuperisedResearchPapers(Vector<ResearhPaper> superisedResearchPapers) {
        this.superisedResearchPapers = superisedResearchPapers;
    }
    
}
