package utils;

import java.sql.Date;

import users.User;

public class Post implements Comparable<Post> {
    private Date date;
    private String content;
    private User author;

    private Date getDate() {
        return this.date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    private String getContent() {
        return this.content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private User getAuthor() {
        return this.author;
    }

    private void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public int compareTo(Post other) {
        // TODO: Implement comparison logic
        // For now, return 0 indicating equality
        return 0;
    }
}
