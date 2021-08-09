package com.example.demo.AlbumPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    private MultiValueMap<String, String> createData;

    @GetMapping("/albums")
    public String getAlbum(Model model){
        model.addAttribute("albums", albumRepository.findAll());
        return "albums.html";
    }
    @PostMapping("/addAlbums")
    public RedirectView addAlbum(@RequestBody MultiValueMap <String, String> createData){
        Album album=new Album(createData.get("title").get(0),createData.get("artist").get(0),createData.get("songCount").get(0),createData.get("length").get(0),createData.get("imageUrl").get(0));
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
}
