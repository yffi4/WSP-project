package academicUtilites;

import users.Student;

import java.util.Date;
import java.util.Vector;
import java.util.stream.Collectors;

public class GradeBook {
    private Mark mark;
    private Vector<Date> attendanceList;


    public GradeBook() {
        this.attendanceList = new Vector<>();
    }

    public GradeBook(Mark mark, Vector<Date> attendanceList) {
        this.mark = mark;
        this.attendanceList = new Vector<>(attendanceList);
    }

    // Getters and setter
    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Vector<Date> getAttendanceList() {
        return new Vector<>(attendanceList);
    }

    public void setAttendanceList(Vector<Date> attendanceList) {
        if (attendanceList == null) {
            throw new IllegalArgumentException("Attendance list cannot be null.");
        }
        this.attendanceList = new Vector<>(attendanceList);
    }

    // Adds an attendance date if it doesnt already exists
    public void addAttendance(Date date) {
        if (date != null && !this.attendanceList.contains(date)) {
            this.attendanceList.add(date);
        }
    }

    // Removes an attendance date
    public void removeAttendance(Date date) {
        this.attendanceList.remove(date);
    }

    // Generates a formatted attendance report
    public String generateAttendanceReport() {
        StringBuilder report = new StringBuilder("Attendance Report:\n");
        for (Date date : attendanceList) {
            report.append("- ").append(date.toString()).append("\n");
        }
        return report.toString();
    }


    public String toString() {
        return "GradeBook{" +
                "mark=" + mark +
                ", attendanceList=" + attendanceList +
                '}';
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GradeBook)) return false;
        GradeBook other = (GradeBook) obj;
        return (mark == null ? other.mark == null : mark.equals(other.mark)) &&
                attendanceList.equals(other.attendanceList);
    }

    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + attendanceList.hashCode();
        return result;
    }

}
