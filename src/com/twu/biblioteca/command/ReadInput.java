package com.twu.biblioteca.command;

import com.twu.biblioteca.validation.InputValidate;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.util.Scanner;

/**
 * Created by wangjie on 2018/5/4.
 */
public class ReadInput {
    private Scanner scanner = new Scanner(System.in);
    private InputValidate inputValidate = new InputValidate();
    private BibliotecaAppView bibliotecaAppView = new BibliotecaAppView();

    public String read() {
        String input = scanner.next();
        return input;
    }
}
