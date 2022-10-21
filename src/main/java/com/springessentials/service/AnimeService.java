package com.springessentials.service;

import com.springessentials.dtos.AnimePostDto;
import com.springessentials.dtos.AnimePutDto;
import com.springessentials.models.Animes;
import com.springessentials.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Animes> listAll() {
        return animeRepository.findAll();
    }

    public Animes findByIdOrThrowBadRequest(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime não encontrado"));
    }

    public Animes save(AnimePostDto animeDto) {
        return animeRepository.save(Animes.builder().name(animeDto.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }

    public void replace(AnimePutDto animePutDto) {
        Animes savedAnime = findByIdOrThrowBadRequest(animePutDto.getId());
        Animes anime = Animes.builder().id(savedAnime.getId()).name(savedAnime.getName()).build();
        animeRepository.save(anime);
    }
}
