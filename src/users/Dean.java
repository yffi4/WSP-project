package users;

import java.util.Vector;

import utils.Complaint;
import utils.Request;
import users.Proposal;

public abstract class Dean{
    private Vector<Request> requests;
    private Vector<Proposal> proposals;
    private String department;
    private Vector<Complaint> complaints;

    private Vector<Request> getRequests() {
        return this.requests;
    }

    private void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }

    private Vector<Proposal> getProposals() {
        return this.proposals;
    }

    private void setProposals(Vector<Proposal> proposals) {
        this.proposals = proposals;
    }

    private String getDepartment() {
        return this.department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    private Vector<Complaint> getComplaints() {
        return this.complaints;
    }

    private void setComplaints(Vector<Complaint> complaints) {
        this.complaints = complaints;
    }

    public void signRequest(Request req) {
        // TODO implement logic
    }

    public boolean verifyProposal(Proposal prop) {
        // TODO implement logic
        return false;
    }

    public Vector<Request> viewRequests() {
        // TODO implement logic
        return null;
    }

    public void rejectRequest(Request req) {
        // TODO implement logic
    }

    public Vector<Complaint> viewComplaint() {
        // TODO implement logic
        return null;
    }
}