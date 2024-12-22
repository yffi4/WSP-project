package academicUtilites;

import enums.Grades;

public class Mark {
    
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double[] tableNumeric = {0, 1, 1.33, 1.67, 2.0, 2.33, 2.67, 3.0, 3.33, 3.67, 4.0};;
    private Grades tableAlphabetic;

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

    public double[] getTableNumeric() {
        return tableNumeric;
    }

    public void setTableNumeric(double tableNumeric) {
        this.tableNumeric = new double[]{tableNumeric};
    }

    public Grades getTableAlphabetic() {
        return tableAlphabetic;
    }

    public void setTableAlphabetic(Grades tableAlphabetic) {
        this.tableAlphabetic = tableAlphabetic;
    }

    public double getTotalMark() {
        return firstAttestation + secondAttestation + finalExam;
    }

    public double getGPA() {

        final int MIN_PASS_MARK = 50;
        final int MAX_MARK = 100;
        final int TABLE_OFFSET = 51;
        final int INTERVAL = 5;

        double total = getTotalMark();


        if (total < MIN_PASS_MARK) {
            return 0.0;
        }


        total = Math.min(MAX_MARK, total);


        int index = ((int) total - TABLE_OFFSET) / INTERVAL + 1;


        return tableNumeric[index];
    }

    public String getLetterGPA() {

        double total = getTotalMark();
        if (total < 50) {
            return Grades.F.getGrade();
        }

        total = Math.min(100, total);
        int index = ((int) total - 51) / 5 + 1;

        switch (index) {
            case 0: return Grades.F.getGrade();
            case 1: return Grades.D.getGrade();
            case 2: return Grades.D_PLUS.getGrade();
            case 3: return Grades.C_MINUS.getGrade();
            case 4: return Grades.C.getGrade();
            case 5: return Grades.C_PLUS.getGrade();
            case 6: return Grades.B_MINUS.getGrade();
            case 7: return Grades.B.getGrade();
            case 8: return Grades.B_PLUS.getGrade();
            case 9: return Grades.A_MINUS.getGrade();
            case 10: return Grades.A.getGrade();
            default: return Grades.F.getGrade();
        }
    }


}
