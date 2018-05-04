package com.twu.biblioteca.view;

import static com.twu.biblioteca.entity.ConstOfHint.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BibliotecaAppViewTest {

    private ByteArrayOutputStream outStream=new ByteArrayOutputStream();
    private  BibliotecaAppView bibliotecaAppView;
    @Before
    public void before(){
        bibliotecaAppView=new BibliotecaAppView();
        System.setOut(new PrintStream(outStream));
    }
    public String systemOut(){

        return outStream.toString();
    }
    @Test
    public void should_view_will_output_the_welcome_info() throws Exception {
        bibliotecaAppView.showWelcome();
        assertTrue(systemOut().startsWith(WECLOME_HINT));
    }
    @Test
    public void should_view_will_output_the_main_menu_info() throws Exception {
        bibliotecaAppView.showMainMenu();
        assertTrue(systemOut().startsWith(MAIN_MENU_HINT));
    }
    @Test
    public void should_view_will_output_the_choice_wrong_info() throws Exception {
        bibliotecaAppView.showChoiceWrong();
        assertTrue(systemOut().startsWith(WRONG_CHOICE_HINT));
    }

}
