package entities;

public class Department {
    public String address;

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

    public int id;
    public String name;
     public Department(int departmentId, String departmentName, String address) {
        this.id = departmentId;
        this.name = departmentName;
        this.address = address;
    }


}


