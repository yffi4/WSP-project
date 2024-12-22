package menu;
import Database.Database;
import menu.actions.*;
import users.Admin;
import users.Employee;
import users.Teacher;
import users.User;
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
        } else if (user instanceof Employee) {
            EmployeeActions employeeActions = new EmployeeActions((Employee)user);
            actions.putAll(getEmployeeActions(employeeActions));
        } else {
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

    private Map<Integer, MenuAction> getEmployeeActions(EmployeeActions actions) {
        Map<Integer, MenuAction> map = getCommonActions(actions);
        map.put(5, actions.sendMessage());
        map.put(6, actions.sendRequest());
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
