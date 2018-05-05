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
    public void should_book_status_is_0_not_occur_book_list() throws Exception {
        assertTrue(4== bookStore.getAviableList().size());
    }

}
