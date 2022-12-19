/*
    Crie uma classe LinguagemFavorita que possua os atributos
    nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
    3 linguagens e faça um programa que ordene esse conjunto
    por:
    A. Ordem de Inserção
    B. Ordem Natural (nome)
    C. IDE
    D. Ano de criação e nome
    E. Nome, ano de criação e IDE
    Ao final, exiba as linguagens no console, uma abaixo da outra.
 */

import java.util.*;

public class ExercicioSet2 {
    public static void main(String[] args) {
        System.out.println("Ordem de Inserção");
        Set<LinguagemFavorita> linguagensFavoritas = new LinkedHashSet<>(){{
           add(new LinguagemFavorita("Java", 1991, "Intellij"));
           add(new LinguagemFavorita("Python", 1991, "PyCharm"));
           add(new LinguagemFavorita("JavaScript", 1995, "VSCode"));
        }};
        for (LinguagemFavorita linguagemFavorita:linguagensFavoritas
             ) {
            System.out.println(linguagemFavorita.getNome()+" - "+linguagemFavorita.getAnoDeCriacao()+
                    " - "+linguagemFavorita.getIde());
        }

        System.out.println("Ordem Natural (Nome)");
        Set<LinguagemFavorita> linguagensFavoritas1 = new TreeSet<>(linguagensFavoritas);
        for (LinguagemFavorita linguagemFavorita:linguagensFavoritas1
             ) {
            System.out.println(linguagemFavorita.getNome()+" - "+linguagemFavorita.getAnoDeCriacao()+
                    " - "+linguagemFavorita.getIde());
        }

        System.out.println("IDE");
        Set<LinguagemFavorita> linguagensFavoritas2 = new TreeSet<>(new CompareToIDE());
        linguagensFavoritas2.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagemFavorita:linguagensFavoritas2
             ) {
            System.out.println(linguagemFavorita.getNome()+" - "+linguagemFavorita.getAnoDeCriacao()+
                    " - "+linguagemFavorita.getIde());
        }

        System.out.println("Ano de Criação e Nome");
        Set<LinguagemFavorita> linguagensFavoritas3 = new TreeSet<>(new CompareToAnoDeCriacaoNome());
        linguagensFavoritas3.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagemFavorita:linguagensFavoritas3
             ) {
            System.out.println(linguagemFavorita.getNome()+" - "+linguagemFavorita.getAnoDeCriacao()+
                    " - "+ linguagemFavorita.getIde());
        }

        System.out.println("Nome, Ano de Criação e IDE");
        Set<LinguagemFavorita> linguagensFavoritas4 = new TreeSet<>(new CompareToNomeAnoDeCriacaoIde());
        linguagensFavoritas4.addAll(linguagensFavoritas);
        for (LinguagemFavorita linguagemFavorita:linguagensFavoritas4
             ) {
            System.out.println(linguagemFavorita.getNome()+" - "+linguagemFavorita.getAnoDeCriacao()+
                    " - "+linguagemFavorita.getIde());
        }
    }
}


class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    String nome;
    int anoDeCriacao;
    String ide;

    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao='" + anoDeCriacao + '\'' +
                ", ide='" + ide + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        int nome = this.getNome().compareTo(o.getNome());
        if (nome != 0) return nome;
        return 0;
    }
}

class CompareToNomeAnoDeCriacaoIde implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if(nome != 0) return nome;

        int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if(ano != 0) return ano;

        return o1.getIde().compareTo(o2.getIde());

    }
}

class CompareToAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (ano!= 0) return ano;

        return o1.getNome().compareTo(o2.getNome());
    }
}

class CompareToIDE implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareTo(o2.getIde());
    }
}
