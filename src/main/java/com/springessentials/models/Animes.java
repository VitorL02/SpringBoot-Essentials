package com.springessentials.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Com esse bean o spring gera os geters e setters
@AllArgsConstructor
public class Animes {

    private Long id;
    private String name;


}
