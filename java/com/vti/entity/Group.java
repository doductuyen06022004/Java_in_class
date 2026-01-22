package com.vti.entity;

import java.time.LocalDate;

public class Group {

    public int id;
    public String groupName;
    public Account creator;
    public Account[] accounts;
    public LocalDate createDate;

    // a) Constructor không có parameters
    public Group() {
    }

    // b) Constructor có GroupName, Creator, Account[] accounts, CreateDate
    public Group(String groupName, Account creator,
                 Account[] accounts, LocalDate createDate) {

        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    // c) Constructor có GroupName, Creator, String[] usernames, CreateDate
    public Group(String groupName, Account creator,
                 String[] usernames, LocalDate createDate) {

        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;

        // Tạo Account[] từ usernames
        this.accounts = new Account[usernames.length];

        for (int i = 0; i < usernames.length; i++) {
            Account acc = new Account();
            acc.setUsername(usernames[i]);
            this.accounts[i] = acc;
        }
    }

    public Group(int groupID, String groupName) {
    }
}
