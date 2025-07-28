package com.example.ResponseEntDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FamilyGuyCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String profession;
    private String slangUsed;
    private String favoriteThing;

    public FamilyGuyCharacter() {}

    public FamilyGuyCharacter(int id, String name, int age, String profession, String slangUsed, String favoriteThing) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.slangUsed = slangUsed;
        this.favoriteThing = favoriteThing;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public String getSlangUsed() { return slangUsed; }
    public void setSlangUsed(String slangUsed) { this.slangUsed = slangUsed; }

    public String getFavoriteThing() { return favoriteThing; }
    public void setFavoriteThing(String favoriteThing) { this.favoriteThing = favoriteThing; }
}


