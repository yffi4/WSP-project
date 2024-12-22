package users;

import java.util.Comparator;
import java.util.Vector;

import Database.Database;
import academicUtilites.Course;
import academicUtilites.GPA;
import academicUtilites.GradeReport;
import enums.Faculty;
import enums.MarkType;
import exeptions.InvalidRatingException;
import exeptions.InvalidRegistrationException;
import papers.ResearchProject;
import permissions.CanViewCourse;
import permissions.CanViewTeachers;
import utils.Complaint;

public class Student extends User implements CanViewCourse, CanViewTeachers {
    private String studentId;
    private Faculty faculty;
    private Researcher researcherSupervisor;
    private Vector<Course> courses;
    private GPA gpa;

    public Student() {
        this.studentId = "";
        this.faculty = Faculty.UNKNOWN;
        this.researcherSupervisor = null;
        this.courses = new Vector<>();
        this.gpa = new GPA();
    }

    public Student(String studentId, Faculty faculty, Vector<Course> courses, GPA gpa) {
        this.studentId = studentId;
        this.faculty = faculty;
        this.courses = courses;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Researcher getResearcherSupervisor() {
        return this.researcherSupervisor;
    }

    public void setResearcherSupervisor(Researcher researcherSupervisor) {
        this.researcherSupervisor = researcherSupervisor;
    }

    public Vector<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public GPA getGPA() {
        return this.gpa;
    }

    public void setGPA(GPA gpa) {
        this.gpa = gpa;
    }
 // Registers student to course, for cheking if its not registered or not.
    // If so, it shows exception
  
    public void registerForCourse(Course c) throws InvalidRegistrationException {
        if (c == null) {
            throw new InvalidRegistrationException("Course cannot be null.");
        }
        if (courses.contains(c)) {
            throw new InvalidRegistrationException("Student is already registered for this course: " + c.getName());
        }
        courses.add(c);
        System.out.println("Student registered for course: " + c.getName());
    }


    // returns students cources
    public Vector<Course> viewMyCourses() {
        return this.courses;
    }

    public Vector<GradeReport> viewMarks() {
        Vector<GradeReport> marks = new Vector<>();
        for (Course c : courses) {
            marks.addAll(c.getGradeReportsForStudent(this));
        }
        return marks;
    }

    public Vector<GradeReport> viewTranscript() {
        Vector<GradeReport> transcript = viewMarks();
        transcript.sort(new Comparator<GradeReport>() {

        	public int compare(GradeReport gr1, GradeReport gr2) {
                return gr1.getCourse().getName().compareTo(gr2.getCourse().getName());
            }
        });
        return transcript;
    }

    public void rateTeacher(Teacher t, Integer rating) {
        if (t == null) {
            throw new InvalidRatingException("Teacher cannot be null.");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5.");
        }
        t.getRatings().add(rating.doubleValue());
        System.out.println("Rated teacher " + t.getTeacherId() + " with " + rating + " stars.");
    }


    public void pickResearcherSupervisor(Researcher r) {
        if (r != null) {
            this.researcherSupervisor = r;
            System.out.println("Researcher Supervisor assigned: " + r.getName());
        }
    }

    public ResearchProject getDiplomaProject() {
        for (ResearchProject rp : Database.getInstance().getResearchProjects()) {
            if (rp.getStudent() == this) {
                return rp;
            }
        }
        return null;
    }

    public void startOrganisation(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Organisation name cannot be null or empty.");
        }
        System.out.println("Organisation " + name + " started.");
    }


    public boolean lastYearStudent() {
        return this.gpa.getYear1() == 4;
    }

    public Vector<Teacher> viewTeacher() {
        return Database.getInstance().getTeachers();
    }

    public Vector<Teacher> viewTeacher(Comparator<Teacher> comparator) {
        Vector<Teacher> teachers = viewTeacher();
        teachers.sort(comparator);
        return teachers;
    }
 

    public Vector<Course> viewCourse() {
        return Database.getInstance().getCourses();
    }

    public void markAttendance(Course c, Vector<Student> st, boolean present) {
        if (c == null || st == null || st.isEmpty()) {
            throw new IllegalArgumentException("Invalid course or student list.");
        }
        for (Student student : st) {
            if (student != null) {
                c.markAttendance(student, present);
                System.out.println("Attendance marked for " + student.getStudentId() + ": " + (present ? "Present" : "Absent"));
            }
        }
    }



    public double getRating() {
        double totalRating = 0;
        int count = 0;
        for (Course c : courses) {
            for (Teacher t : c.getTeachers()) {
                for (double rating : t.getRatings()) {
                    totalRating += rating;
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        } else {
            return totalRating / count;
        }
    }


    public void putMarks(Course c, Student s, double mark, MarkType mt) {
        if (c != null && s != null) {
            c.addMark(s, mark, mt);
            System.out.println("Mark added: " + mark + " for " + s.getStudentId() + " in course " + c.getName());
        }
    }
    


	public void sendComplaint(Complaint comp) {
		if (comp != null) {
	        Database.getInstance().getComplaints().add(comp);
	        System.out.println("Complaint sent: " + comp.getDescription());
	    }
	}
	
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Student student = (Student) obj;
	    return studentId.equals(student.studentId);
	}

	public int hashCode() {
	    return studentId.hashCode();
	}

}
