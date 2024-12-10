package utils;

import users.User;

import java.io.Serializable;
import java.util.Date;




/**
* @generated
*/
public class Post implements Comparable<Post>, Serializable {
    
    /**
    * @generated
    */
    private Date date;
    
    /**
    * @generated
    */
    private String content;
    
    /**
    * @generated
    */
    private User author;

    public Post(Date date, String content, User author) {
        this.date = date;
        this.content = content;
        this.author = author;
    }
    public Post(String content, User author) {

        this.content = content;
        this.author = author;
    }


    public Post() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public int compareTo(Post o) {
        return 0;
    }
}
