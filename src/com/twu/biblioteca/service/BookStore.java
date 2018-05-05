package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BookStore implements Store<Book> {
    private List<Book> list;
    public BookStore() {
        this.list = new ArrayList<Book>();
        list.add(new Book(1001, "Head First Java", "Sierra", "2007-2", true));
        list.add(new Book(1002, "C++ Primer Plus", "Stephen Prata", "2012-12", true));
        list.add(new Book(1003, "TensorFlow", "xiaohua wang", "2008-1", true));
        list.add(new Book(1004, "Compilers Principles", "Jeffrey D.Ullman", "2007-2", true));
        list.add(new Book(1005, "OpenCV", "ping zhang", "20017-12", false));
    }

    @Override
    public List<Book> getAviableList() {
        return list.stream().filter(book->book.getState()).collect(Collectors.toList());
    }

    @Override
    public boolean changeStatus(String input, boolean status) {
        if(isInputValidate(input,status)){
            list =list.stream().map(book -> {
                if(String.valueOf(book.getId()).equals(input)){
                    book.setState(!book.getState());
                }
                return book;
            }).collect(Collectors.toList());
            return true;
        }
        return false;
    }
    @Override
    public boolean isInputValidate(String input, boolean status){
        return list.stream().anyMatch(book->String.valueOf(book.getId()).equals(input)&&book.getState()==status);

    }

}
