package com.thachnguyenit.models;

import java.util.Date;
import java.util.List;

public class NewsModel {

    private String mIcon;

    private String mTitle;

    private Date mCreatedDate;

    private List<String> mTagList;

    private List<UserModel> mUserList;

    public NewsModel(String icon, String title, Date createdDate, List<String> tagList, List<UserModel> userList) {
        this.mIcon = icon;
        this.mTitle = title;
        this.mCreatedDate = createdDate;
        this.mTagList = tagList;
        this.mUserList = userList;
    }

    public String getIcon() {
        return mIcon;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getCreatedDate() {
        return mCreatedDate;
    }

    public List<String> getTagList() {
        return mTagList;
    }

    public List<UserModel> getUserList() {
        return mUserList;
    }
}
