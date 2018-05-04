package com.twu.biblioteca.entity;

/**
 * Created by wangjie on 2018/5/4.
 */
public class Movie {
    private long id;
    private String name;
    private String year;
    private String director;
    private String rating = "unrated";
    private boolean state;

    public Movie(long id, String name,  String director,String year, String rating, boolean state) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
       return String.format("%-25d%-25s%-25s%-25s%-25s",id,name,year,director,rating);
    }
}
