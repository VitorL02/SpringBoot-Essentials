package com.springessentials.mapper;

import com.springessentials.dtos.AnimePostDto;
import com.springessentials.dtos.AnimePutDto;
import com.springessentials.models.Animes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // realiza a injeção de dependencias caso necessario
public abstract class AnimeMapper {
    public static final AnimeMapper  INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Animes toAnime(AnimePutDto animePutDto); // Realiza o mapeamento automaticamente
    public abstract Animes toAnime(AnimePostDto animePostDto);
}
