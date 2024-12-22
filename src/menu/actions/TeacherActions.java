package menu.actions;

import academicUtilites.Course;
import enums.MarkType;
import enums.Urgency;
import users.Student;
import users.Teacher;
import utils.Complaint;
import utils.UserInput;

import java.util.StringTokenizer;
import java.util.Vector;

public class TeacherActions extends EmployeeActions{
    private final Teacher teacher;

    public TeacherActions(Teacher teacher) {
        super(teacher);
        this.teacher = teacher;
    }

    public MenuAction viewRating() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Teaching Rating";
            }

            @Override
            public void execute() {
                System.out.println("Your current rating: " + teacher.getRaiting());
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
            public void execute() throws Exception {
                var courses = teacher.viewCourse();
                if (courses.isEmpty()) {
                    System.out.println("You don't have any courses yet!");
                    return;
                }

                System.out.println("Your courses:");
                courses.forEach(course -> System.out.println("- " + course));
            }
        };
    }

    public MenuAction sendComplaint() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Send Student Complaint";
            }

            @Override
            public void execute() throws Exception {
                Vector<Student> students = teacher.viewStudent();
                if (students.isEmpty()) {
                    System.out.println("No students available");
                    return;
                }

                // Показываем список студентов
                System.out.println("Select student:");
                for (int i = 0; i < students.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, students.get(i));
                }

                // Выбор студента
                int studentIndex = Integer.parseInt(UserInput.getText("Enter student number:")) - 1;
                if (studentIndex < 0 || studentIndex >= students.size()) {
                    System.out.println("Invalid student selection");
                    return;
                }

                Student selectedStudent = students.get(studentIndex);

                // Содержание жалобы
                String complaintText = UserInput.getText("Enter complaint description:");

                // Выбор срочности
                System.out.println("Select urgency level:");
                System.out.println("1. HIGH");
                System.out.println("2. MEDIUM");
                System.out.println("3. LOW");

                int urgencyChoice = Integer.parseInt(UserInput.getText("Choose urgency (1-3):"));
                if (urgencyChoice < 1 || urgencyChoice > 3) {
                    System.out.println("Invalid urgency level");
                    return;
                }

                Urgency urgency = Urgency.values()[urgencyChoice - 1];
                Complaint complaint = new Complaint(complaintText, teacher, selectedStudent, urgency);

                teacher.sendComplaint(complaint);
                System.out.println("Complaint has been submitted successfully");
            }
        };
    }

    public MenuAction putMarks()  {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Put Student Marks";
            }

            @Override
            public void execute() throws Exception {
                Course course = new Course();
                Vector<Course> courses = teacher.viewCourse();
                Vector<Student> students = course.getEnrolledStudents();

                System.out.println("Select a course: ");
                for (int i = 0; i < courses.size(); i++){
                    System.out.println(i + 1 + " " + courses.get(i));
                }
                int courseIndex = Integer.parseInt(UserInput.getText("Enter number")) - 1;
                Course selectedCourse = courses.elementAt(courseIndex);
                if (students.isEmpty()) {
                    System.out.println("No students available");
                    return;
                }

                // Показываем список студентов
                System.out.println("Available students:");
                for (int i = 0; i < students.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, students.get(i));
                }

                int studentIndex = Integer.parseInt(UserInput.getText("Select student (0 to cancel):"));
                if (studentIndex == 0) return;

                if (studentIndex < 1 || studentIndex > students.size()) {
                    System.out.println("Invalid student selection");
                    return;
                }

                Student selectedStudent = students.get(studentIndex - 1);
                double mark = Double.parseDouble(UserInput.getText("Enter mark (0-100):"));

                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid mark value");
                    return;
                }
                System.out.println("Select mark type (1: FIRST_ATT, 2: SECOND_ATT, 3: FINAL_EXAM): ");
                int markIndex = Integer.parseInt(UserInput.getText("Enter number:"));
                MarkType markType = MarkType.values()[markIndex - 1];

                teacher.putMarks(selectedCourse, selectedStudent, mark, markType);
                System.out.println("Mark has been recorded successfully");
            }
        };
    }

    public MenuAction markAttendance() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Mark Student Attendance";
            }

            @Override
            public void execute() throws Exception {
                Vector<Course> courses = teacher.viewCourse();
                Vector<Student> students = teacher.viewStudent();
                System.out.println("Select course:");
                for (int i = 0; i < courses.size(); i++){
                    System.out.println(i + 1 + " " + courses.get(i));
                }
                int courseIndex = Integer.parseInt(UserInput.getText("Enter number")) - 1;
                Course selectedCourse = teacher.viewCourse().elementAt(courseIndex);
                if (students.isEmpty()) {
                    System.out.println("No students available");
                    return;
                }

                System.out.println("Mark attendance for students:");
                for (int i = 0; i < students.size(); i++){
                    System.out.println(i + 1 + " " + students.get(i));
                }
                String studentIndex = UserInput.getText("Write number or All to print student");
                Vector<Student> selectedStudents = new Vector<>();
                if (studentIndex.equals("All")){
                    selectedStudents = students;
                }else {
                    StringTokenizer stringTokenizer = new StringTokenizer(UserInput.getText("Number"), " ");
                    while (stringTokenizer.hasMoreTokens()){
                        selectedStudents.add(students.elementAt(Integer.parseInt(stringTokenizer.nextToken()) - 1));
                    }
                }
                teacher.markAttendance(selectedCourse, selectedStudents, true);
                System.out.println("Attendance has been marked for all students");
            }
        };
    }

    public MenuAction viewStudents() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Student List";
            }

            @Override
            public void execute() throws Exception {
                Vector<Student> students = teacher.viewStudent();
                if (students.isEmpty()) {
                    System.out.println("No students available");
                    return;
                }

                System.out.println("Your students:");
                students.forEach(student -> System.out.println("- " + student));
            }
        };
    }
}
