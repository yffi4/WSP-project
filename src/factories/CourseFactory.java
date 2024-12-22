package factories;

import academicUtilites.Course;
import academicUtilites.Subject;
import users.Student;

public class CourseFactory {
    public Course getCourse(Student student, int number) {
        return new Course();
    }
    public static Course getCourse(Subject subject, int limit) {
        return new Course(subject.getCode(), subject.getName(), subject.getEcts(), subject.getSubjectType(), limit);
    }
}
