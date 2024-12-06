package academicUtilites

diagram;


/**
* @generated
*/
public class Subject {
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private Integer ects;
    
    /**
    * @generated
    */
    private String code;
    
    /**
    * @generated
    */
    private Vector<Faculty, CourseType> subjectType;
    
    
    
    /**
    * @generated
    */
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private String setName(String name) {
        this.name = name;
    }
    
    /**
    * @generated
    */
    private Integer getEcts() {
        return this.ects;
    }
    
    /**
    * @generated
    */
    private Integer setEcts(Integer ects) {
        this.ects = ects;
    }
    
    /**
    * @generated
    */
    private String getCode() {
        return this.code;
    }
    
    /**
    * @generated
    */
    private String setCode(String code) {
        this.code = code;
    }
    
    /**
    * @generated
    */
    private Vector<Faculty, CourseType> getSubjectType() {
        return this.subjectType;
    }
    
    /**
    * @generated
    */
    private Vector<Faculty, CourseType> setSubjectType(Vector<Faculty, CourseType> subjectType) {
        this.subjectType = subjectType;
    }
    
}
