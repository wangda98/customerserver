package com.da.provideserver.controller;

import com.da.provideserver.pojo.User;
import com.da.provideserver.service.UserServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class userController {
@Resource
    UserServer server;

    @RequestMapping("/query")
    public List<User> queryByInfo( String name,  String password) {
        System.out.println("外部调用过来了 传入参数 name:  "+name);
        return server.queryUser(name,password);
    }

    @RequestMapping("/insert")

    public int insertUser(@RequestBody  User user){
        System.out.println("insert外部请求过来了,传入参数:user: "+user);
        return server.insertUser(user);
    }

    @RequestMapping("/insert2")
    public int insertUser2( @RequestParam("userName") String userName,@RequestParam("passWord") String passWord,@RequestParam("address") String address){
        return server.insertUser2(userName,passWord,address);
    }
@RequestMapping("/delete/{id}")
public Integer deleteById(@PathVariable("id") Integer id){
    System.out.println("id:  "+id);
    return server.deleteById(id);
}

}
