package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class BibliotecaApp {
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void before() {
        System.setOut(new PrintStream(outStream));
    }

    private String systemOut() {
        return outStream.toString();
    }

    @Test
    public void should_show_welcome_info() throws Exception {

    }

}
