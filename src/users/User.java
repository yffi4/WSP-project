package users;

import Database.Database;
import enums.UserType;
import journal.Journal;
import journal.Subscriber;
import utils.News;
import utils.Post;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;



/**
* @generated
*/
public abstract class User implements Subscriber,  CanBecomeResearcher, Comparable<User> {


//    private String email;

    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String lastName;
    
    /**
    * @generated
    */
    private String password;

    private Vector<Post> notifications;

//    public void setEmail(String email) {
//        this.email = email;
//    }


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

//    public String getEmail() {
//        return email;
//    }


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

    

    public Vector<News> ViewNews() {

        return Database.DATA.getNews().stream().sorted().collect(Collectors.toCollection(Vector::new));
    }
    
    /**
    * @generated
    */
    public void reviewPapers() {
        //TODO
        
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
    public int compareTo(User o) {
        return 0;
    }


}
