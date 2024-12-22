package users;


import java.awt.print.Paper;



import Database.Database;
import enums.UserType;
import journal.Journal;
import journal.Subscriber;
import papers.ResearchPaper;
import utils.News;
import utils.Post;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;



import journal.Subscriber;
import utils.News;


public abstract class User implements Subscriber,  CanBecomeResearcher, Comparable<User>, Serializable {


    private String name;
    private String lastName;
    private String password;


    private UserType userType;

    private Vector<Post> notifications;


    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Vector<Post> getNotifications() {
        return notifications;
    }

    public void setNotifications(Vector<Post> notifications) {
        this.notifications = notifications;
    }

    public User(String name, String lastName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.notifications = new Vector<>();
    }

    public User() {
    }

    public User(String name, String lastName) {

        this.name = name;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, UserType selectedRole) {
    }


    public UserType getUserType() {
        return userType;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {
        this.password = password;
    }


    

   

    





    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    //                          Operations
    
    /**
    * @generated
    */
    public String login() {
        //TODO
        return "";
    }

    

    public Vector<News> viewNews() {
        News topCitedResearcher = News.autoGenerate();
        Vector<News> news =  Database.DATA.getNews().stream().sorted().collect(Collectors.toCollection(Vector::new));
        news.add(0, topCitedResearcher);
        return news;
    }
    
    
    public void reviewPapers() {
        //TODO
        
    }
    public Vector<ResearchPaper> printPapers(Comparator<ResearchPaper> comparator){
        Vector<ResearchPaper> sortedPapers = Database.DATA.getResearchPapers();
        sortedPapers.sort(comparator);
        return sortedPapers;
    }

    public Vector<Post> readNotifications(){
        Vector<Post> allNotifications = new Vector<>(notifications);
        notifications.clear();
        return allNotifications;
    }

    public void subscribe(Journal journal){
        if (journal != null && !journal.getSubscribers().contains(this)){
            journal.getSubscribers().add(this);
        }
    }
    public void unsubscribe(Journal journal){
        if (journal != null && journal.getSubscribers().contains(this)){
            journal.getSubscribers().remove(this);
        }
    }
    public void addComment(News news, String comment){
        if (news == null) {
            throw new IllegalArgumentException("News cannot be null.");
        }
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("Comment cannot be empty.");
        }


        Post commentPost = new Post(new Date(), comment, this);

        // Добавляем комментарий в список News
        news.getComments().add(commentPost);

        System.out.println("Comment added successfully: " + commentPost);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password) && userType == user.userType && Objects.equals(notifications, user.notifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, password, userType, notifications);
    }

    public void update(Post p){
        notifications.add(p);
    }
    public abstract void run() throws IOException;
    public void save() throws IOException{
        Database.write();
    }

    public void exit(){
        System.out.println("Logged out success");
        Database.DATA.getLogs().add(this + "logged out at " + new Date());
        try {
            save();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
