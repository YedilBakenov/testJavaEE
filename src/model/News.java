package model;

import java.sql.Timestamp;

public class News {
    private int id;
    private String title;
    private String content;
    private Timestamp date;

    private User user;

    public News() {
    }

    public News(int id, String title, String content, Timestamp date, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
