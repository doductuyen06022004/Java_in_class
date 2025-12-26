package com.vti.backend;


import com.vti.entity.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaffManagement {
    private List<Staff> staffList = new ArrayList<>();

    // a) Add new staff
    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    // b) Search by full name
    public void searchByName(String name) {
        boolean found = false;
        for (Staff staff : staffList) {
            if (staff.getFullName().equalsIgnoreCase(name)) {
                staff.printInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No staff found with name: " + name);
        }
    }

    // c) Display all staff
    public void displayAllStaff() {
        if (staffList.isEmpty()) {
            System.out.println("Staff list is empty.");
            return;
        }
        for (Staff staff : staffList) {
            staff.printInfo();
            System.out.println("-----------");
        }
    }

    // d) Delete staff by name
    public void deleteByName(String name) {
        Iterator<Staff> iterator = staffList.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            if (staff.getFullName().equalsIgnoreCase(name)) {
                iterator.remove();
                removed = true;
            }
        }

        if (removed) {
            System.out.println("Deleted staff with name: " + name);
        } else {
            System.out.println("No staff found with name: " + name);
        }
    }
}
