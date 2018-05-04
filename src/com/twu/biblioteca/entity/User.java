package com.twu.biblioteca.entity;

/**
 * Created by wangjie on 2018/5/4.
 */
public class User {

    private String libraryNo;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String libraryNo, String password, String name, String email, String phone) {
        this.libraryNo = libraryNo;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getLibraryNo() {
        return libraryNo;
    }

    public void setLibraryNo(String libraryNo) {
        this.libraryNo = libraryNo;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name:"+name+"\n"+"email:"+email+"\n"+"phone:"+phone;
    }
}
