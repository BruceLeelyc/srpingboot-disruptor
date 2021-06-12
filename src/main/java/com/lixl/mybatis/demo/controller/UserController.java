package com.lixl.mybatis.demo.controller;

import com.lixl.mybatis.demo.disruptor.DisruptorDataPublisher;
import com.lixl.mybatis.demo.pojo.SysTable;
import com.lixl.mybatis.demo.pojo.User;
import com.lixl.mybatis.demo.pojo.dto.BeanDataParam;
import com.lixl.mybatis.demo.pojo.dto.UserDto;
import com.lixl.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/9 15:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DisruptorDataPublisher disruptorDataPublisher;

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public Object getUser(@RequestParam("userId")Long userId) {
        User user = userService.findById(userId);
        BeanDataParam data = new BeanDataParam();
        data.setFlag("/user/get");
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        data.setParam(userDto);
        data.setExpire(1000);
        disruptorDataPublisher.publish(data);
        return user;
    }

    @RequestMapping("/findAll")
    public Object findAll() {
        List<SysTable> all = userService.findAll();
        return all;
    }

    @RequestMapping("/findAnnotateById")
    public Object findAnnotateById(@RequestParam("userId")Long userId) {
        User user = userService.findAnnotateById(userId);
        return user;
    }
}
