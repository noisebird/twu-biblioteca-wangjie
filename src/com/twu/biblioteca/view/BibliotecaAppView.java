package com.twu.biblioteca.view;

import static com.twu.biblioteca.entity.ConstOfHint.*;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BibliotecaAppView {

    public static void showWelcome() {
        System.out.println(WECLOME_HINT);
    }

    public static void showMainMenu() {
        System.out.println(MAIN_MENU_HINT);
    }

    public static void showChoiceWrong(){
        System.out.println(WRONG_CHOICE_HINT);
    }
    public static void showBorrowBookHint(){
        System.out.println(BORROW_BOOK_HINT);
    }
    public static void showBorrowBokkSuccessHint(){
        System.out.println(BORROW_BOOK_SUCCESS_HINT);
    }
    public static void showBorrowBookFailHint(){
        System.out.println(BORROW_BOOK_FAIL_HINT);
    }


    public static void showReturnBookHint() {
        System.out.println(RETURN_BOOK_HINT);
    }

    public static void showReturnBookFailHint() {
        System.out.println(RETURN_BOOK_FAIL_HINT);
    }

    public static void showReturnBookSuccessHint() {
        System.out.println(RETURN_BOOK_SUCCESS_HINT);
    }
    public static void showReturnMainMenuHint() {
        System.out.println(RETRUN_MAIN_MENU_HINT);
    }

    public static void showSperatorHint(){
        System.out.println(SPERATOR);
    }
    public static void showBookListThead(){
        System.out.println(BOOK_LIST_THEAD);
    }
    public static void showByeHint(){
        System.out.println(BYE_HINT);
    }
}
