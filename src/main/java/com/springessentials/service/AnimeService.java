package com.springessentials.service;

import com.springessentials.models.Animes;
import com.springessentials.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService  {

//    private final AnimeRepository animeRepository;
    public List<Animes> listAll(){
        return List.of(new Animes(1L,"Baki o Campeão"),new Animes(2L,"One Piece"));
    }

}
