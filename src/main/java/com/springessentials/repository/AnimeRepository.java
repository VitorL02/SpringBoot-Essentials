package com.springessentials.repository;

import com.springessentials.models.Animes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnimeRepository extends JpaRepository<Animes,Long> {

}
