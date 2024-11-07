package model;

import java.sql.Timestamp;

public class Comment {
    private int id;

    private String text;

    private User user;

    private News news;

    private Timestamp date;

    public Comment() {
    }

    public Comment(int id, String text, User user, News news, Timestamp date) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.news = news;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
