package com.vti.entity;

public class Department {
    public String address;

    public Department(int i, String sale) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  int id;
    private  String name;
     public Department(int departmentId, String departmentName, String address) {
        this.id = departmentId;
        this.name = departmentName;
        this.address = address;
    }
    public Department() {
        this.id = 0;
        this.name = null;
    }
    public Department(String nameDepartment) {
        this.id = 0;
        this.name = nameDepartment;
    }
}


