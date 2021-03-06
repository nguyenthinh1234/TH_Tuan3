package com.example.myapplication.Bai2;

import java.io.Serializable;

public class Music implements Serializable {
    private int imgSing;
    private String singName;
    private String singerName;

    public Music(int imgSing, String singName, String singerName) {
        this.imgSing = imgSing;
        this.singName = singName;
        this.singerName = singerName;
    }

    public int getImgSing() {
        return imgSing;
    }

    public void setImgSing(int imgSing) {
        this.imgSing = imgSing;
    }

    public String getSingName() {
        return singName;
    }

    public void setSingName(String singName) {
        this.singName = singName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
