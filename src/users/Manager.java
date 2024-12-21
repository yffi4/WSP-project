package users;

import academicUtilites.Course;
import Database.Database;
import enums.ManagerType;
import utils.FundingRequest;
import utils.Report;
import utils.News;

import javax.xml.crypto.Data;
import java.util.Vector;

public class Manager extends Employee {
    private ManagerType managerType;
    private Vector<FundingRequest> fundingRequests;


    public Manager(String name, String lastName) {
        super(name, lastName);
        this.fundingRequests = new Vector<>();
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public Vector<FundingRequest> getFundingRequests() {
        return fundingRequests;
    }

    public void setFundingRequests(Vector<FundingRequest> fundingRequests) {
        this.fundingRequests = fundingRequests;
    }


    //                          Operations
    
    /**
    * Метод который назначает курсы преподователям
     * можно указать конкретного учителя или конкретный курс
     * или автоматичская логика распределения курсов
    */
    public void assignCoursesToTeachers() {
        Database db = Database.getInstance();

        //проходим по всем курсам и преподавателям и назначаем рандомно

        Vector<Course> allCourses = db.getCourses();
        Vector<Teacher> allTeachers = db.getTeachers();

        if(allCourses.isEmpty() || allTeachers.isEmpty()){
            System.out.println("No teachers oor courses to assign");
        }

        // каждому курсу назначаем первого доступного
        for(Course course : allCourses){
            //у класса Course должен быть метод setTeacher
            //и Teacher может иметь мемтоды для добавления курса в свою коллекцию
            Teacher t = allTeachers.firstElement();
            course.setTeacher(t);

            // Надо логгировать и выводим в консоль
            System.out.println("Assigned teacher: " + t.getName() + "to the course: " + course.getName());
            db.getLogs().add("Manager " + this.getName() + "assigned " + t.getName() + "to course " + course.getName());
        }

    }
    
    /**
    * Метод который назначает студентам регистрацию или подтверждаем.
    */
    public void assignStudentRegistration() {
        Database db = Database.getInstance();
        Vector<Student> allStudents = db.getStudents();

        for(Student s : allStudents){
            s.setRegistired(true);

            db.getLogs().add("Manager " + this.getName()
                    + "assigned registration for student - "+ s.getName());
        }
        System.out.println("All students are registered");
    }
    
    /**
    * Метод который управляет новостями
    */
    public void manageNews() {
        Database db = Database.getInstance();
        //Надо создать новость и добавить в бд
        News newNews = new News();
        newNews.setTitle("Новость от мэнеджера");
        newNews.setContent("Содержимое новости");
        db.getNews().add(newNews);

        db.getLogs().add("manager " + this.getName() + "created news: "+
                newNews.getTitle());
        System.out.println("Создана новость: " + newNews.getTitle());
    }

    /*
    * Метод который возвращает отчет.
    *
    */
    public Report createStatisticalReport() {
        Database db = Database.getInstance();

        int studentCount = db.getStudents().size();
        int courseCount = db.getCourses().size();


        Report report = new Report();
        report.setTitle("Статистический отчет");
        report.setDescription("всего студентов: "+studentCount+" всего курсов: "+courseCount);

        db.getLogs().add("Manager "+this.getName()+" created a statistical report.");
        return report;
    }
    // Метод который возвращает список всех  пользователей
    public Vector<User> viewStudentsAndTeachers() {
        Database db = Database.getInstance();
        Vector<User> result = new Vector<>();

        result.addAll(db.getStudents());
        result.addAll(db.getTeachers());

        db.getLogs().add("manager "+ this.getName()+"viewed students and teachers");
        return result;
    }
    // Метод который одобряет запрос на финансирование
    public boolean approveFunding(FundingRequest fr) {
        Database db = Database.getInstance();

        //Проверка заявки
        if (fr.getAmount()> 0 && fr.getDescription() != null){
            //добряем финансирование
            fr.setApproved(true);
            db.getLogs().add("Manager "+this.getName()+" approved funding request: "+ fr.getDescription());
            return true;
        } else {
            db.getLogs().add("Manager "+this.getName()+" approved funding request: "+ fr.getDescription());
            return false;
        }
    }
}
