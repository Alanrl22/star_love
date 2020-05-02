package com.starlove.starlove.entity;

public class Profil {
    private int id;
    private String gender;
    private String eye;
    private String name;
    private int idP;
    private String image;
    private  String hair;
    private String skin;
    private  String nameP;




    public Profil(int id, String gender, String name, String eye, int idP, String image, String hair, String skin, String nameP) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.eye = eye;
        this.idP= idP;
        this.image = image;
        this.hair = hair;
        this.skin = skin;
        this.nameP = nameP;

    }
    public Profil() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
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
    public int getIdP(){
        return idP;
    }
    public void setIdP(int idP){
        this.idP= idP;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public String getSkin() {
        return skin;
    }
    public void setSkin(String skin) {
        this.skin = skin;
    }
    public String getNameP() {
        return nameP;
    }
    public void setNameP(String nameP) {
        this.nameP = nameP;
    }


}