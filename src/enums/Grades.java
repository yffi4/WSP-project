package enums;

public enum Grades {
	
    A("A"), 
    A_MINUS("A-"), 
    B_PLUS("B+"), 
    B("B"), 
    B_MINUS("B-"), 
    C_PLUS("C+"), 
    C("C"), 
    C_MINUS("C-"), 
    D_PLUS("D+"), 
    D("D"), 
    F("F"), 
    P("P");

    private final String grade;

    Grades(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        return grade;
    }
}
