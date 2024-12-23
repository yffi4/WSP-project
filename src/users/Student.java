package users;







import Database.Database;
import academicUtilites.Transcript;
import exeptions.InvalidRegistrationException;
import factories.UserFactory;
import menu.MenuManager;
import utils.Post;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;




import academicUtilites.Course;
import academicUtilites.GPA;
import academicUtilites.GradeReport;
import enums.Faculty;
import papers.ResearchProject;
import permissions.CanViewCourse;
import permissions.CanViewTeachers;

public class Student extends User implements CanViewCourse, CanViewTeachers, Serializable {
    private String studentId;
    private Faculty faculty;
    private Researcher researcherSupervisor;
    private Vector<Course> courses;
    private GPA gpa;
    private Researcher researcherStatus;
    {
        this.studentId = Database.DATA.getYear() + "B" + Database.DATA.getStudents().size();
    }

    public Student() {
        this.studentId = "";
        this.faculty = Faculty.UNKNOWN;
        this.researcherSupervisor = null;
        this.courses = new Vector<>();
        this.gpa = new GPA();
    }

    public Student(String name, String lastName) {
        super(name, lastName);
    }

    public Student(String firstName, String lastName, Faculty facultyType) {
        super(firstName, lastName);
    }
    public Student(String studentId, Faculty faculty, Vector<Course> courses, GPA gpa) {
        this.studentId = studentId;
        this.faculty = faculty;
        this.courses = courses;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Researcher getResearcherSupervisor() {
        return researcherSupervisor;
    }

    public void setResearcherSupervisor(Researcher researcherSupervisor) {
        this.researcherSupervisor = researcherSupervisor;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public GPA getGpa() {
        return gpa;
    }

    public void setGpa(GPA gpa) {
        this.gpa = gpa;
    }
    //                          Operations
    
    /**
    * @generated
    */
    public void RegisterForCourse(Course c) throws InvalidRegistrationException, IOException {
        if (c == null) {
            throw new InvalidRegistrationException("Course cannot be null.");
        }
        if (courses.contains(c)) {
            throw new InvalidRegistrationException("Student is already registered for this course: " + c.getName());
        }
        courses.add(c);
        System.out.println("Student registered for course: " + c.getName());
        Database.write();

    }

    public Vector<Course> ViewMyCourses() {
        Vector<Course> myCourses = new Vector<Course>();
        Vector<Course> allCourses = Database.DATA.getCourses();
        for(Course course: allCourses) {
            if(course.getGradeBook().containsKey(this)) {
                myCourses.add(course);
            }
        }
        return myCourses;
    }

    public Vector<GradeReport> ViewMarks() {
        return GradeReport.getGradeReport(this);
    }
    public Vector<GradeReport> viewTranscript(){
        return Transcript.getGradeReport(this);
    }



    
    /**
    * @generated
    */
    public void RateTeacher(Teacher t, Integer rating) {
        t.getRatings().add((double) Math.min(5, Math.max(rating, 0)));
    }
    
    /**
    * @generated
    */
    public void pickResearcherSupervisor(Researcher r) {
        if (r != null){
            this.researcherSupervisor = r;
            System.out.println("Researcher Supervisor assigned: " + r.getName());
        }

    }

    public ResearchProject getDiplomaProject() {
        for (ResearchProject rp : Database.DATA.getResearchProjects()) {
            if (rp.getParticipants().contains(this)) {
                return rp;
            }
        }
        return null;
    }



   
        // TODO

    
    /**
    * @generated
    */
    public void startOrganisation (String name) {
        StudentOrganisations studentOrganisations = new StudentOrganisations();
        studentOrganisations.setHead(this);
        studentOrganisations.setName(name);
        Database.DATA.getStudentOrganisations().add(studentOrganisations);
    }

    public double getGPA() {
        // TODO
        return Transcript.getTotalGPA(viewTranscript());
    }

    public boolean lastYearStudent() {
        // TODO
        return Database.DATA.getYear() == 4;
    }

	@Override
	public Vector<Teacher> viewTeacher() {
		// TODO Auto-generated method stub
		return Database.DATA.getTeachers();
	}

    @Override
    public Vector<Teacher> viewTeacher(Comparator<Teacher> comparator) {
        Vector<Teacher> teachers = viewTeacher();
        teachers.sort(comparator);
        return teachers;
    }


    @Override
	public Vector<Course> viewCourse() {
		// TODO Auto-generated method stub
		return null;
	}


    @Override
    public void update(Post p) {

    }

    @Override
    public void run() throws IOException {
        new MenuManager(this).run();
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
    public int compareTo(User o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId);
    }

    public void setRegistired(boolean b) {

    }
}
