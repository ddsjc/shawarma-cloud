package com.example.shawerma_cloud.data;

import lombok.Data;

import java.util.List;

@Data
public class Shawarma {
    private String name;
    private List<Ingredient> ingredients;
}
