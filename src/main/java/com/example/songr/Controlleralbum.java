package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlleralbum {

    @Autowired
    private AlbumRepository albumRepository;

//    @GetMapping(value = "/albums")
//    public String albums(Model list){
//
//        Album dragon=new Album("believer","dragon",48,"22 m","https://i.ytimg.com/vi/7wtfhZwyrcc/maxresdefault.jpg",1);
//        Album attackOntitans;
//        attackOntitans = new Album("attackOnTitans","aroen",44,"22 s","https://store-images.s-microsoft.com/image/apps.18464.67116328302209369.766d5242-c87b-4e0a-9cef-7b3e870a4a02.b039bb28-583e-48a6-b410-71c129d21c0b",2);
//        Album gameofthrons=new Album("gameofthrons","gorgearoen",55,"10 s","https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg",3);
//        List<Album> albums=new ArrayList<>();
//        albums.add(dragon);
//        albums.add(attackOntitans);
//        albums.add(gameofthrons);
//        list.addAttribute("albums",albums);
//        return "albums.html";
//    }

    @GetMapping(value = "/addalbums")
    public String addalbumsform(Model model){
        List<Album> albums=albumRepository.findAll();
        model.addAttribute("album",new Album());
        model.addAttribute("albums", albums);
return "albums.html";
    }


   @PostMapping(value="/album")
    public String add1(@ModelAttribute Album album ,Model model){
//        System.out.println(album + "line 404 album");
        Album album1=albumRepository.save(album);
        List<Album> albums=albumRepository.findAll();
//       System.out.println("the greeting is >>> " + album1.getArtist());
       model.addAttribute("albums", albums);
       return "albums.html";
   }


}
