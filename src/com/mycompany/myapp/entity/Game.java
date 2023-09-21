/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entity;

/**
 *
 * @author RAZER
 */
public class Game {

    private String name, img,Description;
    private float price;

    public Game() {
    }

    public Game(String name, float price, String img) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public Game(String name, float price,String img, String Description ) {
        this.name = name;
        this.img = img;
        this.Description = Description;
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" + "name=" + name + ", img=" + img + ", price=" + price + '}';
    }

}
