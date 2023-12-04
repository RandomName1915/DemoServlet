package com.model.bean;

public class StudentBEAN {
    private String id;
    private String name;
    private int age;
    private String university;

    public StudentBEAN(
        String id,
        String name,
        int age,
        String university
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.university = university;
    }   

    public String getId() {
        return id;
    }

    public String showId() {
        return "#" + id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }    
}
