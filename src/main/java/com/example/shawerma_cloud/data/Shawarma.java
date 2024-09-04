package com.example.shawerma_cloud.data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Shawarma {
    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message="U must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
