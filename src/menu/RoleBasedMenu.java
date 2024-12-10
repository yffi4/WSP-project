package menu;


import enums.Options;
import enums.UserType;
import users.User;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;



public class RoleBasedMenu {
    private final Map<Options, Runnable> managerMenu = new HashMap<>();
    private final Map<Options, Runnable> teacherMenu = new HashMap<>();
    private final Map<Options, Runnable> studentMenu = new HashMap<>();
    private final Map<Options, Runnable> researcherMenu = new HashMap<>();
    private final Map<Options, Runnable> adminMenu = new HashMap<>();

    public RoleBasedMenu() {
        // Инициализация меню для разных ролей
        managerMenu.put(Options.VIEW_STUDENTS, this::viewStudents);
        managerMenu.put(Options.VIEW_COURSES, this::viewCourses);
        managerMenu.put(Options.ASSIGN_COURSE, this::assignCourse);
        managerMenu.put(Options.MANAGE_NEWS, this::manageNews);

        teacherMenu.put(Options.VIEW_COURSES, this::viewCourses);
        teacherMenu.put(Options.VIEW_MARKS, this::viewMarks);
        teacherMenu.put(Options.PUT_MARKS, this::putMarks);

        studentMenu.put(Options.VIEW_COURSES, this::viewCourses);
        studentMenu.put(Options.VIEW_MARKS, this::viewMarks);
        studentMenu.put(Options.SEND_COMPLAINT, this::sendComplaint);

        researcherMenu.put(Options.VIEW_PROJECTS, this::viewProjects);
        researcherMenu.put(Options.PUBLISH_PAPER, this::publishPaper);

        adminMenu.put(Options.VIEW_STUDENTS, this::viewStudents);
        adminMenu.put(Options.ADD_STUDENT, this::addStudent);
        adminMenu.put(Options.REMOVE_STUDENT, this::removeStudent);
    }

    public void run(User role) {
        Scanner scanner = new Scanner(System.in);
         // Получаем роль пользователя
        Map<Options, Runnable> menu = getMenuForRole(role);

        while (true) {
            displayMenu(menu, role);
            System.out.print("Choose an option (or type EXIT to exit): ");
            String choice = scanner.nextLine();

            if (choice.equals(Options.EXIT)) {
                System.out.println("Exiting menu. Goodbye!");
                break;
            }

            processOption(menu, Integer.parseInt(choice));
        }
    }

    private void displayMenu(Map<Options, Runnable> menu, UserType role) {
        System.out.println("\nMenu for " + role + ":");
        int index = 1;
        for (Options option : menu.keySet()) {
            System.out.printf("%d. %s%n", index++, option.getDescription());
        }
    }

    private void processOption(Map<Options, Runnable> menu, int choice) {
        if (choice < 1 || choice > menu.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Options selectedOption = (Options) menu.keySet().toArray()[choice - 1];
        Runnable action = menu.get(selectedOption);

        if (action != null) {
            action.run();
        } else {
            System.out.println("Action not defined.");
        }
    }

    private Map<Options, Runnable> getMenuForRole(UserType role) {
        switch (role) {
            case MANAGER: return managerMenu;
            case TEACHER: return teacherMenu;
            case STUDENT: return studentMenu;
            case RESEARCHER: return researcherMenu;
            case ADMIN: return adminMenu;
            default: return new HashMap<>();
        }
    }

    // Примеры действий
    private void viewStudents() {
        System.out.println("Displaying list of students...");
    }

    private void viewCourses() {
        System.out.println("Displaying list of courses...");
    }

    private void assignCourse() {
        System.out.println("Assigning a course to a teacher...");
    }

    private void addStudent() {
        System.out.println("Adding a new student...");
    }

    private void removeStudent() {
        System.out.println("Removing a student...");
    }

    private void viewProjects() {
        System.out.println("Displaying research projects...");
    }

    private void publishPaper() {
        System.out.println("Publishing a research paper...");
    }

    private void sendComplaint() {
        System.out.println("Sending a complaint...");
    }

    private void viewMarks() {
        System.out.println("Viewing marks...");
    }

    private void putMarks(){
        System.out.println("Put marks...");

    }
    private void manageNews(){
        System.out.println("Manage news...");
    }
}

