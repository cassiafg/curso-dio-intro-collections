/*
    Crie um conjunto contendo as cores do arco-íris e:
    A. Exiba todas as cores uma abaixo da outra
    B. A quantidade de cores que o arco-íris tem
    C. Exiba as cores em ordem alfabética
    D. Exiba as cores na ordem inversa da que foi informada
    E. Exiba todas as cores que começam com a letra "v"
    F. Remova todas as cores que não começam com a letra "v"
    G. Limpe o conjunto
    H. Confira se o conjunto está vazio
 */

import java.util.*;

public class ExercicioSet1 {
    public static void main(String[] args) {
        System.out.println("Exiba todas as cores uma abaixo da outra: ");
        Set<String> coresDoArcoIris = new HashSet<>
                (Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Anil", "Violeta"));
//        System.out.println(coresDoArcoIris);
        for (String cor:coresDoArcoIris) System.out.println(cor);

        System.out.println("A quantidade de cores que o arco-íris tem: " + coresDoArcoIris.size()+" cores.");

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> coresDoArcoIris1 = new TreeSet<>(coresDoArcoIris);
        System.out.println(coresDoArcoIris1);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        Set <String> coresDoArcoIris2 = new LinkedHashSet<>();
        coresDoArcoIris2.addAll(coresDoArcoIris);
        System.out.println(coresDoArcoIris2);
        List<String> coresDoArcoIrisList = new ArrayList<>(coresDoArcoIris2);
        Collections.reverse(coresDoArcoIrisList);
        System.out.println(coresDoArcoIrisList);

        System.out.println("Exiba todas as cores que começam com a letra \"v\"");
        for (String cor:coresDoArcoIris
             ) {if (cor.startsWith("V")) System.out.println(cor);
        }
//        Iterator<String> iterator = coresDoArcoIris.iterator();
//        while(iterator.hasNext()){
//            String next = iterator.next();
//            if (!next.contains("V")) iterator.remove();
//        }
//        System.out.println(coresDoArcoIris);

        System.out.println("Remova todas as cores que não começam com a letra \"v\"");
        Iterator<String> iterator1 = coresDoArcoIris1.iterator();
        while(iterator1.hasNext()){
            String next = iterator1.next();
            if (!next.startsWith("V")) iterator1.remove();
        }
        System.out.println(coresDoArcoIris1);

        System.out.println("Limpe o conjunto: ");
        coresDoArcoIris.clear();
//        coresDoArcoIris.removeAll(coresDoArcoIris);

        System.out.println("Confira se o conjunto está vazio: ");
        System.out.println("Está vazio? "+coresDoArcoIris.isEmpty());

    }
}
