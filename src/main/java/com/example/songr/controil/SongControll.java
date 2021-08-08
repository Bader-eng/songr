package com.example.songr.controil;

import com.example.songr.domain.Album;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.domain.Song;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SongControll {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping(value ="/addsong")
    public String song(Model model){
        List<Song> songs=songRepository.findAll();
        model.addAttribute("song",new Song());
        model.addAttribute("songs",songs );
        return "SongPage.html";
    }

    @GetMapping(value ="/album/{id}")
    public String song(@PathVariable Long id , Model model){
        Album album=albumRepository.findById(id).orElseThrow();
//        List<Song> songs=songRepository.findAll();
        model.addAttribute("song",new Song());
        model.addAttribute("songs",album.getSong() );
        model.addAttribute("album",album);
        return "albumsong.html";
    }
    @PostMapping("/album/{id}")
    public String add(@ModelAttribute Song song, Model model,@PathVariable Long id){

        Album album = albumRepository.findById(id).orElseThrow();
        song.setAlbum(album);
        songRepository.save(song);

//        List<Song> songs = songRepository.
        model.addAttribute("song", new Song());
        model.addAttribute("songs",album.getSongs());
        model.addAttribute("album",album);

        //System.out.println("album.getSongs().size() PostMapping   "+album.getSongs().size());
        return "redirect:/album/{id}";
    }
}
