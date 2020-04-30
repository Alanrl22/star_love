package com.starlove.starlove.entity;

public class Planet {

    private int id;
    private String nameP;


    public Planet() {

    }

    public Planet(int id, String nameP) {

        this.id = id;
        this.nameP = nameP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }
}