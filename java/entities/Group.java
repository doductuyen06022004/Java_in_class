package entities;

import java.awt.*;
import java.time.LocalDate;

public class Group {
     public Component accounts;
    public Group[] groups = new Group[3];
    public int id;
    public String name;

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Component getAccounts() {
        return accounts;
    }

    public void setAccounts(Component accounts) {
        this.accounts = accounts;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account creator;
    public LocalDate createDate;

    public Group(Component accounts, LocalDate createDate, Account creator, Group[] groups, int id, String name) {
        this.accounts = accounts;
        this.createDate = createDate;
        this.creator = creator;
        this.groups = groups;
        this.id = id;
        this.name = name;
    }


}
