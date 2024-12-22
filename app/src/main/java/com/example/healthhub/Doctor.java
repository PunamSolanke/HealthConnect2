package com.example.healthhub;


public class Doctor
{
    private String name;
    private String speciality;
    private String email;

    // Default constructor for Firebase
    public Doctor() { }

    public Doctor(String name, String speciality, String email) {
        this.name = name;
        this.speciality = speciality;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return speciality;
    }

    public String getEmail() {
        return email;
    }
}
