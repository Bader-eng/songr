package com.example.songr;

import javax.persistence.*;

@Entity

public class Song {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long id;
    private String Song_title;
    private int song_length;
    private int song_trackNumber;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private  Album album;


    public Song(String songtitle, int length, int trackNumber, Album album) {
        this.Song_title = songtitle;
        this.song_length = length;
        this.song_trackNumber = trackNumber;
        this.album = album;
    }

    public Song() {
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return Song_title;
    }

    public void setTitle(String songtitle) {
        this.Song_title = songtitle;
    }

//    public int getLength() {
//        return length;
//    }
//
//    public void setLength(int length) {
//        this.length = length;
//    }
//
//    public int getTrackNumber() {
//        return trackNumber;
//    }
//
//    public void setTrackNumber(int trackNumber) {
//        this.trackNumber = trackNumber;
//    }
//
//    public Album getAlbum() {
//        return album;
//    }
//
//    public void setAlbum(Album album) {
//        this.album = album;
//    }
}
