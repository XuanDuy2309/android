package com.example.btth4;

import java.io.Serializable;

public class SV implements Serializable {
    private String title1;
    private String title2;
    private String title3;
    private String img;

    public SV(String title1, String title2, String title3, String img) {
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.img = img;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
