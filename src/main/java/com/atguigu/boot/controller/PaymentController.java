package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Payment;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.dao.PaymentDao;
import com.atguigu.boot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

//    @Autowired
//    PaymentDao paymentDao;
//
//    @GetMapping("/payment")
//    public Payment s(){
//        Payment s = paymentDao.s();
//        return s;
//    }
   // @Autowired
//    UserMapper userMapper;
//
//    @GetMapping("/user")
//    public List<User> users(Model model){
//        List<User> users = userMapper.selectList(null);
//        return users;
//    }

}
