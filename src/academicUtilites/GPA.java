package academicUtilites;

import enums.Grades;

public class GPA implements Comparable<GPA> {

    private double numericGrade;
    private Grades letterGrade;

    public GPA() {
    }

    public GPA(double numericGrade, Grades letterGrade) {
        this.numericGrade = numericGrade;
        this.letterGrade = letterGrade;
    }

    // getter and setter
    public double getNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(double numericGrade) {
        this.numericGrade = numericGrade;
    }

    public Grades getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(Grades letterGrade) {
        this.letterGrade = letterGrade;
    }





    public int compareTo(GPA other) {
        return Double.compare(this.numericGrade, other.numericGrade);
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GPA)) return false;
        GPA other = (GPA) obj;
        return Double.compare(other.numericGrade, numericGrade) == 0 &&
                letterGrade == other.letterGrade;
    }


    public String toString() {
        return "GPA{" +
                "numericGrade=" + numericGrade +
                ", letterGrade=" + letterGrade +
                '}';
    }
}
