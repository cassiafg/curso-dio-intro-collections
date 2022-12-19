package map;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("-- Ordem Aleatória --");
        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
           put("Duhigg, Charles", new Livro("O Poder do Hábito", 256));
           put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 256));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        System.out.println("-- Ordem Inserção --");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        System.out.println("-- Ordem Alfabética Autores --");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        System.out.println("-- Ordem Alfabética Nomes dos Livros --");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros3) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        System.out.println("-- Ordem de Número de Páginas --");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNPaginas());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros4){
            System.out.println(livro.getKey()+" - "+livro.getValue().getPaginas()+" - "+livro.getValue().getNome());
        }
    }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livros = (Livro) o;
        return nome.equals(livros.nome) && paginas.equals(livros.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livros{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareTo(l2.getValue().getNome());
    }
}

class ComparatorNPaginas implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}
