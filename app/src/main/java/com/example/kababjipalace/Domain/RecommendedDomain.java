package com.example.kababjipalace.Domain;

import java.io.Serializable;

public class RecommendedDomain implements Serializable {
    private String title;
    private String pic;
    private String desc;
    private Double fee;
    private int star;
    private int time;
    private int calories;
    private  int numInCart;

    public RecommendedDomain(String title, String pic, String desc, Double fee, int star, int time, int calories) {
        this.title = title;
        this.pic = pic;
        this.desc = desc;
        this.fee = fee;
        this.star = star;
        this.time = time;
        this.calories = calories;

    }

    public String getTitle() {
        return title;
    }

    public int getNumInCart() {
        return numInCart;
    }

    public void setNumInCart(int numInCart) {
        this.numInCart = numInCart;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
