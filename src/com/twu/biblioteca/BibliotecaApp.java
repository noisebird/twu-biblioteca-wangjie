package com.twu.biblioteca;


import com.twu.biblioteca.command.ReadInput;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.MovieStore;
import com.twu.biblioteca.service.UserRepository;
import com.twu.biblioteca.view.BibliotecaAppView;

public class BibliotecaApp {
    private ReadInput readInput;
    protected BibliotecaController bibliotecaController;

    public BibliotecaApp(ReadInput readInput) {
        this.readInput = readInput;
        bibliotecaController=new BibliotecaController(readInput);
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
                bibliotecaController.showBookList();
                return true;
            case TWO:
                bibliotecaController.borrowBook();
                return true;
            case THREE:

                bibliotecaController.returnBook();
                return true;
            case FOUR:
                bibliotecaController.showMovieList();
                return true;
            case FIVE:
                bibliotecaController.borrowMovie();
                return true;
            case SIX:
                bibliotecaController.returnMovie();
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
                    bibliotecaController.login();
                } else {
                    bibliotecaController.showAccountInfo();
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
        return bibliotecaController.getUser();
    }

}
