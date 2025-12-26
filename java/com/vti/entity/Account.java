package com.vti.entity;

import java.awt.*;
import java.time.LocalDate;

public class Account extends PopupMenu {

    private  Group[] groups;
    private  int id;
    private  String email;
    private  String username;
    private  String fullName;
    private  Department department;
    private  Position position;
    private  LocalDate createDate;
    private int balance;
    public Account(LocalDate createDate, Department department, String email, String fullName, Group[] groups, int id, Position position, String username) throws HeadlessException {
        this.createDate = createDate;
        this.department = department;
        this.email = email;
        this.fullName = fullName;
        this.groups = groups;
        this.id = id;
        this.position = position;
        this.username = username;
    }
    public Account() {}
    public Account(int id, String email, String username,
                   String firstName, String lastName) {

        this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
    }
    public Account(int id, String email, String username,
                   String firstName, String lastName,
                   Position position) {

        this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    public Account(int id, String email, String username,
                   String firstName, String lastName,
                   Position position, LocalDate createDate) {

        this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = createDate;
    }

    public Account(String a1, String nguyenVanA, int i) {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int credit(int amount) {
        int balance = amount;
        return balance;
    }

    // Trừ tiền
    public int debit(int amount) {

        if (amount <= balance) {
            balance -= amount;
        }
        return balance;
    }

    // Chuyển tiền
    public int transferTo(Account account, int amount) {
        if (amount <= balance) {
            this.balance -= amount;
            account.balance += amount;
        }
        return balance;
    }

}
