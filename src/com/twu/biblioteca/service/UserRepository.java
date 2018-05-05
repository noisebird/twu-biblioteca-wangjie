package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.command.ReadInput;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.view.BibliotecaAppView;
import org.mockito.internal.matchers.Null;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangjie on 2018/5/4.
 */
public class UserRepository {
    private List<User> list=new ArrayList<User>();
    private ReadInput readInput;
    private User user;

    public UserRepository(ReadInput readInput) {
        this.readInput=readInput;
        list.add(new User("111-1111", "123456", "zhagnsan", "728199993@qq.com", "15827080394"));
        list.add(new User("111-1112", "123456", "lisi", "249756106@qq.com", "13277991032"));
        list.add(new User("111-1113", "123456", "root", "5626398173@qq.com", "13018002800"));
    }

    public User getUser() {
        return user;
    }

    public void login(){
        BibliotecaAppView.showUsernameHint();
        String username=readInput.read();
        BibliotecaAppView.showPasswordHint();
        String password=readInput.read();
        user=loginValidate(username,password);
        if(user== null){
            login();
            BibliotecaAppView.showLoginFailHint();
        }else{
            BibliotecaAppView.showLoginSuccessHint();
        }

    }
    public void showAccountInfo(){
        BibliotecaAppView.showSperatorHint();
        System.out.println(user.toString());
        BibliotecaAppView.showSperatorHint();
    }

    public User loginValidate(String username,String password){
        return  list.stream().filter(user->user.getLibraryNo().equals(username)&&user.getPassword().equals(password)).count()==0?null:
                list.stream().filter(user->user.getLibraryNo().equals(username)&&user.getPassword().equals(password)).findFirst().get();
    }
}
