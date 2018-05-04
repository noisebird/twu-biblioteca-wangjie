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
    @Test
    public void should_view_will_output_the_input_borrow_book_info() throws Exception {
        bibliotecaAppView.showBorrowBookHint();
        assertTrue(systemOut().startsWith(BORROW_BOOK_HINT));
    }
    @Test
    public void should_view_will_output_the_borrow_book_success_info() throws Exception {
        bibliotecaAppView.showBorrowBokkSuccessHint();
        assertTrue(systemOut().startsWith(BORROW_BOOK_SUCCESS_HINT));
    }
    @Test
    public void should_view_will_output_the_borrow_book_fail_info() throws Exception {
        bibliotecaAppView.showBorrowBookFailHint();
        assertTrue(systemOut().startsWith(BORROW_BOOK_FAIL_HINT));
    }

    @Test
    public void should_view_will_output_the_input_return_book_info() throws Exception {
        bibliotecaAppView.showReturnBookHint();
        assertTrue(systemOut().startsWith(RETURN_BOOK_HINT));
    }
    @Test
    public void should_view_will_output_the_return_book_success_info() throws Exception {
        bibliotecaAppView.showReturnBookSuccessHint();
        assertTrue(systemOut().startsWith(RETURN_BOOK_SUCCESS_HINT));
    }
    @Test
    public void should_view_will_output_the_return_book_fail_info() throws Exception {
        bibliotecaAppView.showReturnBookFailHint();
        assertTrue(systemOut().startsWith(RETURN_BOOK_FAIL_HINT));
    }

    @Test
    public void should_view_will_output_the_return_main_menu_info() throws Exception {
        bibliotecaAppView.showReturnMainMenuHint();
        assertTrue(systemOut().startsWith(RETRUN_MAIN_MENU_HINT));
    }


}
