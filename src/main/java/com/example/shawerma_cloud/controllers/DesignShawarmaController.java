package com.example.shawerma_cloud.controllers;

import com.example.shawerma_cloud.data.Ingredient;
import com.example.shawerma_cloud.data.Shawarma;
import com.example.shawerma_cloud.data.ShawarmaOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("shawarmaOrder")
public class DesignShawarmaController {

    @ModelAttribute
    public void  addIngredients(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour lavash", Ingredient.Type.WRAP),
                new Ingredient("GOTO", "Corn lavash", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour cream", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }
    }

    @ModelAttribute(name = "shawarmaOrder")
    public ShawarmaOrder order(){
        return new ShawarmaOrder();
    }

    @ModelAttribute(name = "shawarma")
    public Shawarma shawarma(){
        return new Shawarma();
    }

    @PostMapping
    public String processShawarma(Shawarma shawarma, @ModelAttribute ShawarmaOrder shawarmaOrder){
        shawarmaOrder.addShawarma(shawarma);
        log.info("Processing shawarma: {}", shawarma);
        return "redirect:/orders/current";
    }
    @GetMapping
    public String showDesignForm(){
        return "design";
    }
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
