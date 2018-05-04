package com.twu.biblioteca.view;

import static com.twu.biblioteca.entity.ConstOfHint.*;

/**
 * Created by wangjie on 2018/5/4.
 */
public class BibliotecaAppView {

    public void showWelcome() {
        System.out.println(WECLOME_HINT);
    }

    public void showMainMenu() {
        System.out.println(MAIN_MENU_HINT);
    }

    public void showChoiceWrong(){
        System.out.println(WRONG_CHOICE_HINT);
    }
    public void showBorrowBookHint(){
        System.out.println(BORROW_BOOK_HINT);
    }
    public void showBorrowBokkSuccessHint(){
        System.out.println(BORROW_BOOK_SUCCESS_HINT);
    }
    public void showBorrowBookFailHint(){
        System.out.println(BORROW_BOOK_FAIL_HINT);
    }


    public void showReturnBookHint() {
        System.out.println(RETURN_BOOK_HINT);
    }

    public void showReturnBookFailHint() {
        System.out.println(RETURN_BOOK_FAIL_HINT);
    }

    public void showReturnBookSuccessHint() {
        System.out.println(RETURN_BOOK_SUCCESS_HINT);
    }
    public void showReturnMainMenuHint() {
        System.out.println(RETRUN_MAIN_MENU_HINT);
    }

}
