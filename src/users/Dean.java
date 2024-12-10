package users;

import utils.Complaint;
import utils.Proposal;
import utils.Request;

import java.util.Vector;





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

    //                          Operations
    
    /**
    * @generated
    */
    public void SignRequest() {

    }
    
    /**
    * @generated
    */
    public boolean verifyProposal() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public Vector<Request> viewRequests() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void rejectRequest() {
        //TODO

    }
    
    /**
    * @generated
    */
    public Vector<Complaint> viewComplaint() {
        //TODO
        return null;
    }
    
    
}
