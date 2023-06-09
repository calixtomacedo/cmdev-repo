package br.com.cmdev.swaggeruidemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String get(){
        return "Hello Home get";
    }

    @PostMapping()
    public String post(){
        return "Hello Home post";
    }

    @PutMapping()
    public String put(){
        return "Hello Home put";
    }

    @DeleteMapping()
    public String delete(){
        return "Hello Home delete";
    }

}
