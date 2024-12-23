package papers;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import exeptions.InvalidResearchPaperException;
import exeptions.InvalidSupervisorException;
import users.Researcher;

public class ResearchProject implements Serializable {
    private int projectId;
    private String topic;
    private Vector<ResearchPaper> publishedPapers;
    private Researcher researchSupervisor;
    private Vector<Researcher> participants;

    public ResearchProject() {
    }


    public ResearchProject(String topic, Researcher researchSupervisor, Vector<ResearchPaper> publishedPapers, Vector<Researcher> participants) throws InvalidSupervisorException, InvalidResearchPaperException {
        try {
            if(researchSupervisor.calculateIndex()<3) {
                throw new InvalidSupervisorException("Research supervisor must have h-index not less than 3");
            }
            for(ResearchPaper rp: publishedPapers) {
                boolean containsParticipant = false;
                for(Researcher p: participants) {
                    if(rp.getAuthors().contains(p)) {
                        containsParticipant = true;
                        break;
                    }
                }
                if(!containsParticipant) {
                    throw new InvalidResearchPaperException("At least one of the participants must be in author's list");
                }
            }
            this.topic=topic;
            this.researchSupervisor=researchSupervisor;
            this.publishedPapers=publishedPapers;
            this.participants=participants;
        }catch(Exception e) {
            System.out.println(e);
        }
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
    @Override
    public int hashCode() {
        return Objects.hash(researchSupervisor, topic);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResearchProject other = (ResearchProject) obj;
        return Objects.equals(researchSupervisor, other.researchSupervisor) && Objects.equals(topic, other.topic);
    }
}
