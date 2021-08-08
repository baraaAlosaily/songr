package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class GeneralController<word, attributeName> {
    // inside a controller class, you will add the endpoints (requests mapping)
    // @RequestMapping() general one to using
    // AS we have thymleaf configuration, then the app expects to recieved temple in responds

    //Create an endpoint that coresponds to get requests
    // Add am implementation to the function that will run when receiving a request on that path
    @GetMapping("/hello") //localhost:8080 local host:8080/
    @ResponseBody //include the return vakue as is in the response body
    public  String getHome(){
       return  "hello world";
    }
    @GetMapping("/")
    public String homepage(){
        return "home.html";
    }

    @GetMapping("/capitalize/{hello}")
    public String capitalize(Model model,@PathVariable String hello){
        model.addAttribute("hello", hello.toUpperCase(Locale.ROOT));
//        model.addAttribute("this_is_Kinda_Capitalized","THIS IS KINDA CAPITALIZED");
        return "cap.html";
    }
}
