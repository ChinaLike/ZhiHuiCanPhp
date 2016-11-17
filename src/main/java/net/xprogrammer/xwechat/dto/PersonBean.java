package net.xprogrammer.xwechat.dto;

import java.io.Serializable;

/**
 * @describe: 人物设定
 * @author: Like on 2016/11/8.
 * @Email: 572919350@qq.com
 */

public class PersonBean implements Serializable{

    private int number;

    private String tableName;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
