package com.example.prat.photoprocessor;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {
    private Map<String, Photo> dataBase = new HashMap<>(){{
        put("1", new Photo("1","file1.jpg"));
    }};

    public Collection<Photo> get() {
        return dataBase.values();
    }

    public Photo get(String id)
    {
        return dataBase.get(id);
    }

    public Photo remove(String id) {
        return dataBase.remove(id);
    }

    public Photo save(String fileName, byte[] data ) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        dataBase.put(photo.getId(),photo);
        return photo;
    }
}
