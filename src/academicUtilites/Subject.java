package academicUtilites;

import java.util.Vector;

public class Subject {
    
    private String name;
    private Integer ects;
    private String code;
    private Vector<?> subjectType;
    
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
    
    public Vector<?> getSubjectType() {
        return subjectType;
    }
    
    public void setSubjectType(Vector<?> subjectType) {
        this.subjectType = subjectType;
    }
}
