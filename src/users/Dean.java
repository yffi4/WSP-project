package users;

import java.util.Vector;

import utils.Complaint;
import utils.Request;

/**
 * Dean class extending Employee.
 * Make sure Employee and User classes are not abstract or have all abstract methods implemented.
 */
public class Dean extends Employee {
    private Vector<Request> requests;
    private Vector<Proposal> proposals;
    private String department;
    private Vector<Complaint> complaints;

    // Getters/Setters (make them public if needed)
    public Vector<Request> getRequests() {
        return this.requests;
    }

    public void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }

    public Vector<Proposal> getProposals() {
        return this.proposals;
    }

    public void setProposals(Vector<Proposal> proposals) {
        this.proposals = proposals;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Vector<Complaint> getComplaints() {
        return this.complaints;
    }

    public void setComplaints(Vector<Complaint> complaints) {
        this.complaints = complaints;
    }

    // Methods according to the UML diagram:
    public void signRequest(Request req) {
        // TODO: Implement logic for signing a request
    }

    public boolean verifyProposal(Proposal prop) {
        // TODO: Implement logic for verifying a proposal
        return false;
    }

    public Vector<Request> viewRequests() {
        // TODO: Implement logic for viewing requests
        return null;
    }

    public void rejectRequest(Request req) {
        // TODO: Implement logic for rejecting a request
    }

    public Vector<Complaint> viewComplaint() {
        // TODO: Implement logic for viewing complaints
        return null;
    }
}
