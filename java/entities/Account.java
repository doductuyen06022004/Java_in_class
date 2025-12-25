package entities;

import java.awt.*;
import java.time.LocalDate;

public class Account extends PopupMenu {

    public Group[] groups;
    public int id;
    public String email;

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


    public Account(String label, LocalDate createDate, Department department, String email, String fullName, Group[] groups, int id, Position position, String username) throws HeadlessException {
        super(label);
        this.createDate = createDate;
        this.department = department;
        this.email = email;
        this.fullName = fullName;
        this.groups = groups;
        this.id = id;
        this.position = position;
        this.username = username;
    }

    public String username;
    public String fullName;
    public Department department;
    public Position position;
    public LocalDate createDate;
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


}
