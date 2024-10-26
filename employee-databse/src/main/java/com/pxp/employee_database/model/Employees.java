package com.pxp.employee_database.model;

/**
 * Employee information
 */
public class Employees {
    
    // Private fields for encapsulation
    private int id;
    private String firstName;
    private String lastName;

    // Default constructor
    public Employees() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
