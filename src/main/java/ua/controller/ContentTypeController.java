package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.entity.ContentType;
import ua.service.ContentTypeService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/contentType")
public class ContentTypeController {
    
    @Autowired
    ContentTypeService contentTypeService;
    
    @PostMapping("/save")
    private ResponseEntity<ContentType> save(@RequestBody ContentType contentType){
        return new ResponseEntity<ContentType>(contentTypeService.save(contentType), OK);
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<ContentType>> findAll(){
        return new ResponseEntity<>(contentTypeService.findAll(), OK);
    }

    //todo controller and fix save

    
}
