package com.example.prat.photoprocessor;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class Controller {
     private Map<String, Photo> dataBase = new HashMap<>(){{
         put("1", new Photo("1","file1.jpg"));
     }};

    @GetMapping("/")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/photo")
    public Collection<Photo> get()
    {
        return dataBase.values();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id)
    {
        Photo photo = dataBase.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id)
    {
        Photo photo = dataBase.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }

    @PostMapping("/photo")
    public Photo create(@RequestBody @Valid Photo photo)
    {
        photo.setId(UUID.randomUUID().toString());
       dataBase.put(photo.getId(), photo);
       return photo;
    }

}
