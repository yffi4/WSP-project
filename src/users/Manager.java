package users;




import enums.ManagerType;
import utils.FundingRequest;
import utils.Report;

import java.util.Vector;




import academicUtilites.Course;


import utils.News;

public class Manager extends Employee {
    private ManagerType managerType;
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

    public Report createStatisticalReport() {
        // TODO
        return null;
    }

    public Vector<User> viewStudentsAndTeachers() {
        // TODO
        return null;
    }

    public boolean approveFunding(FundingRequest fr) {
        // TODO
        return false;
    }
}
