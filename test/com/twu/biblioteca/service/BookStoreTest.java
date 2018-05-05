package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BookStoreTest {
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private BookStore bookStore;

    @Before
    public void before() {
        ReadInput readInput=mock(ReadInput.class);
        bookStore=new BookStore();
        System.setOut(new PrintStream(outStream));
    }

    private String systemOut() {
        return outStream.toString();
    }



    @Test
    public void should_book_status_is_false_not_occur_book_list() throws Exception {
        assertTrue(4== bookStore.getAviableList().size());
    }

    @Test
    public void should_change_book_status_to_false_then_book_list_will_reduce_1() throws Exception {
        bookStore.changeStatus("1001",true);
        assertTrue(3==bookStore.getAviableList().size());
    }
    @Test
    public void should_change_book_status_to_true_then_book_list_will_add_1() throws Exception {
        bookStore.changeStatus("1005",false);
        assertTrue(5==bookStore.getAviableList().size());
    }

    @Test
    public void should_borrorw_book_that_the_book_status_is_false_will_return_false() throws Exception {
        assertFalse(bookStore.isInputValidate("1005",true));
    }
    @Test
    public void should_return_book_that_the_book_status_is_false_will_return_true() throws Exception {
        assertTrue(bookStore.isInputValidate("1005",false));
    }
    @Test
    public void should_borrorw_book_that_the_book_status_is_true_will_return_true() throws Exception {
        assertTrue(bookStore.isInputValidate("1001",true));
    }
    @Test
    public void should_return_book_that_the_book_status_is_true_will_return_true() throws Exception {
        assertFalse(bookStore.isInputValidate("1001",false));
    }
}
