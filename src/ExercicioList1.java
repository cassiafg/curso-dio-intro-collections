/*
    Faça um programa que receba a temperatura média dos 6
    primeiros meses do ano e armazene-as em uma lista.
    Após isto, calcule a média semestral das temperaturas e
    mostre todas as temperaturas acima desta média, e em que
    mês elas ocorreram (mostrar o mês por extenso: 1- Janeiro,
    2 - Fevereiro e etc).
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExercicioList1 {
    public static void main(String[] args) {
        System.out.println("Temperaturas médias dos 6 primeiros meses do ano: ");

        List<Double> temperatutasMedias = new ArrayList<>();
        temperatutasMedias.add(35.5);
        temperatutasMedias.add(30d);
        temperatutasMedias.add(26.8);
        temperatutasMedias.add(25d);
        temperatutasMedias.add(23.5);
        temperatutasMedias.add(19d);
        System.out.println(temperatutasMedias);

        Iterator<Double> iterator = temperatutasMedias.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        Double mediaSemestral = soma/ temperatutasMedias.size();
        System.out.println("Média semestral das temperaturas: "+mediaSemestral);

        Iterator<Double> iterator1 = temperatutasMedias.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if (next > mediaSemestral){
                System.out.print(next + " - ");
            switch (temperatutasMedias.indexOf(next)) {
                case 0:
                    System.out.println("Janeiro");;
                break;
                case 1:
                    System.out.println("Fevereiro");;
                    break;
                case 2:
                    System.out.println("Março");;
                    break;
                case 3:
                    System.out.println("Abril");;
                    break;
                case 4:
                    System.out.println("Maio");;
                    break;
                case 5:
                    System.out.println("Junho");;
                    break;
                default: break;
            }}

        }
    }
}
