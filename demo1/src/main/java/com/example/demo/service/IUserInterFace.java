package com.example.demo.service;

import com.example.demo.bo.UserInfo;

import java.util.List;

public interface IUserInterFace {
    UserInfo getUserByCardno(String cardno);

    UserInfo getUserById(int id);

    int insertUser(String cardno , String psname);

    List<UserInfo> getAllUser();

    int deleteById(int id);

    int updateById(int id , String cardno , String psname);
    int getIntUser();
}
