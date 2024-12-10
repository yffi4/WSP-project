package users;

import java.util.Vector;

import papers.ResearchPaper;
import papers.ResearchProject;

public class ResearcherSupervisor extends Researcher {
    private Integer hIndex;
    private Vector<ResearchProject> supervisedProjects;
    private Vector<Student> supervisedStudents;
    private Vector<ResearchPaper> superisedResearchPapers; // corrected spelling

    private Integer getHIndex() {
        return this.hIndex;
    }

    private void setHIndex(Integer hIndex) {
        this.hIndex = hIndex;
    }

    private Vector<ResearchProject> getSupervisedProjects() {
        return this.supervisedProjects;
    }

    private void setSupervisedProjects(Vector<ResearchProject> supervisedProjects) {
        this.supervisedProjects = supervisedProjects;
    }

    private Vector<Student> getSupervisedStudents() {
        return this.supervisedStudents;
    }

    private void setSupervisedStudents(Vector<Student> supervisedStudents) {
        this.supervisedStudents = supervisedStudents;
    }

    private Vector<ResearchPaper> getSuperisedResearchPapers() {
        return this.superisedResearchPapers;
    }

    private void setSuperisedResearchPapers(Vector<ResearchPaper> superisedResearchPapers) {
        this.superisedResearchPapers = superisedResearchPapers;
    }
}
