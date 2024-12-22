package menu.actions;

import Database.Database;
import enums.Faculty;
import enums.ManagerType;
import enums.TeacherType;
import enums.UserType;
import users.Employee;
import utils.UserInput;
import users.Admin;
public class AdminActions extends EmployeeActions {
    private final Admin admin;

    public AdminActions(Admin admin) {
        super(admin);
        this.admin = admin;
    }

    public MenuAction addUser() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Add New User";
            }

            @Override
            public void execute() throws Exception {
                String firstName = UserInput.getText("Enter first name:");
                String lastName = UserInput.getText("Enter last name:");

                System.out.println("Select role:\n1. Manager\n2. Admin\n" +
                        "3. Student\n4. Dean\n5. Teacher\n6. Researcher\n7. Master\n 8.PhD student");

                int roleChoice = Integer.parseInt(UserInput.getText("Choose role:"));
                UserType role = UserType.values()[roleChoice - 1];

                if (role == UserType.STUDENT || role == UserType.PHD ||
                        role == UserType.MASTER || role == UserType.RESEARCHER ||
                        role == UserType.TEACHER) {

                    System.out.println("Select faculty: 1.SITE 2.BS 3.SAM 4.SEPI 5.SG 6.SMSGT 7.SCE 8.ISE 9.KMA");
                    int facultyChoice = Integer.parseInt(UserInput.getText("Choose faculty:"));
                    Faculty faculty = Faculty.values()[facultyChoice - 1];

                    if (role != UserType.TEACHER) {
                        admin.addUser(firstName, lastName, role, faculty);
                    } else {
                        System.out.println("Select teacher type:\n1. PROFESSOR\n2. TUTOR\n3. LECTOR\n4. SENIOR_LECTURER");
                        int teacherTypeChoice = Integer.parseInt(UserInput.getText("Choose type:"));
                        TeacherType teacherType = TeacherType.values()[teacherTypeChoice - 1];
                        admin.addUser(firstName, lastName, faculty, teacherType);
                    }
                } else if (role == UserType.MANAGER) {
                    System.out.println("Manager type:\n1. OR Manager\n2. Department Manager");
                    int managerTypeChoice = Integer.parseInt(UserInput.getText("Choose type:"));
                    ManagerType managerType = ManagerType.values()[managerTypeChoice - 1];
                    admin.addUser(firstName, lastName, managerType);
                } else {
                    admin.addUser(firstName, lastName, role);
                }
                Database.write();
                System.out.println("User added successfully");
            }
        };
    }

    public MenuAction removeUser() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Remove User";
            }

            @Override
            public void execute() throws Exception {
                String username = UserInput.getText("Enter username to remove:");
                admin.removeUser(username);
                System.out.println("User removed successfully");
            }
        };
    }

    public MenuAction viewLogs() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View System Logs";
            }

            @Override
            public void execute() {
                System.out.println(admin.viewLogs());
            }
        };
    }
}
