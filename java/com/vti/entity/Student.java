package com.vti.entity;

public class Student {

    private static int autoId = 0;

    private int id;
    private String name;

    public Student(String name) {
        this.id = ++autoId;
        this.name = name;
    }
    /**
     * @deprecated Use {@link #getIdWithPrefix()} instead.
     */
    @Deprecated
    // Getter mặc định cho id (sẽ bị deprecated sau)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdWithPrefix() {
        return "MSV: " + id;
    }
    /**
     * @deprecated Use {@link #getIdWithPrefix()} instead.
     */
}
