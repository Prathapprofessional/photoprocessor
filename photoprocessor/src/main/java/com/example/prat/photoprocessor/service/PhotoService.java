package com.example.prat.photoprocessor.service;

import com.example.prat.photoprocessor.model.Photo;
import com.example.prat.photoprocessor.repository.PhotosRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhotoService {

    private final PhotosRepository photosRepository;

    public PhotoService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }


    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }

    public Photo get(Integer id)
    {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data ) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        //photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
