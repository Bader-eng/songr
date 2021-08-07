package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SongControll {
//    @Autowired
//    private  AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping(value ="/songs")
    public String song(Model model){
        List<Song> songs=songRepository.findAll();
        model.addAttribute("songs",new Song());
        model.addAttribute("songs",songs );
        return "SongPage.html";
    }
    @PostMapping("/songs")
    public String add(@ModelAttribute Song song,Model model){

        Song song1=songRepository.save(song);
        List<Song> songs=songRepository.findAll();
        model.addAttribute("songs",songs );
        return "SongPage.html";
    }
}
