package com.twu.biblioteca;


import com.twu.biblioteca.command.ReadInput;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import com.twu.biblioteca.validation.InputValidate;
import com.twu.biblioteca.view.BibliotecaAppView;

public class BibliotecaApp {
    private BibliotecaAppView bibliotecaAppView = new BibliotecaAppView();
    private ReadInput readInput;

    public BibliotecaApp(ReadInput readInput) {
        this.readInput = readInput;
    }


    public void enter() {
        bibliotecaAppView.showWelcome();
        while (init()) {

        }
    }
    private boolean init() {
        bibliotecaAppView.showMainMenu();
        switch (readInput.read()) {
            case ONE:
                return true;
            case TWO:
                return true;
            case THREE:
                return true;
            case FOURE:
                return false;
            default:
                bibliotecaAppView.showChoiceWrong();
                return true;
        }
    }
}
