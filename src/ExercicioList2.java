/*
    Utilizando listas, faça um programa que faça 5 perguntas para uma
    pessoa sobre um crime. As perguntas são:
    1. "Telefonou para a vítima?"
    2. "Esteve no local do crime?"
    3. "Mora perto da vítima?"
    4. "Devia para a vítima?"
    5. "Já trabalhou com a vítima?"
    Se a pessoa responder positivamente a 2 questões ela deve ser
    classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
    "Assassina". Caso contrário, ela será classificada como "Inocente".
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> respostas = new ArrayList<>();
        System.out.println("1 - Telefonou para a vítima? (S ou N)");
        respostas.add(sc.next());
        System.out.println("2 - Esteve no local do crime? (S ou N)");
        respostas.add(sc.next());
        System.out.println("3 - Mora perto da vítima? (S ou N)");
        respostas.add(sc.next());
        System.out.println("4 - Devia para a vítima? (S ou N)");
        respostas.add(sc.next());
        System.out.println("5 - Já trabalhou com a vítima? (S ou N)");
        respostas.add(sc.next());
        System.out.println(respostas);

        respostas.removeIf(resposta -> resposta.equalsIgnoreCase("n"));

        if (respostas.size() == 2) System.out.println("Suspeita");
        if (respostas.size() == 3 | respostas.size() == 4) System.out.println("Cúmplice");
        if (respostas.size() == 5) System.out.println("Assassina");
        if (respostas.size() == 1 | respostas.size() == 0) System.out.println("Inocente");
    }
}
