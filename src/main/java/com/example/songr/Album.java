package com.example.songr;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(value = { "songs" })
@Table(name = "albums")
public class Album {
   @Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private  long id;

    private String title;
    private String artist;
    private int songCount;
    private String length;
    private String imageUrl;

    @OneToMany(mappedBy = "album" )
    private List<Song> song;


    public List<Song> getSong() {
        return song;
    }


    public Album(String title, String artist, int songCount, String length, String imageUrl, long id) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }
    public Album() {
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }


    public String getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
