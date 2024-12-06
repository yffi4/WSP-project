package users

diagram;


/**
* @generated
*/
public class Dean extends Employee {
    
    /**
    * @generated
    */
    private Vector<Request> requests;
    
    /**
    * @generated
    */
    private Vector<Proposal> proposals;
    
    /**
    * @generated
    */
    private String department;
    
    /**
    * @generated
    */
    private Vector<Complaint> complaints;
    
    
    
    /**
    * @generated
    */
    private Vector<Request> getRequests() {
        return this.requests;
    }
    
    /**
    * @generated
    */
    private Vector<Request> setRequests(Vector<Request> requests) {
        this.requests = requests;
    }
    
    /**
    * @generated
    */
    private Vector<Proposal> getProposals() {
        return this.proposals;
    }
    
    /**
    * @generated
    */
    private Vector<Proposal> setProposals(Vector<Proposal> proposals) {
        this.proposals = proposals;
    }
    
    /**
    * @generated
    */
    private String getDepartment() {
        return this.department;
    }
    
    /**
    * @generated
    */
    private String setDepartment(String department) {
        this.department = department;
    }
    
    /**
    * @generated
    */
    private Vector<Complaint> getComplaints() {
        return this.complaints;
    }
    
    /**
    * @generated
    */
    private Vector<Complaint> setComplaints(Vector<Complaint> complaints) {
        this.complaints = complaints;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void SignRequest() {
        //TODO
        return null;
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
        return null;
    }
    
    /**
    * @generated
    */
    public Vector<Complaint> viewComplaint() {
        //TODO
        return null;
    }
    
    
}
