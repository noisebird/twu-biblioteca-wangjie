package com.twu.biblioteca;

import static com.twu.biblioteca.entity.ConstOfHint.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
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
        when(readInput.read()).thenReturn(SEVEN).thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().startsWith(WECLOME_HINT+"\n"+MAIN_MENU_HINT));
    }
    @Test
    public void should_input_is_not_correct_return_wrong_choice_info() throws Exception {

        when(readInput.read()).thenReturn("abc").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(WRONG_CHOICE_HINT));
    }

    @Test
    public void should_input_value_is_1_then_return_the_book_list_info() throws Exception {
        List<Book> list=new ArrayList<Book>();
        list.add(new Book(1001,"Head First Java","Sierra","2007-2",true));
        list.add(new Book(1002,"C++ Primer Plus","Stephen Prata","2012-12",true));
        list.add(new Book(1003,"TensorFlow","xiaohua wang","2008-1",true));
        list.add(new Book(1004,"Compilers Principles","Jeffrey D.Ullman","2007-2",true));
        list.add(new Book(1005,"OpenCV","ping zhang","20017-12",false));
        String expectResult=list.stream().filter(item->item.getState()).map(Book::toString).collect(Collectors.joining("\n"));
        when(readInput.read()).thenReturn(ONE).thenReturn("a").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(SPERATOR+"\n"+BOOK_LIST_HEAD+"\n"+SPERATOR+"\n"+expectResult+"\n"+SPERATOR+"\n"+RETRUN_MAIN_MENU_HINT+"\n"+MAIN_MENU_HINT+"\n"+BYE_HINT+"\n"));
    }

    @Test
    public void should_enter_any_char_then_return_the_main_menu() throws Exception {
        when(readInput.read()).thenReturn(ONE).thenReturn("a").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().endsWith(MAIN_MENU_HINT+"\n"+BYE_HINT+"\n"));
    }
    @Test
    public void should_input_value_equals_2_is_validate() throws Exception {
        when(readInput.read()).thenReturn(TWO).thenReturn("1001").thenReturn(SEVEN);
        bibliotecaApp.enter();
        System.out.println(systemOut());
        assertTrue(systemOut().contains(BORROW_BOOK_HINT));
    }

    @Test
    public void should_input_borrow_id_is_validate_then_return_the_correct_result() throws Exception {
        when(readInput.read()).thenReturn(TWO).thenReturn("1001").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(BORROW_BOOK_SUCCESS_HINT));
    }

    @Test
    public void should_input_borrow_id_is_validate_but_state_is_0_then_return_the_correct_result() throws Exception {
        when(readInput.read()).thenReturn(TWO).thenReturn("1005").thenReturn("1001").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(BORROW_BOOK_FAIL_HINT));
    }
    @Test
    public void should_input_borrow_id_false_at_first_but_correct_at_second() throws Exception {
        when(readInput.read()).thenReturn("2").thenReturn("1005").thenReturn("1001").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(BORROW_BOOK_FAIL_HINT+"\n"+BORROW_BOOK_HINT));
    }
    @Test
    public void should_borrow_book_successfully_then_booklist_will_update() throws Exception {
        when(readInput.read()).thenReturn(TWO).thenReturn("1001").thenReturn(SEVEN);
        bibliotecaApp.enter();
        long count = bibliotecaApp.bookStore.getAviableBookList().stream().filter(book -> book.getState()).count();
        assertTrue(3 == count);
    }

    @Test
    public void should_input_value_equals_3_is_validate() throws Exception {
        when(readInput.read()).thenReturn(THREE).thenReturn("1005").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(RETURN_BOOK_HINT));
    }
    @Test
    public void should_input_return_id_is_validate_then_return_the_correct_result() throws Exception {
        when(readInput.read()).thenReturn(THREE).thenReturn("1005").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(RETURN_BOOK_SUCCESS_HINT));
    }

    @Test
    public void should_input_return_id_false_at_first_but_correct_at_second() throws Exception {
        when(readInput.read()).thenReturn(THREE).thenReturn("1001").thenReturn("1005").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(RETURN_BOOK_FAIL_HINT+"\n"+RETURN_BOOK_HINT));
    }

    @Test
    public void should_input_return_id_is_validate_but_state_is_1_then_return_the_correct_result() throws Exception {
        when(readInput.read()).thenReturn(THREE).thenReturn("1006").thenReturn("1005").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(RETURN_BOOK_FAIL_HINT));
    }

    @Test
    public void should_input_return_book_successfully_then_booklist_will_update() throws Exception {
        when(readInput.read()).thenReturn(THREE).thenReturn("1005").thenReturn(SEVEN);
        bibliotecaApp.enter();
        long count = bibliotecaApp.bookStore.getAviableBookList().stream().filter(book -> book.getState()).count();
        assertTrue(5 == count);
    }
    @Test
    public void should_input_value_equals_4_is_validate() throws Exception {
        when(readInput.read()).thenReturn(SEVEN);
        bibliotecaApp.enter();
        System.out.println(systemOut());
        assertTrue(systemOut().endsWith("Bye!\n\n"));
    }

    @Test
    public void should_input_0_will_ouput_login_menu() throws Exception {
        when(readInput.read()).thenReturn(ZERO).thenReturn(TWO).thenReturn(SEVEN);
        bibliotecaApp.enter();
        System.out.println(systemOut().contains(LOGIN_MENU));
    }
    public void should_login_menu_input_2_will_return_output_login_box(){
        when(readInput.read()).thenReturn(ZERO).thenReturn(TWO).thenReturn(SEVEN);
        bibliotecaApp.enter();
        System.out.println(systemOut().contains(MAIN_MENU_HINT));
    }
    @Test
    public void should_login_menu_input_2_will_return_login_menu() throws Exception {
        when(readInput.read()).thenReturn(ZERO).thenReturn(TWO).thenReturn(SEVEN);
        bibliotecaApp.enter();
        System.out.println(systemOut().contains(MAIN_MENU_HINT));
    }

    @Test
    public void should_input_value_is_4_then_return_the_book_list_info() throws Exception {
        List<Movie> list = new ArrayList<Movie>();
        list.add(new Movie(1001,"The Avengers","Joss Whedon","2012","1",true));
        list.add(new Movie(1002,"Captain America","Joe Johnston","2011","2",true));
        list.add(new Movie(1003,"Iron Man","Jon Favreau","2013","8",true));
        list.add(new Movie(1004,"Wolverine","Hugh Jackman","2008-1","8",false));
        String expectResult=list.stream().filter(item->item.getState()).map(Movie::toString).collect(Collectors.joining("\n"));
        when(readInput.read()).thenReturn(FOUR).thenReturn("a").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().contains(SPERATOR+"\n"+MOVIE_LIST_HEAD+"\n"+SPERATOR+"\n"+expectResult+"\n"+SPERATOR+"\n"+RETRUN_MAIN_MENU_HINT+"\n"+MAIN_MENU_HINT+"\n"+BYE_HINT+"\n"));
    }

    @Test
    public void should_movie_detail_enter_any_char_then_return_the_main_menu() throws Exception {
        when(readInput.read()).thenReturn(FOUR).thenReturn("a").thenReturn(SEVEN);
        bibliotecaApp.enter();
        assertTrue(systemOut().endsWith(MAIN_MENU_HINT+"\n"+BYE_HINT+"\n"));
    }


}
