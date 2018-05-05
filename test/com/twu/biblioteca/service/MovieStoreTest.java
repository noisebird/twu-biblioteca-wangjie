package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.command.ReadInput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by wangjie on 2018/5/5.
 */
public class MovieStoreTest {
    private MovieStore movieStore;

    @Before
    public void before() {
        movieStore=new MovieStore();
    }


    @Test
    public void should_movie_status_is_false_not_occur_movie_list() throws Exception {
        assertTrue(3== movieStore.getAviableList().size());
    }

    @Test
    public void should_change_movie_status_to_false_then_movie_list_will_reduce_1() throws Exception {
        movieStore.changeStatus("1001",true);
        assertTrue(2==movieStore.getAviableList().size());
    }
    @Test
    public void should_change_book_status_to_true_then_book_list_will_add_1() throws Exception {
        movieStore.changeStatus("1004",false);
        assertTrue(4==movieStore.getAviableList().size());
    }

    @Test
    public void should_borrorw_book_that_the_book_status_is_false_will_return_false() throws Exception {
        assertFalse(movieStore.isInputValidate("1004",true));
    }
    @Test
    public void should_return_book_that_the_book_status_is_false_will_return_true() throws Exception {
        assertTrue(movieStore.isInputValidate("1004",false));
    }
    @Test
    public void should_borrorw_book_that_the_book_status_is_true_will_return_true() throws Exception {
        assertTrue(movieStore.isInputValidate("1001",true));
    }
    @Test
    public void should_return_book_that_the_book_status_is_true_will_return_true() throws Exception {
        assertFalse(movieStore.isInputValidate("1001",false));
    }

}
