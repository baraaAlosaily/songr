package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {
    @GetMapping("/album")
    public String getAlbum(Model model){

        Album Happier=new Album("Happier Than Ever","Billie Eilish",8,3000,"https://www.udiscovermusic.com/wp-content/uploads/2021/05/Billie-Eilish-Happier-Than-Ever-Tour.jpg");
        Album For_You=new Album("For You","Selena Gomez",10,3500,"https://live.staticflickr.com/7672/17571046615_2353c130d5_z.jpg");
        Album Jordi=new Album("Jordi","Maroon 5",12,4350,"https://dehayf5mhw1h7.cloudfront.net/wp-content/uploads/sites/1592/2021/06/14082051/shutterstock_1240106593-1000x563.jpg");
        List<Album> albums=new ArrayList<Album>();
        albums.add(Happier);
        albums.add(For_You);
        albums.add(Jordi);
        model.addAttribute("albums",albums);
        return "albums.html";
    }
}
