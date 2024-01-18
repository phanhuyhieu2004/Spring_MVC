package com.example.springpicture.model;

import javax.persistence.*;
import java.io.File;
import java.nio.file.Path;
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img="https://timnhadat.s3-ap-southeast-1.amazonaws.com/images/raovat/2022/08/16/133051071448705943-28.jpg";
    private int point;
    private String author;
    private String feedback;

    public Picture() {
    }

    public Picture(int id, String img, int point, String author, String feedback) {
        this.id = id;
        this.img = img;
        this.point = point;
        this.author = author;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}