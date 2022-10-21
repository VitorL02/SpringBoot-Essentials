package com.springessentials.dtos;


import lombok.Data;

@Data
public class AnimePostDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
