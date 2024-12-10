package users;

import java.util.Vector;

import utils.Proposal;


import java.util.Vector;



import utils.Complaint;
import utils.Request;



public class Dean extends Employee {
    private Vector<Request> requests;
    private Vector<Proposal> proposals;
    private String department;
    private Vector<Complaint> complaints;

    


    

    

    public Dean(String name, String lastName) {
        super(name, lastName);
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


    
    public void SignRequest() {


    }

    public boolean verifyProposal(Proposal prop) {
        // TODO: Implement logic for verifying a proposal
        return false;
    }

    public Vector<Request> viewRequests() {
        // TODO: Implement logic for viewing requests
        return null;
    }


    

    
    /**
    * @generated
    */
    public void rejectRequest() {
        //TODO


    }

    public Vector<Complaint> viewComplaint() {
        // TODO: Implement logic for viewing complaints
        return null;
    }
}
