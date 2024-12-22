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
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class Database implements Serializable {

    /**
     * the instance of Database
     */
    public static Database DATA;

    /**
     * All users with their credentials
     */
    private static final long serialVersionUID = -6326328531711671799L;

    private HashMap<Credentials, User> users = new HashMap<Credentials, User>();

    /**
     * All courses
     */
    private Vector<Course> courses = new Vector<Course>();

    /**
     * All subjects
     */
    private Vector<Subject> subjects = new Vector<Subject>();

    /**
     * All teachers
     */
    private Vector<Teacher> teachers = new Vector<Teacher>();

    /**
     * All researchers
     */
    private Vector<Researcher> researchers = new Vector<Researcher>();

    /**
     * All projects
     */
    private Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();

    /**
     * All papers
     */
    private Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();

    /**
     * All students
     */
    private Vector<Student> students = new Vector<Student>();

    /**
     * news
     */
    private Vector<News> news = new Vector<News>();

    /**
     * logs
     */
    private Vector<String> logs = new Vector<String>();


    /**
     * all dean's offices
     */
    private HashMap<Faculty, DeanOffice> offices = new HashMap<Faculty, DeanOffice>();

    /**
     * rector
     */
    private Dean rector = new Dean();

    /**
     *
     */
    private HashMap<String, HashMap<Language, String>> languageData = new HashMap<String, HashMap<Language, String>>();

    /**
     * journals
     */
    private Vector<Journal> journals = new Vector<Journal>();




    /**
     * periods
     */
    private Period period;

    /**
     *
     */
    private int year;

    /**
     *
     */
    private boolean registrationIsOpen;

    private Researcher topCitedResearcher;

    public Researcher getTopCitedResearcher() {
        return topCitedResearcher;
    }

    public Vector<String> getLogs() {
        return logs;
    }

    public void setLogs(Vector<String> logs) {
        this.logs = logs;
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

    /**Deserialize database
     * @return database written on the file
     */
//    public static Database read() throws IOException, ClassNotFoundException{
//        FileInputStream fis = new FileInputStream("data.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        return (Database) ois.readObject();
//    }
    public static Database read() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("db.ser");
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (Database) oin.readObject();
    }

    //Serialize database
    public static void write() throws IOException{
        FileOutputStream fos = new FileOutputStream("db.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(DATA);
        oos.close();
    }
    static {
        try {
            DATA = read();
        } catch (Exception e) {
            System.err.println("Failed to load database from file: " + e.getMessage());
            e.printStackTrace();
            DATA = new Database(); // Initialize a new instance if reading fails
        }
    }
    private Database(){

    }

    @Override
    public String toString() {
        return "Database{String}";
    }

    public void UpdateTime() {

        Date current = new Date();
        setYear(Year.now().getValue());
        setPeriod((current.getMonth()<5?Period.SPRING:Period.FALL));

    }


}
