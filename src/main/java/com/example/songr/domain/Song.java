package com.example.songr.domain;

import com.example.songr.domain.Album;

import javax.persistence.*;

@Entity
//@Table(name = "song")
public class Song {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  long id;
    private String title;
    private String length;
    private String trackNumber;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


    public Song(long id, String title, String length, String trackNumber,Album album) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public long getId() {
        return id;
    }

    public Song() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
