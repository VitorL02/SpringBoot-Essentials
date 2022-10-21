package com.springessentials.service;

import com.springessentials.dtos.AnimePutDto;
import com.springessentials.mapper.AnimeMapper;
import com.springessentials.models.Animes;
import com.springessentials.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class AnimeService {

     final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Animes> listAll() {
        return animeRepository.findAll();
    }

    public Animes findByIdOrThrowBadRequest(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime não encontrado"));
    }

    public List<Animes> findByName(String name) {
        return  animeRepository.findByName(name);
    }

    public Animes save(Animes anime) {
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }

    public void replace(AnimePutDto animePutDto) {
        Animes savedAnime = findByIdOrThrowBadRequest(animePutDto.getId());
        Animes anime = AnimeMapper.INSTANCE.toAnime(animePutDto);
        animeRepository.save(anime);
    }
}
