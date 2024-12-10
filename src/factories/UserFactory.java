package factories;


import enums.Faculty;
import enums.ManagerType;
import enums.TeacherType;
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
}
