package com.twu.biblioteca.service;

import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangjie on 2018/5/4.
 */
public class MovieStore {
    private ReadInput readInput;
    private List<Movie> list =new ArrayList<Movie>();
//    设置一个status的状态来确定是return moie还是borrow movie
    private boolean status=false;

    public MovieStore(ReadInput readInput) {
        this.readInput=readInput;
        list.add(new Movie(1001,"The Avengers","Joss Whedon","2012","1",true));
        list.add(new Movie(1002,"Captain America","Joe Johnston","2011","2",true));
        list.add(new Movie(1003,"Iron Man","Jon Favreau","2013","8",true));
        list.add(new Movie(1004,"Wolverine","Hugh Jackman","2008-1","8",false));
    }
//   获取可借的movie列表
    public List<Movie> getAviableMovie(){
        return list.stream().filter(movie->movie.getState()).collect(Collectors.toList());
    }
//    显示movie列表
    public void showMovieList() {
        BibliotecaAppView.showSperatorHint();
        BibliotecaAppView.showMovieListThead();
        BibliotecaAppView.showSperatorHint();
        list.stream().filter(movie->movie.getState()).map(Movie::toString).forEach(item-> System.out.println(item));
        BibliotecaAppView.showSperatorHint();
        BibliotecaAppView.showReturnMainMenuHint();
        readInput.read();
    }
//  borrow movie 功能
    public void borrowMovie(){
        status=true;
        while(true){
            BibliotecaAppView.showBorrowBookHint();
            if(changeMovieStatus(readInput.read())){
                BibliotecaAppView.showBorrowMoviekSuccessHint();
                break;
            }else{
                BibliotecaAppView.showBorrowMovieFailHint();
            }
        }
    }
//    借出或者归还movie时，翻转库中的书籍的状态
    private boolean changeMovieStatus(String input){
        if(isInputValidate(input)){
            list =list.stream().map(movie -> {
                if(String.valueOf(movie.getId()).equals(input)){
                    movie.setState(!movie.getState());
                }
                return movie;
            }).collect(Collectors.toList());
            return true;
        }
        return false;
    }
//   验证归还或者要借 的书籍是否存在库中
    private boolean isInputValidate(String input){
        return list.stream().anyMatch(movie->String.valueOf(movie.getId()).equals(input)&&movie.getState()==status);

    }
// return movie
    public void returnMovie() {
        status=false;
        while(true){
            BibliotecaAppView.showReturnMovieHint();
            if(changeMovieStatus(readInput.read())){
                BibliotecaAppView.showReturnBookSuccessHint();
                break;
            }else{
                BibliotecaAppView.showReturnBookFailHint();
            }
        }
    }
}
