package com.yaohuaxiang.mall.bean;

/**
 * @author yaohuaxiang
 * @create 2020/10/8 - 11:56
 */
public class Manager {
    private Integer mid;
    private String name;
    private String password;

    public Manager(){}

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Manager(Integer mid, String name, String password) {
        this.mid = mid;
        this.name = name;
        this.password = password;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
