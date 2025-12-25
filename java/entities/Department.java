package entities;

public class Department {
    public String address;
    public int id;
    public String name;
     public Department(int departmentId, String departmentName, String address) {
        this.id = departmentId;
        this.name = departmentName;
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


