package com.twu.biblioteca;

import com.twu.biblioteca.command.ReadInput;

/**
 * Created by wangjie on 2018/5/4.
 */
public class Main {
    public static void main(String[] args) {
        ReadInput readInput =new ReadInput();
        BibliotecaApp bibliotecaApp=new BibliotecaApp(readInput);
        bibliotecaApp.enter();
    }
}
