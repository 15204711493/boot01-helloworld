package com.atguigu.boot.dao;

import com.atguigu.boot.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaymentDao {

   Payment s();
}
