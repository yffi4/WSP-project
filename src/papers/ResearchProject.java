package papers;

import java.util.Vector;

import users.Researcher;

public class ResearchProject {
    private int projectId;
    private String topic;
    private Vector<ResearchPaper> publishedPapers;
    private Researcher researchSupervisor;
    private Vector<Researcher> participants;

    public ResearchProject() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Vector<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public Researcher getResearchSupervisor() {
        return researchSupervisor;
    }

    public void setResearchSupervisor(Researcher researchSupervisor) {
        this.researchSupervisor = researchSupervisor;
    }

    public Vector<Researcher> getParticipants() {
        return participants;
    }

    public void setParticipants(Vector<Researcher> participants) {
        this.participants = participants;
    }

    public void joinProject(Researcher researcher) {
    }
}
