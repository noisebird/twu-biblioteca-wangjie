package com.twu.biblioteca;


import com.twu.biblioteca.command.ReadInput;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.validation.InputValidate;
import com.twu.biblioteca.view.BibliotecaAppView;

public class BibliotecaApp {
    private ReadInput readInput;

    public BibliotecaApp(ReadInput readInput) {
        this.readInput = readInput;
    }


    public void enter() {
        BibliotecaAppView.showWelcome();
        while (init()) {

        }
    }
    private boolean init() {
        BibliotecaAppView.showMainMenu();
        switch (readInput.read()) {
            case ONE:
                BookStore bookStore=new BookStore(readInput);
                bookStore.showBookList();
                return true;
            case TWO:
                return true;
            case THREE:
                return true;
            case FOURE:
                BibliotecaAppView.showByeHint();
                return false;
            default:
                BibliotecaAppView.showChoiceWrong();
                return true;
        }
    }
}
