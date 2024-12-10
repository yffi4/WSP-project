package users;

import enums.ManagerType;
import utils.FundingRequest;
import utils.Report;

import java.util.Vector;




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

    public Manager(String name, String lastName) {
        super(name, lastName);
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public Vector<FundingRequest> getFundingRequests() {
        return fundingRequests;
    }

    public void setFundingRequests(Vector<FundingRequest> fundingRequests) {
        this.fundingRequests = fundingRequests;
    }


    //                          Operations
    
    /**
    * @generated
    */
    public void assignCoursesToTeachers() {

    }
    
    /**
    * @generated
    */
    public void assignStudentRegistration() {

    }
    
    /**
    * @generated
    */
    public void manageNews() {

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
