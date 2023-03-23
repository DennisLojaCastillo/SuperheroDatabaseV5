package com.example.superherodatabasev5.model;

public class Superhero {
    private int superheroID;
    private String heroName;
    private String realName;
    private int creationYear;

    public Superhero (int superheroID, String heroName, String realName, int creationYear) {
        this.superheroID = superheroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public int getSuperheroID() {
        return superheroID;
    }


    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
}
