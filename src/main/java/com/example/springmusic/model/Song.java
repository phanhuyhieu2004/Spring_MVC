package com.example.springmusic.model;

import javax.persistence.*;
import java.io.File;
import java.nio.file.Path;
@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSong;
    private String nameSinger;
    private String kindOfMusic;
    private String directorySong;
    public Song(){}
    public Song(String nameSong,String nameSinger, String kindOfMusic, String directorySong){
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.kindOfMusic = kindOfMusic;
        this.directorySong = directorySong;
    }
    public Song(String nameSong,String nameSinger, String kindOfMusic, File directorySong){
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.kindOfMusic = kindOfMusic;
        this.directorySong = String.valueOf(directorySong);
    }
    public Song(int id, String nameSong, String nameSinger, String kindOfMusic, String directorySong){
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.kindOfMusic = kindOfMusic;
        this.directorySong = directorySong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getDirectorySong() {
        return directorySong;
    }

    public void setDirectorySong(String directorySong) {
        this.directorySong = directorySong;
    }
}