package entities;

import java.time.LocalDate;

public class GroupAccount {
    public  Group group;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Account account;
    public  LocalDate joinDate;

    public GroupAccount(Account account, Group group, LocalDate joinDate) {
        this.account = account;
        this.group = group;
        this.joinDate = joinDate;
    }


}
