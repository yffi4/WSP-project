package Database;

import java.io.Serializable;

public class Database implements Serializable {

    /**
     * @generated
     */
    private Database DATA;

    /**
     * @generated
     */
    private HashMap<Credentials, User> users;

    /**
     * @generated
     */
    private Vector<Course>2 courses;

    /**
     * @generated
     */
    private Vector<Subject> subjects;

    /**
     * @generated
     */
    private Vector<Teacher>2 teachers;

    /**
     * @generated
     */
    private Vector<Researcher>2 researchers;

    /**
     * @generated
     */
    private Vector<ResearchProject>2 researchProjects;

    /**
     * @generated
     */
    private Vector<ResearchPaper> researchPapers;

    /**
     * @generated
     */
    private Vector<Student>3 students;

    /**
     * @generated
     */
    private Vector<News>2 news;

    /**
     * @generated
     */
    private Vector<String>2 logs;

    /**
     * @generated
     */
    private HashMap<Faculty, DeansOffice> offices;

    /**
     * @generated
     */
    private Dean rector;

    /**
     * @generated
     */
    private HashMap<String, HashMap<Language, String>> languageData;

    /**
     * @generated
     */
    private Vector<Journals> journals;

    /**
     * @generated
     */
    private Researcher2 topCitedResearcher;

    /**
     * @generated
     */
    private Period period;

    /**
     * @generated
     */
    private Integer year;

    /**
     * @generated
     */
    private Boolean registrationIsOpen;



    /**
     * @generated
     */
    public Database(Singleton) getDATA() {
        return this.DATA;
    }

    /**
     * @generated
     */
    public Database(Singleton) setDATA(Database(Singleton) DATA) {
        this.DATA = DATA;
    }

    /**
     * @generated
     */
    private HashMap<Credentials, User> getUsers() {
        return this.users;
    }

    /**
     * @generated
     */
    private HashMap<Credentials, User> setUsers(HashMap<Credentials, User> users) {
        this.users = users;
    }

    /**
     * @generated
     */
    private Vector<Course>2 getCourses() {
        return this.courses;
    }

    /**
     * @generated
     */
    private Vector<Course>2 setCourses(Vector<Course>2 courses) {
        this.courses = courses;
    }

    /**
     * @generated
     */
    private Vector<Subject> getSubjects() {
        return this.subjects;
    }

    /**
     * @generated
     */
    private Vector<Subject> setSubjects(Vector<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * @generated
     */
    private Vector<Teacher>2 getTeachers() {
        return this.teachers;
    }

    /**
     * @generated
     */
    private Vector<Teacher>2 setTeachers(Vector<Teacher>2 teachers) {
        this.teachers = teachers;
    }

    /**
     * @generated
     */
    private Vector<Researcher>2 getResearchers() {
        return this.researchers;
    }

    /**
     * @generated
     */
    private Vector<Researcher>2 setResearchers(Vector<Researcher>2 researchers) {
        this.researchers = researchers;
    }

    /**
     * @generated
     */
    private Vector<ResearchProject>2 getResearchProjects() {
        return this.researchProjects;
    }

    /**
     * @generated
     */
    private Vector<ResearchProject>2 setResearchProjects(Vector<ResearchProject>2 researchProjects) {
        this.researchProjects = researchProjects;
    }

    /**
     * @generated
     */
    private Vector<ResearchPaper> getResearchPapers() {
        return this.researchPapers;
    }

    /**
     * @generated
     */
    private Vector<ResearchPaper> setResearchPapers(Vector<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    /**
     * @generated
     */
    private Vector<Student>3 getStudents() {
        return this.students;
    }

    /**
     * @generated
     */
    private Vector<Student>3 setStudents(Vector<Student>3 students) {
        this.students = students;
    }

    /**
     * @generated
     */
    private Vector<News>2 getNews() {
        return this.news;
    }

    /**
     * @generated
     */
    private Vector<News>2 setNews(Vector<News>2 news) {
        this.news = news;
    }

    /**
     * @generated
     */
    private Vector<String>2 getLogs() {
        return this.logs;
    }

    /**
     * @generated
     */
    private Vector<String>2 setLogs(Vector<String>2 logs) {
        this.logs = logs;
    }

    /**
     * @generated
     */
    private HashMap<Faculty, DeansOffice> getOffices() {
        return this.offices;
    }

    /**
     * @generated
     */
    private HashMap<Faculty, DeansOffice> setOffices(HashMap<Faculty, DeansOffice> offices) {
        this.offices = offices;
    }

    /**
     * @generated
     */
    private Dean getRector() {
        return this.rector;
    }

    /**
     * @generated
     */
    private Dean setRector(Dean rector) {
        this.rector = rector;
    }

    /**
     * @generated
     */
    private HashMap<String, HashMap<Language, String>> getLanguageData() {
        return this.languageData;
    }

    /**
     * @generated
     */
    private HashMap<String, HashMap<Language, String>> setLanguageData(HashMap<String, HashMap<Language, String>> languageData) {
        this.languageData = languageData;
    }

    /**
     * @generated
     */
    private Vector<Journals> getJournals() {
        return this.journals;
    }

    /**
     * @generated
     */
    private Vector<Journals> setJournals(Vector<Journals> journals) {
        this.journals = journals;
    }

    /**
     * @generated
     */
    private Researcher2 getTopCitedResearcher() {
        return this.topCitedResearcher;
    }

    /**
     * @generated
     */
    private Researcher2 setTopCitedResearcher(Researcher2 topCitedResearcher) {
        this.topCitedResearcher = topCitedResearcher;
    }

    /**
     * @generated
     */
    private Period getPeriod() {
        return this.period;
    }

    /**
     * @generated
     */
    private Period setPeriod(Period period) {
        this.period = period;
    }

    /**
     * @generated
     */
    private Integer getYear() {
        return this.year;
    }

    /**
     * @generated
     */
    private Integer setYear(Integer year) {
        this.year = year;
    }

    /**
     * @generated
     */
    private Boolean getRegistrationIsOpen() {
        return this.registrationIsOpen;
    }

    /**
     * @generated
     */
    private Boolean setRegistrationIsOpen(Boolean registrationIsOpen) {
        this.registrationIsOpen = registrationIsOpen;
    }


    //                          Operations

    /**
     * @generated
     */
    public Database(Singleton) read() {
        //TODO
        return null;
    }

    /**
     * @generated
     */
    public void write() {
        //TODO
        return null;
    }

    /**
     * @generated
     */
    public void UpdateTime() {
        //TODO
        return null;
    }


}
