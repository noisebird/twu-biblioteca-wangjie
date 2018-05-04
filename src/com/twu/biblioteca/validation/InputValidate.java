package com.twu.biblioteca.validation;

import static com.twu.biblioteca.entity.ConstOfHint.*;

/**
 * Created by wangjie on 2018/5/4.
 */
public class InputValidate {

    public boolean validateMainMenuInput(String input) {
        int value=-1;
        try {
            value=Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return false;
        }
        if(value>Integer.valueOf(ZERO)&&value<Integer.valueOf(FIVE)){
            return true;
        }
        return false;
    }

}
