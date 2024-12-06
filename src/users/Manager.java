package users

diagram;


/**
* @generated
*/
public class Manager extends Employee {
    
    /**
    * @generated
    */
    private ManagerType managerType;
    
    /**
    * @generated
    */
    private Vector<FundingRequest> fundingRequests;
    
    
    
    /**
    * @generated
    */
    private ManagerType getManagerType() {
        return this.managerType;
    }
    
    /**
    * @generated
    */
    private ManagerType setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }
    
    /**
    * @generated
    */
    private Vector<FundingRequest> getFundingRequests() {
        return this.fundingRequests;
    }
    
    /**
    * @generated
    */
    private Vector<FundingRequest> setFundingRequests(Vector<FundingRequest> fundingRequests) {
        this.fundingRequests = fundingRequests;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void assignCoursesToTeachers() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void assignStudentRegistration() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void manageNews() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public Report createStatisticalReport() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public Vector<User> viewStudentsAndTeachers() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean approveFunding() {
        //TODO
        return false;
    }
    
    
}
