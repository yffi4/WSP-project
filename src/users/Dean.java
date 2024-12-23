package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import Database.Database;
import menu.MenuManager;
import utils.Post;
import utils.Proposal;


import java.util.Vector;



import utils.Complaint;
import utils.Request;



public class Dean extends Employee implements Serializable {
    private Vector<Request> requests;
    private Vector<Proposal> proposals;
    private String department;
    private Vector<Complaint> complaints;

    private static final long serialVersionUID = 3189906044909095014L;


    

    

    public Dean(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public void run() throws IOException {
        new MenuManager(this).run();
    }

    public Dean() {
        super();
    }

    public Vector<Request> getRequests() {
        return requests;
    }


    public void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }

    public Vector<Proposal> getProposals() {
        return proposals;

    }

    public void setProposals(Vector<Proposal> proposals) {
        this.proposals = proposals;
    }

    public String getDepartment() {

        

        return department;

    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Vector<Complaint> getComplaints() {

        return complaints;

    }

    public void setComplaints(Vector<Complaint> complaints) {
        this.complaints = complaints;
    }


    
    public void SignRequest(Request request) {
        request.isSigned();

    }

    public boolean verifyProposal(Proposal proposal) {
        if (proposal.getTitle() != null && !proposal.getTitle().isEmpty() &&
                proposal.getDescription() != null && proposal.getDescription().length() > 50 &&

                proposal.getSubmissionDate() != null && proposal.getSubmissionDate().before(new Date())) {
            proposal.setApproved(true);
            return true;
        } else {
            proposal.setApproved(false);
            return false;
        }
    }

    public Vector<Request> viewRequests() {
        return Database.DATA.getRector().viewRequests();
    }



    

    
    /**
    * @generated
    */
    public void rejectRequest(Request request) {
        requests.remove(request);
        request.getAuthor().getNotifications().add(new Post("Your request:" +request.getContent() + "was rejected", this));


    }

    public Vector<Complaint> viewComplaint() {
        complaints.sort(null);
        return complaints;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    @Override
    public void becomeResearcher() {

    }

    @Override
    public void deleteResearchAccount() {

    }
}
