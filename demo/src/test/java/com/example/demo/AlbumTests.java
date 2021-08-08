package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlbumTests {
    @Test public void testalbum(){
        Album Happier=new Album("Happier Than Ever","Billie Eilish",8,3000,"https://www.udiscovermusic.com/wp-content/uploads/2021/05/Billie-Eilish-Happier-Than-Ever-Tour.jpg");
        assertEquals("Billie Eilish",Happier.getArtist());

        Happier.setArtist("change");
        assertEquals("change",Happier.getArtist());

    }
}
