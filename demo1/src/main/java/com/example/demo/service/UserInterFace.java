package com.example.demo.service;

import com.example.demo.bo.UserInfo;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@Service
public class UserInterFace implements IUserInterFace {

    private final Logger log = LoggerFactory.getLogger(UserInterFace.class);

    @Autowired
    UserDao ud;
    @Override
    public UserInfo getUserByCardno(String cardno){
        return ud.getUserByCardno(cardno);
    }

    @Override
    public UserInfo getUserById(int id){
        return ud.getUserById(id);
    }

    @Override
    public int getIntUser() {
        return 7;
    }

    @Override
    public int insertUser(String cardno , String psname){
        log.info("UserInterFace insertUser info log start");
        return ud.insertUser(cardno,psname);
    }

    @Override
    public List<UserInfo> getAllUser(){
        log.info("UserInterFace getAllUser info log start");
        return ud.getAllUser();
    }

    @Override
    public int deleteById(int id){
        log.info("UserInterFace deleteById info log start");
        return ud.deleteById(id);
    }

    @Override
    public int updateById(int id , String cardno , String psname){
        log.info("UserInterFace updateById info log start");
        return ud.updateByid(id,cardno,psname);
    }
}
