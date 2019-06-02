package com.whhx.service.impl;

import com.whhx.dao.UserDao;
import com.whhx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: wangsaichao
 * @date: 2018/7/19
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
