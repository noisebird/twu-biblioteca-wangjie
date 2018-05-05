package com.twu.biblioteca.service;
import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.view.BibliotecaAppView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjie on 2018/5/4.
 */
public class UserRepository {
    private List<User> list=new ArrayList<User>();
    private User user;

    public UserRepository() {
        list.add(new User("111-1111", "123456", "zhagnsan", "728199993@qq.com", "15827080394"));
        list.add(new User("111-1112", "123456", "lisi", "249756106@qq.com", "13277991032"));
        list.add(new User("111-1113", "123456", "root", "5626398173@qq.com", "13018002800"));
    }
    public User getUser() {
        return user;
    }

    public User loginValidate(String username,String password){
        user=list.stream().filter(user->user.getLibraryNo().equals(username)&&user.getPassword().equals(password)).count()==0?null:
                list.stream().filter(user->user.getLibraryNo().equals(username)&&user.getPassword().equals(password)).findFirst().get();
        return  user;
    }
}
