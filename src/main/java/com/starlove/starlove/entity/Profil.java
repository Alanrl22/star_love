package com.starlove.starlove.entity;

public class Profil {

    private int id;
    private String genre;
    private String eye;
    private String name;
    private String image;

    public Profil(int id, String genre, String name, String eye, String image) {
        this.id = id;
        this.genre = genre;
        this.name = name;
        this.eye = eye;
        this.image = image;

    }

    public Profil() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
