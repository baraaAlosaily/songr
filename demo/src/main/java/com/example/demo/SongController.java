package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
   public String AllofMySongs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return ("mySong.html");
    }
//    @GetMapping("/song/add")
//    public String addSongForm(){
//        return "addsongsToMyAlbum";
//    }

    @GetMapping("albums/{id}")
    public String getSong(@PathVariable ("id") int id,Model m){
        m.addAttribute("album",albumRepository.findById(id).get());
        return ("detailedAlbums.html");
    }
//    @PostMapping("/song")
//    public RedirectView addsong(Album album,String title,String length,String trackNumber){
//        Song songone=new Song(album,title,length,trackNumber);
//        Song song=songRepository.save(songone);
//        return new RedirectView("/song");
//    }
//    @GetMapping("/addSong")
//    public void getSongById(@PathVariable(value = "id") Integer id,Model m){
//        Song song =songRepository.findById(id).get();
//        m.addAttribute("song",song);
//    }
    @PostMapping("/addsong/{id}")
    public RedirectView addsong(@RequestParam String title,String length,String trackNumber,@PathVariable ("id") int id){
        Album album=albumRepository.findById(id).get();
        Song song=new Song(title,length,trackNumber);
        song.setAlbum(album);
        songRepository.save(song);
        return new RedirectView("/albums/{id}");
    }
//    @GetMapping("/addsongs")
//    @ResponseBody
//    public  String addSong(){
//        Album album=albumRepository.findById(1).get();
//        Song song=new Song(album,"test1","test2","test3");
//        songRepository.save(song);
//        return "new2";
//    }

}
