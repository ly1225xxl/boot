package com.zero.boot.po;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

public class Role {
    private String id;

    private String name;

    private String available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }
}