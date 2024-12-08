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

import java.io.*;
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


    /**Deserialize database
     * @return database written on the file
     */
    public static Database read() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Database) ois.readObject();
    }

    //Serialize database
    public static void write() throws IOException{
        FileOutputStream fos = new FileOutputStream("data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(DATA);
        oos.close();
    }
    static {
        if (new File("data").exists()){
            try{
                DATA = read();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else DATA = new Database();

    }
    private Database(){

    }

    @Override
    public String toString() {
        return "Database{Top Secret}";
    }

    public void UpdateTime() {
        //TODO

    }


}
