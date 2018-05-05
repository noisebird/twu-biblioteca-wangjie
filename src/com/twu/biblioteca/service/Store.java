package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Movie;

import java.util.List;

/**
 * Created by wangjie on 2018/5/5.
 */
public interface Store<T> {
    List<T> getAviableList();
    boolean changeStatus(String input, boolean status);

    boolean isInputValidate(String input, boolean status);
}
