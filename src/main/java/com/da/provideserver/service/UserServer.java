package com.da.provideserver.service;

import com.da.provideserver.mapper.UserMapper;
import com.da.provideserver.pojo.User;
import com.da.provideserver.pojo.UserExample;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServer {
    @Resource
    UserMapper mapper;

    public List<User> queryUser(String name, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameLike("%" + name + "%");
        return mapper.selectByExample(example);
    }

    public Integer insertUser(User user) {

        int i = mapper.insertSelective(user);
        System.out.println("==================获取到的插入id为:  " + user.getId());
        return i;
    }

    public Integer insertUser2(String userName, String passWord, String address) {
        User user = new User();
        user.setUserName(userName);
        user.setAddress(address);
        user.setPassWord(passWord);
        return mapper.insertSelective(user);
    }

    public Integer deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
