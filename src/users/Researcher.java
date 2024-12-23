package users;


import Database.Database;
import comporators.CitationResearchPaperComparator;
import enums.Faculty;
import journal.Journal;
import menu.MenuManager;
import papers.ResearchPaper;
import papers.ResearchProject;
import utils.FundingRequest;
import utils.Post;
import utils.Request;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Vector;


/**
* @generated
*/

public class Researcher extends User implements CanSendRequests, CanResearch, Serializable {
    private Integer ResearcherId;
    private Faculty faculty;
    private static final long serialVersionUID = -3766625341558875458L;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Integer getResearcherId() {
        return ResearcherId;
    }

    public void setResearcherId(Integer researcherId) {
          this.ResearcherId = researcherId;
    }

    public Researcher(String name, String lastName) {
        super(name, lastName);
    }
    public Researcher(String name, String lastName, Faculty faculty){
        super(name, lastName);
        this.faculty = faculty;
        Database.DATA.getResearchers().add(this);

    }

    @Override
    public void update(Post p) {

    }

    @Override
    public void run() throws IOException {
        new MenuManager(this).run();
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

    @Override
    public Vector<ResearchPaper> printPaper() {
        Vector< ResearchPaper> papers = Database.DATA.getResearchPapers();
        Vector<ResearchPaper> myPapers = new Vector<>();
        for (ResearchPaper researchPaper : papers){
            if (researchPaper.getAuthors().contains(this)){
                myPapers.add(researchPaper);
            }
        }
        return myPapers;
    }

    @Override
    public int calculateIndex() {
        Vector<ResearchPaper> myPapers = printPaper();
        myPapers.sort(new CitationResearchPaperComparator());
        int n = myPapers.size();
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (myPapers.elementAt(i).getCitations() >= h) {
                return h;
            }
        }
        return 0;

    }

    @Override
    public void publishPaper(String title, Vector<Researcher> authors, Vector<String> pages, Journal journal) {
        ResearchPaper researchPaper = new ResearchPaper(title, authors, pages, journal);
        Database.DATA.getResearchPapers().add(researchPaper);
        journal.publish(researchPaper);
    }

    @Override
    public void proposeProject(String name, Vector<Researcher> team, Vector<ResearchPaper> publishedPapers) {
        try {
            ResearchProject researchProject = new ResearchProject(name, this, publishedPapers, team);
            Database.DATA.getResearchProjects().add(researchProject);
            System.out.println("Research project successfully added.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid arguments provided for creating the research project. " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Missing required data for the research project. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while adding the research project: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public FundingRequest requestFunding(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Funding amount must be greater than zero.");
            return null;
        }

        try {

            FundingRequest fundingRequest = new FundingRequest(amount, this);


            boolean isApproved = Manager.approveFunding(fundingRequest);

            if (isApproved) {
                fundingRequest.setApproved(true);
                Database.DATA.getFundingRequests().add(fundingRequest);
                System.out.println("Funding approved successfully.");
            } else {
                fundingRequest.setApproved(false);
                System.out.println("Funding request was not approved.");
            }

            return fundingRequest;
        } catch (Exception e) {
            System.out.println("An error occurred while processing the funding request: " + e.getMessage());
            e.printStackTrace(); // Optional for debugging
            return null;
        }
    }

    @Override
    public void sendRequest(String request) {
        Database.DATA.getRector().getRequests().add(new Request(request, this));
    }
}
