package com.fahami.cda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fahami.cda.entity.Product;
import com.fahami.cda.entity.enumeration.Category;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Category> categories = List.of(Category.Alimentation, Category.Vêtement, Category.Électronique);
        Random randum = new Random();

        for(int i = 0; i < 10; i++){
            Product product = new Product();
            product.setName("product"+(i+1));
            product.setPrice(randum.nextDouble(100));
            product.setIsOutOfStock(randum.nextBoolean());
            product.setCategory(categories.get(randum.nextInt(categories.size()))); // générer un index aléatoire de la liste des catégories pour charger une catégorie

            products.add(product);
        }

        // Tester la création des 10 produits
        products.stream()
            .forEach(IO::println);

        // Les prédicats
        Predicate<Product> isElectronic = p -> p.getCategory() == Category.Électronique; // prédicat des produits électroniques
        Predicate<Product> isOutOfStock = p -> p.getIsOutOfStock() == false; // prédicat des produits en stock
        Predicate<Product> isUnderFiveEuros = p -> p.getPrice() <= 5.0 && p.getCategory() == Category.Alimentation ; // prédicat des produits alimentaires de moins de 5 euros
        
        // Filtrer les produits électroniques encore en stock
        IO.println("La liste des produits électroniques encore en stock: ");
        products.stream()
                .filter(isElectronic) // méthode intermédiaire
                .filter(isOutOfStock) // méthode intermédiaire
                .forEach(IO::println); // méthode terminale
        

        // Afficher tous les noms du produits en majuscule
        List<String> productsUpper = products.stream()
                                    .map(p -> p.getName().toUpperCase()) // méthode intermédiaire
                                    .collect(Collectors.toList()); // méthode terminale
        IO.println("La liste des produits transformés en majuscule :");
        productsUpper.forEach(p -> IO.println(p));

        // Calculer le prix moyen de tous les produits
        double averagePrice = products.stream()
                                .mapToDouble(p -> p.getPrice()) // recupérer les prix, méthode intermédiaire
                                .average() // calculer le prix moyen, méthode terminale
                                .orElse(0.0); // si pas de moyenne trouvée renvoyer 0.0, méthode terminale

        IO.println("Prix moyen : " + averagePrice + "euros");

        // Trouver le produit le plus cher
        Optional<Product> mostExpensiveProduct = products.stream()
                                                  .max((a,b) -> (int)( a.getPrice() - b.getPrice()));// méthode terminale

        IO.println("Le produit le plus cher : " + mostExpensiveProduct);

        // Trouver les produits alimentaires de moins de 5 euros
        boolean isFoodUnderFiveEuros = products.stream()
                                        .anyMatch(isUnderFiveEuros); // méthode terminale
        IO.println(isFoodUnderFiveEuros); // afficher si un produit alimentaire au moins de moins 5 euros a été trouvé dans le flux des produits
    }
}