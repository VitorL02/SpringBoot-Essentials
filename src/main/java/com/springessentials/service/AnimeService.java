package com.springessentials.service;

import com.springessentials.models.Animes;
import com.springessentials.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Predicate;

@Service
public class AnimeService {
    private List<Animes> animes = List.of(new Animes(1L, "Baki o Campeão"), new Animes(2L, "One Piece"));

    //    private final AnimeRepository animeRepository;
    public List<Animes> listAll() {
        return animes;
    }

    public Animes findById(long id) {
        return animes.stream().filter(animes -> animes.getId().equals(id)).
                findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime não encontrado"));
    }
}
