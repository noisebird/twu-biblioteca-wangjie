package com.twu.biblioteca.entity;

/**
 * Created by wangjie on 2018/5/4.
 */
public class Book {
    private long id;
    private String title;
    private String author;
    private String publishTime;
    //    0代表借出，1代表在库
    private boolean state;

    public Book(long id, String title, String author, String publishTime, boolean state) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishTime = publishTime;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format(ConstOfHint.FORMATE_STRING,id,title,author,publishTime);
    }
}
