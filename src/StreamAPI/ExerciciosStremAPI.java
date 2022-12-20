package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExerciciosStremAPI {
    public static void main(String[] args) {
        List<String> numeroAleatorios =
                Arrays.asList("1", "0", "4","1", "2", "3","9","9","6","5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        //LAMBDA
        //numeroAleatorios.stream().forEach( s -> System.out.println(s));

        //REFERENCE METHOD
        numeroAleatorios.stream().forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
        numeroAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
        List<Integer> collectList = numeroAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(collectList);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
        List<Integer> listParesMaioresQue2 = numeroAleatorios.stream()
                .map(Integer::parseInt)
                .filter( i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
        numeroAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        collectList.removeIf(integer -> (integer % 2 != 0));
        System.out.println(collectList);
    }
}


