package com.vti.entity;

public class VietnamesePhone extends Phone {

    @Override
    public void insertContact(String name, String phone) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact already exists!");
                return;
            }
        }
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    @Override
    public void removeContact(String name) {
        boolean removed = contacts.removeIf(
                contact -> contact.getName().equalsIgnoreCase(name)
        );

        if (removed) {
            System.out.println("Contact removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setPhone(newPhone);
                System.out.println("Contact updated.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    @Override
    public void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone: " + contact.getPhone());
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
