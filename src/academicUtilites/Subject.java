package academicUtilites;

import enums.CourseType;
import enums.Faculty;

import java.util.Vector;

public class Subject {
    private String name;
    private Integer ects;
    private String code;
    private Vector<Object> subjectType;

    public Subject() {
        this.subjectType = new Vector<>();
    }

    public Subject(String name, Integer ects, String code, Vector<Object> subjectType) {
        this.name = name;
        this.ects = ects;
        this.code = code;
        this.subjectType = new Vector<>(subjectType); // Defensive copy
    }

    public Subject(String subjectName) {
        this.name = subjectName;
    }

    // Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Vector<Object> getSubjectType() {
        return new Vector<>(subjectType);
    }

    public void setSubjectType(Vector<Object> subjectType) {
        if (subjectType == null) {
            throw new IllegalArgumentException("SubjectType cannot be null.");
        }
        this.subjectType = new Vector<>(subjectType);
    }

    // Add a new subject type
    public void addSubjectType(Object type) {
        if (type instanceof Faculty || type instanceof CourseType) {
            subjectType.add(type);
        } else {
            throw new IllegalArgumentException("Invalid subject type. Must be Faculty or CourseType.");
        }
    }

    // Remove a subject type
    public void removeSubjectType(Object type) {
        subjectType.remove(type);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", ects=" + ects +
                ", code='" + code + '\'' +
                ", subjectType=" + subjectType +
                '}';
    }

}
