package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.service.MusicService;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public ResponseEntity<Music> save(@RequestBody Music music){
        return new ResponseEntity<>(musicService.save(music),HttpStatus.CREATED);
    }

    @PostMapping("/save-file/{id}")
    public ResponseEntity<Music> savefile(@PathVariable Integer id,@RequestParam MultipartFile file){
        return new ResponseEntity<>(musicService.save(file, id),HttpStatus.CREATED);
    }

    @GetMapping("/get-music")
    public ResponseEntity<List<Music>> getMusic(){
        return new ResponseEntity<>(musicService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable int id){
        return new ResponseEntity(musicService.delete(id)?HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<Music> findOne(@PathVariable int id){
        return new ResponseEntity<>(musicService.findOne(id),HttpStatus.OK);
    }

}
