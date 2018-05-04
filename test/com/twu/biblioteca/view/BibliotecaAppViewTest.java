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
    @Before
    public void before(){
        System.setOut(new PrintStream(outStream));
    }
    public String systemOut(){
        return outStream.toString();
    }
    @Test
    public void should_view_will_output_the_welcome_info() throws Exception {
        BibliotecaAppView bibliotecaAppView=new BibliotecaAppView();
        bibliotecaAppView.showWelcome();
        assertTrue(systemOut().startsWith(WECLOME_HINT));
    }
}
