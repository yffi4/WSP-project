package permissions;

import java.util.Vector;

import users.Teacher;

import java.util.Comparator;

public interface CanViewTeachers {
    Vector<Teacher> viewTeacher();
    Vector<Teacher> viewTeacher(Comparator<Teacher> comparator);
}
