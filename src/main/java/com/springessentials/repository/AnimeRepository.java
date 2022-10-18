package com.springessentials.repository;

import com.springessentials.models.Animes;

import java.util.List;

public interface AnimeRepository {
    List<Animes> listAll();
}
