package menu.actions;
import users.Student;
import users.Teacher;
import users.Researcher;
import academicUtilites.Course;
import academicUtilites.GradeReport;
import papers.ResearchProject;
import java.util.Vector;
import utils.UserInput;
public class StudentActions extends CommonActions {
    private final Student student;

    public StudentActions(Student student) {
        super(student);
        this.student =student;
    }

    public MenuAction viewGPA() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View GPA";
            }

            @Override
            public void execute() {
                System.out.println("Your current GPA: " + student.getGPA());
            }
        };
    }

    public MenuAction viewCourses() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View My Courses";
            }

            @Override
            public void execute() {
                Vector<Course> courses = student.ViewMyCourses();
                if (courses.isEmpty()) {
                    System.out.println("You are not enrolled in any courses yet!");
                    return;
                }

                System.out.println("Your courses:");
                courses.forEach(course -> System.out.println("- " + course));
            }
        };
    }

    public MenuAction registerForCourse() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Register for Course";
            }

            @Override
            public void execute() throws Exception {
                Vector<Course> availableCourses = student.viewCourse();
                if (availableCourses == null || availableCourses.isEmpty()) {
                    System.out.println("No courses available for registration");
                    return;
                }

                System.out.println("Available courses:");
                for (int i = 0; i < availableCourses.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, availableCourses.get(i));
                }

                int courseIndex = Integer.parseInt(UserInput.getText("Select course number (0 to cancel):"));
                if (courseIndex == 0) return;

                if (courseIndex < 1 || courseIndex > availableCourses.size()) {
                    System.out.println("Invalid course selection");
                    return;
                }

                Course selectedCourse = availableCourses.get(courseIndex - 1);
                student.RegisterForCourse(selectedCourse);
            }
        };
    }

    public MenuAction viewMarks() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Marks";
            }

            @Override
            public void execute() {
                Vector<GradeReport> grades = student.ViewMarks();
                if (grades.isEmpty()) {
                    System.out.println("No grades available yet");
                    return;
                }

                System.out.println("Your grades:");
                grades.forEach(grade -> System.out.println(grade));
            }
        };
    }

    public MenuAction viewTranscript() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Transcript";
            }

            @Override
            public void execute() {
                Vector<GradeReport> transcript = student.viewTranscript();
                if (transcript.isEmpty()) {
                    System.out.println("No transcript records available");
                    return;
                }

                System.out.println("Your transcript:");
                transcript.forEach(report -> System.out.println(report));
            }
        };
    }

    public MenuAction rateTeacher() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Rate Teacher";
            }

            @Override
            public void execute() throws Exception {
                Vector<Teacher> teachers = student.viewTeacher();
                if (teachers.isEmpty()) {
                    System.out.println("No teachers available to rate");
                    return;
                }

                System.out.println("Select teacher to rate:");
                for (int i = 0; i < teachers.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, teachers.get(i));
                }

                int teacherIndex = Integer.parseInt(UserInput.getText("Select teacher number (0 to cancel):"));
                if (teacherIndex == 0) return;

                if (teacherIndex < 1 || teacherIndex > teachers.size()) {
                    System.out.println("Invalid teacher selection");
                    return;
                }

                int rating = Integer.parseInt(UserInput.getText("Enter rating (0-5):"));
                if (rating < 0 || rating > 5) {
                    System.out.println("Invalid rating. Please enter a number between 0 and 5");
                    return;
                }

                Teacher selectedTeacher = teachers.get(teacherIndex - 1);
                student.RateTeacher(selectedTeacher, rating);
                System.out.println("Teacher has been rated successfully");
            }
        };
    }

    public MenuAction viewDiplomaProject() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Diploma Project";
            }

            @Override
            public void execute() {
                ResearchProject diplomaProject = student.getDiplomaProject();
                if (diplomaProject == null) {
                    System.out.println("You don't have a diploma project yet");
                    return;
                }

                System.out.println("Your diploma project:");
                System.out.println(diplomaProject);
            }
        };
    }

    public MenuAction pickResearchSupervisor() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Pick Research Supervisor";
            }

            @Override
            public void execute() throws Exception {
                Vector<Teacher> teachers = student.viewTeacher();
                if (teachers.isEmpty()) {
                    System.out.println("No teachers available");
                    return;
                }

                System.out.println("Available teachers:");
                for (int i = 0; i < teachers.size(); i++) {
                    // Simply list all teachers since we can't check for Researcher type
                    System.out.printf("%d. %s%n", i + 1, teachers.get(i));
                }

                int teacherIndex = Integer.parseInt(UserInput.getText("Select teacher number (0 to cancel):"));
                if (teacherIndex == 0) return;

                if (teacherIndex < 1 || teacherIndex > teachers.size()) {
                    System.out.println("Invalid teacher selection");
                    return;
                }

                Researcher researcher = teachers.get(teacherIndex - 1).getResearcherStatus();
                if (researcher == null) {
                    System.out.println("Selected teacher is not a researcher");
                    return;
                }

                student.pickResearcherSupervisor(researcher);
                System.out.println("Research supervisor has been assigned successfully");
            }
        };
    }

    public MenuAction createStudentOrganization() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Create Student Organization";
            }

            @Override
            public void execute() throws Exception {
                String organizationName = UserInput.getText("Enter organization name:");
                student.startOrganisation(organizationName);
                System.out.println("Student organization created successfully");
            }
        };
    }
}
