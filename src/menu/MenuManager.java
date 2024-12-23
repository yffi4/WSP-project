package menu;
import Database.Database;
import menu.actions.*;
import users.*;
import utils.UserInput;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuManager {
    private final Map<Integer, MenuAction> actions = new LinkedHashMap<>();
    private boolean isRunning = true;

    public MenuManager(User user) {
        initializeActions(user);
    }

    private void initializeActions(User user) {
        if (user instanceof Admin) {
            AdminActions adminActions = new AdminActions((Admin)user);
            actions.putAll(getAdminActions(adminActions));
        } else if (user instanceof Teacher) {
            TeacherActions teacherActions = new TeacherActions((Teacher)user);
            actions.putAll(getTeacherActions(teacherActions));
        } else if (user instanceof Student) {
            StudentActions studentActions = new StudentActions((Student)user);
            actions.putAll(getStudentActions(studentActions));
        } else if (user instanceof Employee) {
            EmployeeActions employeeActions = new EmployeeActions((Employee)user);
            actions.putAll(getEmployeeActions(employeeActions));
        }else if (user instanceof Manager) {
            ManagerActions managerActions = new ManagerActions((Manager)user);
            actions.putAll(getManagerActions(managerActions));
        }else if (user instanceof Dean) {
            DeanActors deanActions = new DeanActors((Dean) user);
            actions.putAll(getDeanActions(deanActions));
        }else if (user instanceof Researcher) {

            ResearcherActions researchActions = new ResearcherActions((Researcher) user);
            actions.putAll(getResearcherActions(researchActions));
        }else {
            CommonActions commonActions = new CommonActions(user);
            actions.putAll(getCommonActions(commonActions));
        }
    }


    private Map<Integer, MenuAction> getCommonActions(CommonActions actions) {
        Map<Integer, MenuAction> map = new LinkedHashMap<>();
        map.put(1, actions.viewNews());
        map.put(2, actions.checkNotifications());
        map.put(3, actions.viewResearchPapers());
        map.put(4, actions.manageJournalSubscriptions());
        return map;
    }
    private Map<Integer, MenuAction> getResearcherActions(ResearcherActions actions) {
        Map<Integer, MenuAction> map = getCommonActions(actions);
        map.put(5, actions.publishPaper());
        map.put(6, actions.proposeProject());
        map.put(7, actions.sendRequest());
        map.put(8, actions.requestFunding());
        map.put(9, actions.printPaper());

        return map;
    }

    private Map<Integer, MenuAction> getEmployeeActions(EmployeeActions actions) {
        Map<Integer, MenuAction> map = getCommonActions(actions);
        map.put(5, actions.sendMessage());
        map.put(6, actions.sendRequest());
        return map;
    }
    private Map<Integer, MenuAction> getDeanActions(DeanActors actions) {
        Map<Integer, MenuAction> map = new LinkedHashMap<>();
        map.put(7, actions.viewRequests());
        map.put(8, actions.signRequest());
        map.put(9, actions.rejectRequest());
        map.put(10, actions.verifyProposal());
        map.put(11, actions.viewComplaints());
        return map;
    }

    private Map<Integer, MenuAction> getAdminActions(AdminActions actions) {
        Map<Integer, MenuAction> map = getEmployeeActions(actions);
        map.put(7, actions.addUser());
        map.put(8, actions.removeUser());
        map.put(9, actions.viewLogs());
        return map;
    }
    private Map<Integer, MenuAction> getTeacherActions(TeacherActions actions) {
        Map<Integer, MenuAction> map = getEmployeeActions(actions);
        map.put(7, actions.viewRating());
        map.put(8, actions.viewCourses());
        map.put(9, actions.sendComplaint());
        map.put(10, actions.putMarks());
        map.put(11, actions.markAttendance());
        map.put(12, actions.viewStudents());
        return map;
    }

    private Map<Integer, MenuAction> getStudentActions(StudentActions actions) {
        Map<Integer, MenuAction> map = getCommonActions(actions);
        map.put(5, actions.viewGPA());
        map.put(6, actions.viewCourses());
        map.put(7, actions.registerForCourse());
        map.put(8, actions.viewMarks());
        map.put(9, actions.viewTranscript());
        map.put(10, actions.rateTeacher());
        map.put(11, actions.viewDiplomaProject());
        map.put(12, actions.pickResearchSupervisor());
        map.put(13, actions.createStudentOrganization());
        return map;
    }

    private Map<Integer, MenuAction> getManagerActions(ManagerActions actions) {
        Map<Integer, MenuAction> map = getEmployeeActions(actions);
        map.put(7, actions.assignCoursesToTeachers());
        map.put(8, actions.assignStudentRegistration());
        map.put(9, actions.addNews());
        map.put(10, actions.generateStudentReport());
        map.put(11, actions.createStatisticalReport());
        map.put(12, actions.viewStudentsAndTeachers());
        map.put(13, actions.manageFundingRequests());
        map.put(14, actions.addCourses());
        return map;
    }

    public void run() {
        while (isRunning) {
            try {
                displayMenu();
                handleUserChoice();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Menu ===");
        actions.forEach((key, action) ->
                System.out.printf("%d. %s%n", key, action.getDescription()));
        System.out.println("0. Exit");
    }

    private void handleUserChoice() throws Exception {
        try {


            int choice = Integer.parseInt(UserInput.getText("Select option:"));
            if (choice == 0) {
                isRunning = false;
                Database.write();
                return;
            }

            MenuAction selectedAction = actions.get(choice);
            if (selectedAction != null) {

                selectedAction.execute();
                Database.write();
            } else {
                System.out.println("Invalid option");
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            Database.write();
            throw e;

        }
    }
}
