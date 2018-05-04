package com.twu.biblioteca;


import com.twu.biblioteca.command.ReadInput;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.MovieStore;
import com.twu.biblioteca.validation.InputValidate;
import com.twu.biblioteca.view.BibliotecaAppView;

public class BibliotecaApp {
    private ReadInput readInput;
    protected BookStore bookStore;
    protected MovieStore movieStore;

    public BibliotecaApp(ReadInput readInput) {
        this.readInput = readInput;
        bookStore=new BookStore(readInput);
        movieStore=new MovieStore(readInput);
    }


    public void enter() {
        BibliotecaAppView.showWelcome();
        while (init()) {

        }
    }
    public boolean init() {
        BibliotecaAppView.showMainMenu();
        switch (readInput.read()) {
            case ZERO:
                while(loginInit()){};
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
    public boolean loginInit(){
        BibliotecaAppView.showLoginMenu();
        switch (readInput.read()){
            case ONE:
                return true;
            case TWO:
                return false;
            default:
                BibliotecaAppView.showChoiceWrong();
                return true;
        }
    }

}
