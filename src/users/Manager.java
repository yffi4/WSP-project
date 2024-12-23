package users;




import Database.Database;
import academicUtilites.Subject;
import enums.ManagerType;
import menu.MenuManager;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import permissions.CanViewTeachers;
import utils.FundingRequest;
import utils.Report;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;


import academicUtilites.Course;


import utils.News;
import utils.Request;

import static factories.CourseFactory.getCourse;

public class Manager extends Employee implements CanViewCourse, CanViewStudents, CanViewTeachers, Serializable {
    private ManagerType managerType;
    private Vector<FundingRequest> fundingRequests;


    public Manager(String name, String lastName) {
        super(name, lastName);
        this.managerType = ManagerType.OR;
    }

    public Manager(String name, String lastName, ManagerType role){
        super(name, lastName);
        this.managerType = role;
    }

    @Override
    public void run() throws IOException {
        new MenuManager(this).run();
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
        List<Course> courses = Database.DATA.getCourses();
        List<Teacher> teachers = Database.DATA.getTeachers();

        if (courses.isEmpty() || teachers.isEmpty()) {
            System.out.println("No courses or teachers available for assignment.");
            return;
        }

        Iterator<Teacher> teacherIterator = teachers.iterator();
        for (Course course : courses) {
            if (!teacherIterator.hasNext()) {
                teacherIterator = teachers.iterator();
            }
            Teacher teacher = teacherIterator.next();
            System.out.println("Assigned teacher: " + teacher.getName() + " to the course: " + course.getName());
            Database.DATA.getLogs().add("Assigned " + teacher.getName() + " to " + course.getName());
        }
    }
    
    /**
    * @generated
    */
    public void assignStudentRegistration() {
        Vector<Student> students = Database.DATA.getStudents();
        if (students.isEmpty()){
            System.out.println("No students available for registration.");
            return;
        }
        for (Student student : students) {
            student.setRegistired(true); // Регистрируем студента

            // Логируем процесс регистрации
            Database.DATA.getLogs().add("Manager " + this.getName() + " assigned registration for student: " + student.getName());
        }

        System.out.println("All students have been successfully registered.");
    }
    public void addNews(News news) {
        Database.DATA.getNews().add(news);
    }
    
    /**
    * @generated
    */
    public void manageNews(String title, String content) {
        if (title == null || content == null) {
            throw new IllegalArgumentException("News title or content cannot be null");
        }
        News news = new News(title, content);
        Database.DATA.getNews().add(news);
        Database.DATA.getLogs().add("Manager " + this.getName() + " added news: " + title);

    }
    public String generateStudentReport(Student student) {
        if (student == null) {
            return "Student not specified";
        }
        long retakeCount = student.viewTranscript().stream()
                .filter(record -> "F".equals(record.getMark().getLetterGPA()))
                .count();
        return "Student Report: " + student.getName() + " " + student.getLastName() +
                "\nGPA: " + student.getGpa() + "\nRetakes: " + retakeCount;
    }

    public Report createStatisticalReport() {

        int studentCount = Database.DATA.getStudents().size();
        int courseCount = Database.DATA.getCourses().size();

        Report report = new Report();
        report.setTitle("Statistical Report");
        report.setDescription("Total students: " + studentCount + ", Total courses: " + courseCount);

        Database.DATA.getLogs().add("Manager " + this.getName() + " created a statistical report.");
        return report;
    }

    public Vector<User> viewStudentsAndTeachers() {
        // TODO
        Vector<User> users = new Vector<>();
        users.addAll(Database.DATA.getStudents());
        users.addAll(Database.DATA.getTeachers());
        return users;
    }

    public static boolean approveFunding(FundingRequest request) {
        // TODO
        if (request == null || request.getAmount() <= 0 || request.getDescription() == null) {
            return false;
        }
        request.setApproved(true);
        Database.DATA.getLogs().add("Approved funding request: " + request.getDescription());
        return true;
    }



    @Override
    public int compareTo(User o) {
        return 0;
    }

    @Override
    public void becomeResearcher() {

    }

    @Override
    public void deleteResearchAccount() {

    }

    @Override
    public Vector<Course> viewCourse() {
        return Database.DATA.getCourses();
    }

    @Override
    public Vector<Student> viewStudent() {
        return Database.DATA.getStudents();
    }

    @Override
    public Vector<Student> viewStudent(Comparator<Student> comparator) {
        Vector<Student> students = viewStudent();
        students.sort(comparator);
        return students;
    }
    public void addCourses(HashMap<Subject, Integer> subjects) {
        for (Subject subject : subjects.keySet()) {
            int courseLimit = subjects.get(subject);
            Course newCourse = getCourse(subject, courseLimit);
            Database.DATA.getCourses().add(newCourse);
        }
    }

    @Override
    public Vector<Teacher> viewTeacher() {
        return Database.DATA.getTeachers();
    }

    @Override
    public Vector<Teacher> viewTeacher(Comparator<Teacher> comparator) {
        Vector<Teacher> teachers = viewTeacher();
        teachers.sort(comparator);
        return teachers;
    }
}
