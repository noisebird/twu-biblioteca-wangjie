package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.MovieStore;
import com.twu.biblioteca.service.Store;
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
        this.readInput = readInput;
        userRepository = new UserRepository();
        bookStore = new BookStore();
        movieStore = new MovieStore();
    }

    public void login() {
        BibliotecaAppView.showUsernameHint();
        String username = readInput.read();
        BibliotecaAppView.showPasswordHint();
        String password = readInput.read();
        User user = userRepository.loginValidate(username, password);
        if (user == null) {
            login();
            BibliotecaAppView.showLoginFailHint();
        } else {
            BibliotecaAppView.showLoginSuccessHint();
        }
    }

    public void showAccountInfo() {
        BibliotecaAppView.showSperatorHint();
        System.out.println(getUser().toString());
        BibliotecaAppView.showSperatorHint();
    }

    public void showDetailList(String category, String tHeadHint, String returnMainMenuHint) {
        System.out.println(tHeadHint);
        if (category.equals("movie")) {
            movieStore.getAviableList().stream().map(Movie::toString).forEach(item -> System.out.println(item));
        } else {
            bookStore.getAviableList().stream().map(Book::toString).forEach(item -> System.out.println(item));

        }
        System.out.println(returnMainMenuHint);
        readInput.read();

    }

    public void borrow(String category, String borrowHint, String borrowSuccessHint, String borrowFailHint) {
        while (true) {
            System.out.println(borrowHint);
            Store store = category.equals("movie") ? movieStore : bookStore;
            if (store.changeStatus(readInput.read(), true)) {
                System.out.println(borrowSuccessHint);
                break;
            } else {
                System.out.println(borrowFailHint);
            }
        }
    }

    public void returnGoods(String category, String returnHint, String returnSuccessHint, String returnFailHint) {
        while (true) {
            System.out.println(returnHint);
            Store store = category.equals("movie") ? movieStore : bookStore;
            if (store.changeStatus(readInput.read(), false)) {
                System.out.println(returnSuccessHint);
                break;
            } else {
                System.out.println(returnFailHint);
            }
        }
    }

    public User getUser() {
        return userRepository.getUser();
    }
}
