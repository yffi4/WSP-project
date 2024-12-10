package academicUtilites;

import enums.LessonType;
import users.Teacher;


public class Lesson {
    
    private LessonType lessonType;
    private Teacher instructor;
    private String name;
    private double someMetric;
    private double someMetric1;


    public Lesson() {
    }


    public Lesson(String name, LessonType lessonType, Teacher instructor, double someMetric, double someMetric1) {
        this.name = name;
        this.lessonType = lessonType;
        this.instructor = instructor;
        this.someMetric = someMetric;
        this.someMetric1 = someMetric1;
    }


    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public Teacher getInstructor() {
        return instructor;
    }


    public void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }

 
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getSomeMetric() {
        return someMetric;
    }

    public void setSomeMetric(double someMetric) {
        this.someMetric = someMetric;
    }

 
    public double getSomeMetric1() {
        return someMetric1;
    }

 
    public void setSomeMetric1(double someMetric1) {
        this.someMetric1 = someMetric1;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", lessonType=" + lessonType +
                ", instructor=" + instructor +
                ", someMetric=" + someMetric +
                ", someMetric1=" + someMetric1 +
                '}';
    }

 
}
