package com.atguigu.service;

import com.atguigu.pojo.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserService implements UserDetailsService {

     static Map<String, LoginUser> map=new HashMap<>();
     static {
            LoginUser user1=new LoginUser();
             user1.setUsername("tom");
             user1.setPassword("$2a$10$K0I4psTorKohZfiTaJNmcegUb2j/6tUc24OEDbJxqUNFMlaxs6iOq");
             user1.setTelephone("110");
             LoginUser user2=new LoginUser();
             user2.setUsername("jack");
             user2.setPassword("123");
             user2.setTelephone("110");
             map.put(user1.getUsername(),user1);
             map.put(user2.getUsername(),user2);
     }

    //权限框架自动调用该方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         //username 登录的用户名字
        System.out.println(username);
        LoginUser loginUser = map.get(username);//从数据库查询用户的信息
         if(loginUser==null){
             System.out.println("请先注册");
             return  null;
         }
       // String password = "{noop}"+loginUser.getPassword();
        String password =loginUser.getPassword();
         //给登录的用户分配权限Authority   (从数据库查询)
        List<GrantedAuthority> lists=new ArrayList<>();
        lists.add(new SimpleGrantedAuthority("add"));
        lists.add(new SimpleGrantedAuthority("delete"));
        lists.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(username,password,lists);
    }
}
