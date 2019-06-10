package com.whhx.service;

import com.whhx.entity.MenuOperation;

import java.util.List;
import java.util.Map;

public interface MenuService {

    List<Map<String, Object>> findMenuList();

    List<MenuOperation> findUserMenu();
}
