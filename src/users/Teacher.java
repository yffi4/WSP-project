package users;




import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;


import Database.Database;
import academicUtilites.Course;
import academicUtilites.GradeBook;
import academicUtilites.Mark;
import enums.Faculty;
import enums.MarkType;
import enums.TeacherType;
import factories.UserFactory;
import menu.MenuManager;
import permissions.CanViewCourse;
import permissions.CanViewStudents;
import utils.Complaint;
import utils.Request;

import javax.xml.crypto.Data;

public class Teacher extends Employee implements CanViewCourse, CanViewStudents, CanBecomeResearcher, CanSendRequests {
    private Integer teacherId;
    private Faculty faculty;
    private TeacherType teacherType;
    private Vector<Double> ratings;
    private Researcher researcherStatus;
    public Teacher(String firstName, String lastName, Faculty faculty, TeacherType teacherType) {
        super(firstName, lastName);
        this.faculty = faculty;
        this.teacherType = teacherType;
        this.ratings = new Vector<>();
    }


    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public TeacherType getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    public Vector<Double> getRatings() {
        return ratings;
    }

    public void setRatings(Vector<Double> ratings) {
        this.ratings = ratings;
    }

    
    public double getRaiting() {
        // TODO
        double sum = 0.0;
        for (double rating : ratings){
            sum += rating;

        }
        if (ratings.isEmpty()){
            return 0.0;
        }else return sum / ratings.size();
    }

    

	

	

	

    public Teacher(String name, String lastName) {
        super(name, lastName);
    }




    //                          Operations                                  
    
    /**
    * @generated
    */
    public void putMarks(Course course, Student student, double newMark, MarkType markType) {
        Mark mark = new Mark();
        if (course.getEnrolledStudents().contains(student)){
            if (markType == MarkType.FIRST_ATT){
                mark.setFirstAttestation(newMark);
            }
        } else if (markType == MarkType.SECOND_ATT) {
            mark.setSecondAttestation(newMark);
        }else {
            mark.setFinalExam(newMark);
        }
    }
    
    /**
    * @generated
    */
//    public double getRaiting() {
//        return null;
//    }
    
    /**
    * @generated
    */
    public void markAttendance(Course course, Vector<Student> students, boolean present) {
        if (!present){
            return;
        }

        for (Student student:students){
            if (!course.getEnrolledStudents().contains(student)){
                continue;
            }

            course.getGradeBook()
                    .computeIfAbsent(student, k-> new GradeBook())
                    .getAttendanceList()
                    .add(new Date());
        }


    }
    
    /**
    * @generated
    */
    public void sendComplaint(Complaint complaint) {
        Database.DATA.getOffices().get(complaint.getStudent().getFaculty()).getComplaints().add(complaint);
    }


    @Override
    public Vector<Course> viewCourse() {
        Vector<Course> courses = new Vector<>();
        Database.DATA.getCourses().stream()
                .filter(course -> course.getYear() == Database.DATA.getYear() && course.getPeriod() == Database.DATA.getPeriod())
                .forEach(course -> {
                    if (course.getLessons().stream().anyMatch(lesson -> lesson.getInstructor().equals(this)) && !courses.contains(course)){
                        courses.add(course);
                    }
                });
        return courses;
    }


    @Override
    public Vector<Student> viewStudent() {
        return null;
    }

    @Override
    public Vector<Student> viewStudent(Comparator<Student> comparator) {
        Vector<Student> students = viewStudent();
        students.sort(comparator);
        return students;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    @Override
    public void becomeResearcher() {
        this.researcherStatus = (Researcher) new UserFactory().getUser(this);
    }

    @Override
    public void deleteResearchAccount() {
        Database.DATA.getResearchers().remove(researcherStatus);

    }

    @Override
    public void sendRequest(String request) {
        Database.DATA.getRector().getRequests().add(new Request(request, this));
    }

    @Override
    public void run() throws IOException {
        new MenuManager(this).run();
    }
}
