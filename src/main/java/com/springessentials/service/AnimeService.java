package com.springessentials.service;

import com.springessentials.models.Animes;
import com.springessentials.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

@Service
public class AnimeService {
    private static List<Animes> animes ;
    static {
        animes = new ArrayList<>(List.of(new Animes(1L, "Baki o Campeão"), new Animes(2L, "One Piece")));
    }
    //    private final AnimeRepository animeRepository;
    public List<Animes> listAll() {
        return animes;
    }

    public Animes findById(long id) {
        return animes.stream().filter(animes -> animes.getId().equals(id)).
                findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime não encontrado"));
    }

    public Animes save(Animes anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3,10000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }
}
