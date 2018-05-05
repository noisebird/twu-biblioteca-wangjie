package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.MovieStore;
import com.twu.biblioteca.service.UserRepository;
import com.twu.biblioteca.view.BibliotecaAppView;

/**
 * Created by wangjie on 2018/5/5.
 */
public class BibliotecaController {
    protected ReadInput readInput;
    protected UserRepository userRepository;
    public BookStore bookStore;
    public MovieStore movieStore;

    public BibliotecaController(ReadInput readInput) {
        this.readInput=readInput;
        userRepository=new UserRepository();
        bookStore=new BookStore();
        movieStore=new MovieStore();
    }
    public void login(){
        BibliotecaAppView.showUsernameHint();
        String username=readInput.read();
        BibliotecaAppView.showPasswordHint();
        String password=readInput.read();
        User user = userRepository.loginValidate(username, password);
        if(user== null){
            login();
            BibliotecaAppView.showLoginFailHint();
        }else{
            BibliotecaAppView.showLoginSuccessHint();
        }
    }
    public void showAccountInfo(){
        BibliotecaAppView.showSperatorHint();
        System.out.println(getUser().toString());
        BibliotecaAppView.showSperatorHint();
    }
    public void showBookList(){
        BibliotecaAppView.showBookListThead();
        bookStore.getAviableList().stream().map(Book::toString).forEach(item-> System.out.println(item));
        BibliotecaAppView.showReturnMainMenuHint();
        readInput.read();
    }
    public void borrowBook(){
        while(true){
            BibliotecaAppView.showBorrowBookHint();
            if(bookStore.changeStatus(readInput.read(),true)){
                BibliotecaAppView.showBorrowBookSuccessHint();
                break;
            }else{
                BibliotecaAppView.showBorrowBookFailHint();
            }
        }
    }
    public void returnBook() {
        while(true){
            BibliotecaAppView.showReturnMovieHint();
            if(bookStore.changeStatus(readInput.read(),false)){
                BibliotecaAppView.showReturnMovieSuccessHint();
                break;
            }else{
                BibliotecaAppView.showReturnMovieFailHint();
            }
        }
    }
    public void showMovieList() {
        BibliotecaAppView.showMovieListThead();
        movieStore.getAviableList().stream().map(Movie::toString).forEach(item-> System.out.println(item));
        BibliotecaAppView.showReturnMainMenuHint();
        readInput.read();
    }

    public void borrowMovie(){
        while(true){
            BibliotecaAppView.showBorrowBookHint();
            if(movieStore.changeStatus(readInput.read(),true)){
                BibliotecaAppView.showBorrowMoviekSuccessHint();
                break;
            }else{
                BibliotecaAppView.showBorrowMovieFailHint();
            }
        }
    }
    public void returnMovie() {
        while(true){
            BibliotecaAppView.showReturnMovieHint();
            if(movieStore.changeStatus(readInput.read(),false)){
                BibliotecaAppView.showReturnBookSuccessHint();
                break;
            }else{
                BibliotecaAppView.showReturnBookFailHint();
            }
        }
    }
    public User getUser(){
        return userRepository.getUser();
    }
}
