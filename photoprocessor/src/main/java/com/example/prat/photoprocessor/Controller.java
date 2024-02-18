package com.example.prat.photoprocessor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private List<Photo> dataBase = List.of(new Photo("1","file1.jpg"));
    @GetMapping("/")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/photo")
    public List<Photo> get()
    {
        return dataBase;
    }
}
