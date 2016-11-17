package net.xprogrammer.xwechat.dto;

import java.io.Serializable;

/**
 * @describe: 通用数据
 * @author: Like on 2016/11/4.
 * @Email: 572919350@qq.com
 */

public class UserLoginBean implements Serializable{

	private int code;//返回字节码

    private String msg;
    private String id;
    private String name;
    private String url;
    private int vip;
    private String table;
    private String vipUrl;

    public String getVipUrl() {
        return vipUrl;
    }

    public void setVipUrl(String vipUrl) {
        this.vipUrl = vipUrl;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
