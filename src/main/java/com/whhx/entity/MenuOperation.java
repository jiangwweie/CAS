package com.whhx.entity;

/**
 * @Author: jiangwei
 * @Date: 2019-06-03
 * @Desc:
 */
public class MenuOperation {
    private int menuId;
    private int operId;

    public MenuOperation() {
    }

    public MenuOperation(int menuId, int operId) {
        this.menuId = menuId;
        this.operId = operId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getOperId() {
        return operId;
    }

    public void setOperId(int operId) {
        this.operId = operId;
    }
}
