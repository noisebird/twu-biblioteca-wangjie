package com.twu.biblioteca;


import com.twu.biblioteca.command.ReadInput;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.MovieStore;
import com.twu.biblioteca.service.UserRepository;
import com.twu.biblioteca.view.BibliotecaAppView;

public class BibliotecaApp {
    private ReadInput readInput;
    protected BookStore bookStore;
    protected MovieStore movieStore;
    protected UserRepository userRepository;

    public BibliotecaApp(ReadInput readInput) {
        this.readInput = readInput;
        bookStore = new BookStore(readInput);
        movieStore = new MovieStore(readInput);
        userRepository = new UserRepository(readInput);
    }


    public void enter() {
        BibliotecaAppView.showWelcome();
        while (init()) {

        }
    }

    public boolean init() {
        BibliotecaAppView.showMainMenu();
        String choice = readInput.read();
        if (getLoginUser() == null&&!(choice.equals(ZERO)||choice.equals(SEVEN))) {
            BibliotecaAppView.showLoginInFirstHint();
            return true;
        }
        switch (choice) {
            case ZERO:
                while (loginInit()) {
                }
                ;
                return true;
            case ONE:
                bookStore.showBookList();
                return true;
            case TWO:
                bookStore.borrowBook();
                return true;
            case THREE:

                bookStore.returnBook();
                return true;
            case FOUR:
                movieStore.showMovieList();
                return true;
            case FIVE:
                movieStore.borrowMovie();
                return true;
            case SIX:
                movieStore.returnMovie();
                return true;
            case SEVEN:
                BibliotecaAppView.showByeHint();
                return false;
            default:
                BibliotecaAppView.showChoiceWrong();
                return true;
        }
    }

    public boolean loginInit() {
        if (getLoginUser() == null) {
            BibliotecaAppView.showLoginMenu();
        } else {
            BibliotecaAppView.showHasLoginFailHint();
        }
        switch (readInput.read()) {
            case ONE:
                if (getLoginUser() == null) {
                    userRepository.login();
                } else {
                    userRepository.showAccountInfo();
                }
                return true;
            case TWO:
                return false;
            default:
                BibliotecaAppView.showChoiceWrong();
                return true;
        }
    }

    public User getLoginUser(){
        return userRepository.getUser();
    }

}
