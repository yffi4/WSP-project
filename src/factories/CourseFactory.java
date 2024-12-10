package factories;

import academicUtilites.Course;
import users.Student;

public class CourseFactory {
    public Course getCourse(Student student, int number) {
        return new Course();
    }
}
