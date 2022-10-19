package com.springessentials.controller;


import com.springessentials.models.Animes;
import com.springessentials.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor //Cria construtores automaticos na hora da ingeção de dependencias
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Animes>> listAnimes(){
      return new ResponseEntity<>( animeService.listAll(),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Animes> findById(@PathVariable long id){
        return new ResponseEntity<>(animeService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Animes> saveAnime(@RequestBody Animes anime){
        return  new ResponseEntity<>(animeService.save(anime),HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Animes> deleteAnime(@PathVariable long id){
        animeService.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Animes> replace(@RequestBody Animes anime){
        animeService.replace(anime);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
