package com.twu.biblioteca.service;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by wangjie on 2018/5/4.
 */
public class MovieStore implements Store<Movie> {
    private List<Movie> list = new ArrayList<Movie>();

    public MovieStore() {
        list.add(new Movie(1001, "The Avengers", "Joss Whedon", "2012", "1", true));
        list.add(new Movie(1002, "Captain America", "Joe Johnston", "2011", "2", true));
        list.add(new Movie(1003, "Iron Man", "Jon Favreau", "2013", "8", true));
        list.add(new Movie(1004, "Wolverine", "Hugh Jackman", "2008-1", "8", false));
    }

    //   获取可借的movie列表
    @Override
    public List<Movie> getAviableList() {
        return list.stream().filter(movie -> movie.getState()).collect(Collectors.toList());
    }

    @Override
    public boolean changeStatus(String input, boolean status) {
        if (isInputValidate(input, status)) {
            list = list.stream().map(movie -> {
                if (String.valueOf(movie.getId()).equals(input)) {
                    movie.setState(!movie.getState());
                }
                return movie;
            }).collect(Collectors.toList());
            return true;
        }
        return false;
    }


    //   验证归还或者要借 的书籍是否存在库中
    @Override
    public boolean isInputValidate(String input, boolean status) {
        return list.stream().anyMatch(movie -> String.valueOf(movie.getId()).equals(input) && movie.getState() == status);

    }
}
