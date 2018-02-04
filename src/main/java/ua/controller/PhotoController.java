package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.entity.Photo;
import ua.service.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/find-one/{id}")
    private ResponseEntity<Photo> findOne(@PathVariable int id){
        return new ResponseEntity<>(photoService.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<Photo>> findAll(){
        return new ResponseEntity<>(photoService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/find-by-type/{type}")
    private ResponseEntity<List<Photo>> findPhotoByType(@PathVariable String type){
        return new ResponseEntity<>(photoService.findByPhotoType(type),HttpStatus.OK);
    }

}
