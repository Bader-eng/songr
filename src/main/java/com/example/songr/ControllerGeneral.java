package com.example.songr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller
public class ControllerGeneral {
    @GetMapping(value = "/hello")
    String hollered(){
        System.out.println("bader");
        return "hello";
    }

    @GetMapping(value = "/capitalize/{word}")
   String capitalize(Model model ,@PathVariable("word") String word){
model.addAttribute("word",word);
return "capitalize";
    }

}
