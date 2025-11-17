package com.fahami.cda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
     
        // Création d'une liste de nombre
        List<Integer> numbers = List.of(5, 12, 8, 20, 3, 15, 7);

        Predicate<Integer> isEven = a -> a%2 == 0;
        Predicate<Integer> isUpperTen = a -> a > 10;
        Predicate<Integer> isBetweenFiveToFifteen = a -> a >= 5 && a <= 15;

        // Tests unitaires
        IO.println(isEven.test(9));
        IO.println(isUpperTen.test(11));
        IO.println(isBetweenFiveToFifteen.test(4));

        // Tester si la liste des nombre est paire
        numbers.stream()
            .filter(isEven)
            .forEach(n -> IO.println("nombre paire: " + n));
        
        // Tester si la liste des nombre est superieur à 10
            numbers.stream()
            .filter(isUpperTen)
            .forEach(n -> IO.println("Supérieur à 10 : "+ n) );

        // Tester si la liste des nombre est compris entre 5 et 15 (inclus)
            numbers.stream()
                    .filter(isBetweenFiveToFifteen)
                    .forEach(n  -> IO.println(n + " est compris entre 5 et 15"));

       // Créer la lambda expression pour transformer chaque nombre en une chaîne de caracère
        Function<Integer, String> phrase = a -> "Le nombre est : "  + a;
        
        numbers.stream()
                .forEachOrdered(n -> IO.println(phrase.apply(n)));
    
    }

}