package menu.actions;
import academicUtilites.Subject;
import users.Manager;
import users.Student;
import users.User;
import utils.FundingRequest;
import utils.Report;
import utils.UserInput;

import java.util.HashMap;
import java.util.Vector;

public class ManagerActions extends EmployeeActions{
    private final Manager manager;

    public ManagerActions(Manager manager) {
        super(manager);
        this.manager = manager;
    }

    public MenuAction assignCoursesToTeachers() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Assign Courses to Teachers";
            }

            @Override
            public void execute() {
                manager.assignCoursesToTeachers();
            }
        };
    }

    public MenuAction assignStudentRegistration() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Assign Student Registration";
            }

            @Override
            public void execute() {
                manager.assignStudentRegistration();
            }
        };
    }

    public MenuAction addNews() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Add News";
            }

            @Override
            public void execute() throws Exception {
                String title = UserInput.getText("Enter news title:");
                String content = UserInput.getText("Enter news content:");
                manager.manageNews(title, content);
                System.out.println("News added successfully");
            }
        };
    }

    public MenuAction generateStudentReport() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Generate Student Report";
            }

            @Override
            public void execute() throws Exception {
                Vector<Student> students = manager.viewStudent();
                if (students.isEmpty()) {
                    System.out.println("No students available");
                    return;
                }

                System.out.println("Select student:");
                for (int i = 0; i < students.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, students.get(i));
                }

                int studentIndex = Integer.parseInt(UserInput.getText("Enter student number (0 to cancel):")) - 1;
                if (studentIndex == -1) return;

                if (studentIndex < 0 || studentIndex >= students.size()) {
                    System.out.println("Invalid student selection");
                    return;
                }

                Student selectedStudent = students.get(studentIndex);
                String report = manager.generateStudentReport(selectedStudent);
                System.out.println("\nReport:");
                System.out.println(report);
            }
        };
    }

    public MenuAction createStatisticalReport() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Create Statistical Report";
            }

            @Override
            public void execute() {
                Report report = manager.createStatisticalReport();
                System.out.println("\nReport Generated:");
                System.out.println("Title: " + report.getTitle());
                System.out.println("Content: " + report.getDescription());
            }
        };
    }

    public MenuAction viewStudentsAndTeachers() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View All Students and Teachers";
            }

            @Override
            public void execute() {
                Vector<User> users = manager.viewStudentsAndTeachers();
                if (users.isEmpty()) {
                    System.out.println("No users available");
                    return;
                }

                System.out.println("\nStudents and Teachers:");
                users.forEach(user -> System.out.println("- " + user));
            }
        };
    }

    public MenuAction manageFundingRequests() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Manage Funding Requests";
            }

            @Override
            public void execute() {
                Vector<FundingRequest> requests = manager.getFundingRequests();
                if (requests == null || requests.isEmpty()) {
                    System.out.println("No funding requests available");
                    return;
                }

                System.out.println("\nPending Funding Requests:");
                for (int i = 0; i < requests.size(); i++) {
                    FundingRequest request = requests.get(i);
                    if (!request.isApproved()) {
                        System.out.printf("%d. Amount: %f - %s%n",
                                i + 1,
                                request.getAmount(),
                                request.getDescription());
                    }
                }

                try {
                    int requestIndex = Integer.parseInt(UserInput.getText("Select request to approve (0 to cancel):")) - 1;
                    if (requestIndex == -1) return;

                    if (requestIndex >= 0 && requestIndex < requests.size()) {
                        FundingRequest selectedRequest = requests.get(requestIndex);
                        if (manager.approveFunding(selectedRequest)) {
                            System.out.println("Funding request approved successfully");
                        } else {
                            System.out.println("Failed to approve funding request");
                        }
                    } else {
                        System.out.println("Invalid request selection");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }
        };
    }

    public MenuAction addCourses() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Add New Courses";
            }

            @Override
            public void execute() throws Exception {
                HashMap<Subject, Integer> subjects = new HashMap<>();
                boolean addingCourses = true;

                while (addingCourses) {
                    String subjectName = UserInput.getText("Enter subject name (or 'done' to finish):");
                    if (subjectName.equalsIgnoreCase("done")) {
                        break;
                    }

                    try {
                        Subject subject = new Subject(subjectName);
                        int courseLimit = Integer.parseInt(UserInput.getText("Enter course limit:"));
                        if (courseLimit > 0) {
                            subjects.put(subject, courseLimit);
                            System.out.println("Subject added successfully");
                        } else {
                            System.out.println("Course limit must be positive");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid course limit. Please enter a number.");
                    } catch (Exception e) {
                        System.out.println("Error adding subject: " + e.getMessage());
                    }
                }

                if (!subjects.isEmpty()) {
                    manager.addCourses(subjects);
                    System.out.println("All courses added successfully");
                }
            }
        };
    }
}
