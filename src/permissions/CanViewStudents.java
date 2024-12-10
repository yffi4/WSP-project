package permissions;

import java.util.Vector;

import users.Student;

import java.util.Comparator;

public interface CanViewStudents {
    Vector<Student> viewStudent();
    Vector<Student> viewStudent(Comparator<Student> comparator);
}
