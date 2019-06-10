package com.whhx.dao;

import com.whhx.entity.MenuOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiangwei
 * @Date: 2019-06-03
 * @Desc:
 */
@Repository("menuDao")
public class MenuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过用户名查询用户角色信息
     *
     * @param
     * @return
     */
    public List<Map<String, Object>> findMenuList() {
        try {
            return jdbcTemplate.queryForList("SELECT * FROM sg_menu");
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<MenuOperation> findUserMenu() {
        MenuOperation menu1 = new MenuOperation(1, 1);
        MenuOperation menu2 = new MenuOperation(2, 1);
        MenuOperation menu3 = new MenuOperation(1, 2);
        List list = new ArrayList();
        list.add(menu1);
        list.add(menu2);
        list.add(menu3);
        return list;
    }
}
