package academicUtilites;

import enums.Grades;

public class Mark {
    
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double tableNumeric;
    private String tableAlphabetic;

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getTableNumeric() {
        return tableNumeric;
    }

    public void setTableNumeric(double tableNumeric) {
        this.tableNumeric = tableNumeric;
    }

    public String getTableAlphabetic() {
        return tableAlphabetic;
    }

    public void setTableAlphabetic(String tableAlphabetic) {
        this.tableAlphabetic = tableAlphabetic;
    }

    public double getTotalMark() {
        return firstAttestation + secondAttestation + finalExam;
    }

    public double getGPA() {
        return tableNumeric;
    }

    public Grades getLetterGPA() {
        return Grades.A;
    }

    public gradeTable initGradeTable() {
        return null;
    }
}
