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
        this.attendanceList = attendanceList;
    }

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
        this.attendanceList = attendanceList;
    }

    public void addAttendance(Date date) {
        if (date != null) {
            this.attendanceList.add(date);
        }
    }

    public void removeAttendance(Date date) {
        this.attendanceList.remove(date);
    }


    @Override
    public String toString() {
        return "GradeBook{" +
                "mark=" + mark +
                ", attendanceList=" + attendanceList +
                '}';
    }
}
