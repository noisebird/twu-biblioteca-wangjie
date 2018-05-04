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
        bookStore=new BookStore(readInput);
        System.setOut(new PrintStream(outStream));
    }

    private String systemOut() {
        return outStream.toString();
    }

    @Test
    public void should_book_store_list_the_books_detail_info() throws Exception {
        List<Book> list=new ArrayList<Book>();
        list.add(new Book(1001,"Head First Java","Sierra","2007-2",true));
        list.add(new Book(1002,"C++ Primer Plus","Stephen Prata","2012-12",true));
        list.add(new Book(1003,"TensorFlow","xiaohua wang","2008-1",true));
        list.add(new Book(1004,"Compilers Principles","Jeffrey D.Ullman","2007-2",true));
        list.add(new Book(1005,"OpenCV","ping zhang","20017-12",false));
        bookStore.showBookList();
        String expectResult=list.stream().filter(item->item.getState()).map(Book::toString).collect(Collectors.joining("\n"));
        assertTrue(systemOut().contains(expectResult));
    }

    @Test
    public void should_book_status_is_0_not_occur_book_list() throws Exception {
        assertTrue(4== bookStore.getAviableBookList().size());
    }

    @Test
    public void should_borrow_book_will_occur_input_hint() throws Exception {

    }
}
