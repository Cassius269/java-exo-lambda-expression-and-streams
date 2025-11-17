package com.fahami.cda;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
     
        // Création d'une liste de nombre
        List<Integer> numbers = List.of(5, 12, 8, 20, 3, 15, 7);

        Predicate<Integer> isEven =  (a) -> {
            boolean result = true;

            if(a%2 == 0) {
                 result = result;
            }else {
                result = !result;
            }

            return result;
        };

        Predicate<Integer> isUpperTen = a -> {
            if(a > 10){
                return true;
            }else {
                return false;
            }
        };


        Predicate<Integer> isBetweenFiveToFifteen = a -> {
            if(a>=5 && a<=15){
                return true;
            }else {
                return false;
            }
        };

        IO.println(isEven.test(9));
        IO.println(isUpperTen.test(11));
        IO.println(isBetweenFiveToFifteen.test(4));

        // Tester si la liste des nombre est paire
        numbers.stream()
            .forEach(n -> {
                if (isEven.test(n)) IO.println(n + " est paire");
                if (!isEven.test(n))    IO.println(n + " est impaire");         
            });
        

        // Tester si la liste des nombre est superieur à 10
            numbers.stream()
            .forEach(n -> {
                if(isUpperTen.test(n)) IO.println(n + " > 10");
                if(!isUpperTen.test(n)) IO.println(n + " < 10");
            });

        // Tester si la liste des nombre est compris entre 5 et 15 (inclus)
            numbers.stream()
                    .forEach(n  -> {
                        if(isBetweenFiveToFifteen.test(n)) IO.println(n + " est compris entre 5 et 15");
                        if (!isBetweenFiveToFifteen.test(n)) IO.println(n + " n'est pas compris entre 5 et 15");
                    });

       // Créer la lambda expression pour transformer chaque nombre en une chaîne de caracère
        Function<Integer, String> phrase = a -> "Le nombre est : "  + a;
        
        numbers.stream()
                .forEachOrdered(n -> IO.println(phrase.apply(n)));
    
    }

    @FunctionalInterface
    public interface Predicate<Integer> {
        /**
         * Méthode pour appliquer un test sur un nombre
         * @param number le nombre à tester
         * @return True si le test est réussi, False si le test a échoué
         */
        boolean test(Integer number);
    }

    // @FunctionalInterface
    // public interface  Function<Integer,String>  
    //     String apply(Integer number, String phrase);
    // }
}