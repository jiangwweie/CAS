package com.whhx.service.impl;

import com.whhx.dao.MenuDao;
import com.whhx.entity.MenuOperation;
import com.whhx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: jiangwei
 * @Date: 2019-06-03
 * @Desc:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;


    @Override
    public List<Map<String, Object>> findMenuList() {
        return menuDao.findMenuList();
    }

    @Override
    public List<MenuOperation> findUserMenu() {
        return menuDao.findUserMenu();
    }
}
