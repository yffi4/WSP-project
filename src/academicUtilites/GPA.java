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
    
    @Override
    public int compareTo(GPA other) {
        return Double.compare(this.numericGrade, other.numericGrade);
    }
    
    @Override
    public String toString() {
        return "GPA{" +
                "numericGrade=" + numericGrade +
                ", letterGrade=" + letterGrade +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GPA)) return false;
        GPA other = (GPA) obj;
        return Double.compare(other.numericGrade, numericGrade) == 0 &&
               letterGrade == other.letterGrade;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        long temp = Double.doubleToLongBits(numericGrade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (letterGrade != null ? letterGrade.hashCode() : 0);
        return result;
    }
}
