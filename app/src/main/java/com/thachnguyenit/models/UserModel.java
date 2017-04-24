package com.thachnguyenit.models;

public class UserModel {

    private String mAvatar;

    private String mName;

    public UserModel(String avatar, String name) {
        this.mAvatar = avatar;
        this.mName = name;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public String getName() {
        return mName;
    }
}
