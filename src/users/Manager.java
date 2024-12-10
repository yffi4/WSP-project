package users;

import java.util.Vector;

import academicUtilites.Course;
import enums.ManagerType;
import utils.FundingRequest;
import utils.News;

public class Manager extends Employee {
    private ManagerType managerType;
    private Vector<FundingRequest> fundingRequests;

    private ManagerType getManagerType() {
        return this.managerType;
    }

    private void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    private Vector<FundingRequest> getFundingRequests() {
        return this.fundingRequests;
    }

    private void setFundingRequests(Vector<FundingRequest> fundingRequests) {
        this.fundingRequests = fundingRequests;
    }

    public void assignCoursesToTeachers(Vector<Course> courses, Teacher teacher) {
        // TODO
    }

    public void assignStudentRegistration(Student student) {
        // TODO
    }

    public void manageNews(News news) {
        // TODO
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
