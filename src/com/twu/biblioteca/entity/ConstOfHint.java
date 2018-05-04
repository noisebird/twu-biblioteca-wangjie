package com.twu.biblioteca.entity;

import java.time.Year;

/**
 * Created by wangjie on 2018/5/4.
 */
//定义系统中所使用的一些常量
public class ConstOfHint {
    public static final String WECLOME_HINT="====================Welcome To Use Biblioteca System====================";
    public static final String MAIN_MENU_HINT="0.User Account\n1.Book List\n2.Lend Book\n3.Return Book\n4.Movie List\n5.Lend Movie\n6.Return Movie\n7.Exit\nPlease input your choice（0～7)：";
    public static final String WRONG_CHOICE_HINT="Your input is wrong!Please input your choice（0～7）：";
//   借书，还书功能的常量
    public static final String BORROW_BOOK_HINT="Please input the id of the book：";
    public static final String BORROW_BOOK_SUCCESS_HINT="Thank you! Enjoy the book!";
    public static final String BORROW_BOOK_FAIL_HINT="That book is not available.";
    public static final String RETURN_BOOK_HINT="Please input the id of the returning book:";
    public static final String RETURN_BOOK_SUCCESS_HINT="Thank you for returning the book.";
    public static final String RETURN_BOOK_FAIL_HINT="That is not a valid book to return.";

//    borrow movie and return movie 部分的常量
    public static final String BORROW_MOVIE_HINT="Please input the id of the movie：";
    public static final String BORROW_MOVIE_SUCCESS_HINT="Thank you! Enjoy the movie!";
    public static final String BORROW_MOVIE_FAIL_HINT="That movie is not available.";
    public static final String RETURN_MOVIE_HINT="Please input the id of the returning book:";
    public static final String RETURN_MOVIE_SUCCESS_HINT="Thank you for returning the book.";
    public static final String RETURN_MOVIE_FAIL_HINT="That is not a valid book to return.";

    public static final String RETRUN_MAIN_MENU_HINT="Please input any character to return main menu!";
    public static final String BYE_HINT="Bye!";
    public static final String ZERO="0";
    public static final String ONE="1";
    public static final String TWO="2";
    public static final String THREE="3";
    public static final String FOUR="4";
    public static final String FIVE="5";
    public static final String SIX="6";
    public static final String SEVEN="7";

    public static final String FORMATE_STRING="%-32d%-32s%-32s%-32s";

    public static final String SPERATOR="=========================================================================================================";
    public static final String BOOK_LIST_HEAD=String.format("%-32s%-32s%-32s%-32s","Id","Title","Author","PublishDate");

    public static final String MOVIE_LIST_HEAD=String.format("%-25s%-25s%-25s%-25s%-25s","Id","Name", "Year","Director","rating");

    public static final String LOGIN_MENU="1.Login in\n2.Press any key to return main menu\n" +
            "Please input your choice（1～2)";
    public static final String USERNAME_HINT="Please input your username:\n";
    public static final String PASSWORD_HINT="Please input your password:\n";
    public static final String LOGIN_SUCCESS="login successfully";
    public static final String LOGIN_FAIL="Your username or password has an error!Please input your username and password again!";



}
