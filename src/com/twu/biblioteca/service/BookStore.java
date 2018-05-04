package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BookStore {
    private List<Book> list;
    private ReadInput readInput;

    public BookStore(ReadInput readInput) {
        this.readInput=readInput;
        this.list = new ArrayList<Book>();
        list.add(new Book(1001, "Head First Java", "Sierra", "2007-2", true));
        list.add(new Book(1002, "C++ Primer Plus", "Stephen Prata", "2012-12", true));
        list.add(new Book(1003, "TensorFlow", "xiaohua wang", "2008-1", true));
        list.add(new Book(1004, "Compilers Principles", "Jeffrey D.Ullman", "2007-2", true));
        list.add(new Book(1005, "OpenCV", "ping zhang", "20017-12", false));
    }

    public List<Book> getAviableBookList(){
      return list.stream().filter(book->book.getState()).collect(Collectors.toList());
    }
    public void showBookList() {
        BibliotecaAppView.showSperatorHint();
        BibliotecaAppView.showBookListThead();
        BibliotecaAppView.showSperatorHint();
        list.stream().filter(book->book.getState()).map(Book::toString).forEach(item-> System.out.println(item));
        BibliotecaAppView.showSperatorHint();
        BibliotecaAppView.showReturnMainMenuHint();
        readInput.read();
    }

    public void borrowBook(ReadInput readInput){
        BibliotecaAppView.showBorrowBookHint();

    }
}
