package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangjie on 2018/5/4.
 */
public class UserRepository {
    private List<User> list=new ArrayList<User>();
    private ReadInput readInput;
    private boolean isLogin=false;

    public UserRepository(ReadInput readInput) {
        this.readInput=readInput;
        list.add(new User("111-1111", "123456", "zhagnsan", "728199993@qq.com", "15827080394"));
        list.add(new User("111-1112", "123456", "lisi", "249756106@qq.com", "13277991032"));
        list.add(new User("111-1113", "123456", "root", "5626398173@qq.com", "13018002800"));
    }

    public void login(){

        BibliotecaAppView.showUsernameHint();
        String username=readInput.read();
        BibliotecaAppView.showPasswordHint();
        String password=readInput.read();
        List<User> users=loginValidate(username,password);
        if(users.size()==0){
            login();
            System.out.println();
        }
    }
    public List<User> loginValidate(String username,String password){
        return  list.stream().filter(user->user.getLibraryNo().equals(username)&&user.getPassword().equals(password)).collect(Collectors.toList());
    }
}
