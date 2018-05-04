package com.twu.biblioteca;

import static com.twu.biblioteca.entity.ConstOfHint.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.ConstOfHint;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private ReadInput readInput;

    @Before
    public void before() {
        System.setOut(new PrintStream(outStream));
        readInput=mock(ReadInput.class);
        bibliotecaApp=new BibliotecaApp(readInput);
    }

    private String systemOut() {
        return outStream.toString();
    }


    @Test
    public void should_show_welcome_and_menu_info() throws Exception {
        bibliotecaApp.enter();
        assertTrue(systemOut().startsWith(WECLOME_HINT+"\n"+MAIN_MENU_HINT));
    }
    @Test
    public void should_input_is_not_correct_return_wrong_choice_info() throws Exception {

        when(readInput.read()).thenReturn("abc").thenReturn(FOURE);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(WRONG_CHOICE_HINT));
    }

}
