package factories;


import enums.Faculty;
import enums.ManagerType;
import enums.TeacherType;
import exeptions.InvalidManagerTypeException;
import users.Student;
import users.Teacher;
import users.User;



import enums.UserType;
import users.*;


public class UserFactory {
    public static User getUser(String firstName, String lastName, UserType userType) {
        if (userType.equals(UserType.MANAGER)) {
            return new Manager(firstName, lastName);
        } else if (userType.equals(UserType.ADMIN)) {
            return new Admin(firstName, lastName);
        } else if (userType.equals(UserType.STUDENT)) {
            return new Student(firstName, lastName);
        } else if (userType.equals(UserType.DEAN)) {
            return new Dean(firstName, lastName);
        } else if (userType.equals(UserType.TEACHER)) {
            return new Teacher(firstName, lastName);
        } else if (userType.equals(UserType.RESEARCHER)) {
            return new Researcher(firstName, lastName);
        }


        return null;

    }
    public static User getUser(String firstName, String lastName, UserType userType, Faculty facultyType) {

        if(userType.equals(UserType.MASTER)) {
            return new Master(firstName, lastName, facultyType);
        }

        else if(userType.equals(UserType.PHD)) {
            return new PhDStudent(firstName, lastName, facultyType);
        }

        else if(userType.equals(UserType.RESEARCHER)) {
            return new Researcher(firstName, lastName, facultyType);
        }

        else if(userType.equals(UserType.STUDENT)) {
            return new Student(firstName, lastName, facultyType);
        }
        return null;
    }
    public static User getUser(String firstName, String lastName, Faculty faculty, TeacherType teacherType) {
        return new Teacher(firstName, lastName,faculty, teacherType);
    }
    public static User getUser(String firstName, String lastName, ManagerType managerType) throws InvalidManagerTypeException {
        return new Manager(firstName, lastName, managerType);
    }
    public static User getUser(Teacher teacher){
        return new Researcher(teacher.getName(), teacher.getLastName(), teacher.getFaculty());
    }
    public User getUser(Student student) {
        return new Researcher(student.getName(), student.getLastName(), student.getFaculty());
    }

}
