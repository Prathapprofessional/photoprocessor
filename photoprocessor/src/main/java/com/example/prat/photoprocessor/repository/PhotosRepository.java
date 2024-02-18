package com.example.prat.photoprocessor.repository;

import com.example.prat.photoprocessor.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {
}
