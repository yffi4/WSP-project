package factories;

import enums.Faculty;
import enums.ManagerType;
import enums.TeacherType;
import users.Student;
import users.Teacher;
import users.User;

public class UserFactory {

    public User getUser(String firstName, String lastName, String userType) {
        return new User();
    }

    public User getUser(String firstName, String lastName, ManagerType managerType) {
        return new User();
    }

    public User getUser(String firstName, String lastName, String teacherFirstName, String teacherLastName, TeacherType teacherType) {
        return new User();
    }

    public User getUser(String firstName, String lastName, String userType, Faculty faculty) {
        return new User();
    }

    public User getUser(Student student) {
        return new User();
    }

    public User getUser(Teacher teacher) {
        return new User();
    }
}
