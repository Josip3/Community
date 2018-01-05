package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public ResponseEntity<Music> save(@RequestParam String perfomerName, @RequestParam String trackName, @RequestParam MultipartFile musicFile){
        Music music = new Music();
        music.setPerfomerName(perfomerName);
        music.setTrackName(trackName);
        musicService.save(musicFile,music);
        return new ResponseEntity<>(music,HttpStatus.CREATED);
    }

}
