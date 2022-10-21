package com.springessentials.controller;


import com.springessentials.dtos.AnimePostDto;
import com.springessentials.dtos.AnimePutDto;
import com.springessentials.models.Animes;
import com.springessentials.service.AnimeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("animes")
@Log4j2
public class AnimeController {
     final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }


    @GetMapping
    public ResponseEntity<List<Animes>> listAnimes(){
      return new ResponseEntity<>( animeService.listAll(),HttpStatus.OK);
    }
    @GetMapping(path="/find")
    public ResponseEntity<List<Animes>> listAnimesByName(@RequestParam  String name){
        return new ResponseEntity<>( animeService.findByName(name),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Animes> findById(@PathVariable long id){
        return new ResponseEntity<>(animeService.findByIdOrThrowBadRequest(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Animes> saveAnime(@RequestBody AnimePostDto animeDto){
        var animeModel = new Animes();
        BeanUtils.copyProperties(animeDto,animeModel);
        return  new ResponseEntity<>(animeService.save(animeModel),HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Animes> deleteAnime(@PathVariable long id){
        animeService.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Animes> replace(@RequestBody AnimePutDto animePutDto){
        animeService.replace(animePutDto);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
