package com.twu.biblioteca;

import static com.twu.biblioteca.entity.ConstOfHint.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void should_input_value_is_1_reBOOK_LIST_THEADturn_the_book_list_info() throws Exception {
        List<Book> list=new ArrayList<Book>();
        list.add(new Book(1001,"Head First Java","Sierra","2007-2",true));
        list.add(new Book(1002,"C++ Primer Plus","Stephen Prata","2012-12",true));
        list.add(new Book(1003,"TensorFlow","xiaohua wang","2008-1",true));
        list.add(new Book(1004,"Compilers Principles","Jeffrey D.Ullman","2007-2",true));
        list.add(new Book(1005,"OpenCV","ping zhang","20017-12",false));
        String expectResult=list.stream().filter(item->item.getState()).map(Book::toString).collect(Collectors.joining("\n"));
        when(readInput.read()).thenReturn(ONE).thenReturn("a").thenReturn(FOURE);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(SPERATOR+"\n"+BOOK_LIST_THEAD+"\n"+SPERATOR+"\n"+expectResult+"\n"+SPERATOR+"\n"+RETRUN_MAIN_MENU_HINT+"\n"+MAIN_MENU_HINT+"\n"+BYE_HINT+"\n"));
    }

    @Test
    public void should_enter_any_char_then_return_the_main_menu() throws Exception {
        when(readInput.read()).thenReturn(ONE).thenReturn("a").thenReturn(FOURE);
        bibliotecaApp.enter();
        assertTrue(systemOut().endsWith(MAIN_MENU_HINT+"\n"+BYE_HINT+"\n"));
    }
}
