package Database;

import academicUtilites.Course;
import academicUtilites.Subject;
import enums.Faculty;
import enums.Language;
import enums.Period;
import journal.Journal;
import office.DeanOffice;
import papers.ResearchPaper;
import papers.ResearchProject;
import users.*;
import utils.Credentials;
import utils.News;
import users.Dean;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class Database implements Serializable {

    private static final long serialVersionUID = 1L;
    public static Database DATA;
    private HashMap<Credentials, User> users = new HashMap<>();
    private Vector<Course> courses = new Vector<>();
    private Vector<Subject> subjects = new Vector<>();

    private Vector<Teacher> teachers = new Vector<>();

    private Vector<Researcher> researchers = new Vector<>();
    private Vector<ResearchProject> researchProjects = new Vector<>();
    private Vector<ResearchPaper> researchPapers = new Vector<>();
    private Vector<Student> students = new Vector<>();
    private Vector<News> news = new Vector<>();
    private Vector<String> logs = new Vector<>();
    private HashMap<Faculty, DeanOffice> offices = new HashMap<>();
    private Dean rector = new Dean();
    private HashMap<String, HashMap<Language, String>> languageData = new HashMap<>();
    private Vector<Journal> journals = new Vector<>();
    private Researcher topCitedResearcher;
    private Period period; 
    private int year;
    private boolean registrationIsOpen;
    private Database() {
    }

 
    public static Database read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Database db = (Database) ois.readObject();
        ois.close();
        return db;
    }


    public static void write() throws IOException {
        FileOutputStream fos = new FileOutputStream("data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(DATA);
        oos.close();
    }

    static {
        if (new File("data").exists()) {
            try {
                DATA = read();
            } catch (Exception e) {
                e.printStackTrace();
                DATA = new Database();
            }
        } else {
            DATA = new Database();
        }
    }


    public static Database getInstance() {
        return DATA;
    }

    @Override
    public String toString() {
        return "Database{Top Secret}";
    }


    public void UpdateTime() {
        // TODO: Implement logic to update the time/period/year, etc.
    }

 
    public HashMap<Credentials, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Credentials, User> users) {
        this.users = users;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public Vector<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Vector<Subject> subjects) {
        this.subjects = subjects;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Vector<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Vector<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(Vector<Researcher> researchers) {
        this.researchers = researchers;
    }

    public Vector<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public void setResearchProjects(Vector<ResearchProject> researchProjects) {
        this.researchProjects = researchProjects;
    }

    public Vector<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(Vector<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    public Vector<Student> getStudents() {
        return students;
    }

    public void setStudents(Vector<Student> students) {
        this.students = students;
    }

    public Vector<News> getNews() {
        return news;
    }

    public void setNews(Vector<News> news) {
        this.news = news;
    }

    public Vector<String> getLogs() {
        return logs;
    }

    public void setLogs(Vector<String> logs) {
        this.logs = logs;
    }

    public HashMap<Faculty, DeanOffice> getOffices() {
        return offices;
    }

    public void setOffices(HashMap<Faculty, DeanOffice> offices) {
        this.offices = offices;
    }

    public Dean getRector() {
        return rector;
    }

    public void setRector(Dean rector) {
        this.rector = rector;
    }

    public HashMap<String, HashMap<Language, String>> getLanguageData() {
        return languageData;
    }

    public void setLanguageData(HashMap<String, HashMap<Language, String>> languageData) {
        this.languageData = languageData;
    }

    public Vector<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Vector<Journal> journals) {
        this.journals = journals;
    }

    public Researcher getTopCitedResearcher() {
        return topCitedResearcher;
    }

    public void setTopCitedResearcher(Researcher topCitedResearcher) {
        this.topCitedResearcher = topCitedResearcher;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRegistrationIsOpen() {
        return registrationIsOpen;
    }

    public void setRegistrationIsOpen(boolean registrationIsOpen) {
        this.registrationIsOpen = registrationIsOpen;
    }
}
