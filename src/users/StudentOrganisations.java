package users;

import java.util.Vector;

public class StudentOrganisations {
    private String name;
    private Student head;
    private Vector<Student> members;

    private String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Student getHead() {
        return this.head;
    }

    public void setHead(Student head) {
        this.head = head;
    }

    private Vector<Student> getMembers() {
        return this.members;
    }

    private void setMembers(Vector<Student> members) {
        this.members = members;
    }

    public void addMember(Student s) {
        // TODO
    }

    public void removeMember(Student s) {
        // TODO
    }

    // If 'operation()' was in UML, implement it if needed:
    // public void operation() {
    //     // TODO
    // }
}
