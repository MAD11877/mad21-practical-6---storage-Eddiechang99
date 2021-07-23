package com.example.madpractical;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String description;
    private int id;
    private boolean followed;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public boolean getFollowed() {
        return followed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}
