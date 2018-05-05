package com.twu.biblioteca;


import com.twu.biblioteca.command.ReadInput;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.entity.User;
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
                bibliotecaController.showDetailList("book",BOOK_LIST_HEAD,RETRUN_MAIN_MENU_HINT);
                return true;
            case TWO:
                bibliotecaController.borrow("book",BORROW_BOOK_HINT,BORROW_BOOK_SUCCESS_HINT,BORROW_BOOK_FAIL_HINT);
                return true;
            case THREE:

                bibliotecaController.returnGoods("book",RETURN_BOOK_HINT,RETURN_BOOK_SUCCESS_HINT,RETURN_BOOK_FAIL_HINT);
                return true;
            case FOUR:
                bibliotecaController.showDetailList("movie",MOVIE_LIST_HEAD,RETRUN_MAIN_MENU_HINT);
                return true;
            case FIVE:
                bibliotecaController.borrow("movie",BORROW_MOVIE_HINT,BORROW_MOVIE_SUCCESS_HINT,BORROW_MOVIE_FAIL_HINT);
                return true;
            case SIX:
                bibliotecaController.returnGoods("movie",RETURN_MOVIE_HINT,RETURN_MOVIE_SUCCESS_HINT,RETURN_MOVIE_FAIL_HINT);
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
