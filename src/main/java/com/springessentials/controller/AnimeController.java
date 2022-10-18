package com.springessentials.controller;


import com.springessentials.models.Animes;
import com.springessentials.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor //Cria construtores automaticos na hora da ingeção de dependencias
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    public List<Animes> listAnimes(){
      return animeService.listAll();
    }
}
