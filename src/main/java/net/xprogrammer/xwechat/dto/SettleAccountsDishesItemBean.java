package net.xprogrammer.xwechat.dto;

import java.io.Serializable;

/**
 * @describe: 结账界面单品清单
 * @author: Like on 2016/11/13.
 * @Email: 572919350@qq.com
 */

public class SettleAccountsDishesItemBean implements Serializable {

    private String id;

    private String name;

    private int number;

    private int price;

    private PriceTypeBean priceTypeBean;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PriceTypeBean getPriceTypeBean() {
        return priceTypeBean;
    }

    public void setPriceTypeBean(PriceTypeBean priceTypeBean) {
        this.priceTypeBean = priceTypeBean;
    }
}
