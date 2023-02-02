package set.exercicio;

import java.util.*;

public class LinguagemFavorita {
    /*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
    public static void main(String[] args) {
        Set<Linguagens> minhasLinguagensFavoritas = new HashSet<Linguagens>(){{
            add(new Linguagens("Python", 1991, "Pycharm"));
            add(new Linguagens("JavaScript", 1995, "VSCode"));
            add(new Linguagens("Java", 1991, "IntelliJ"));
        }};

        System.out.println("--\tOrdem de inserção\t--");
        Set<Linguagens> minhasLinguagens1 = new LinkedHashSet<>(minhasLinguagensFavoritas);
        for(Linguagens linguagem : minhasLinguagens1) System.out.println(linguagem);

        System.out.println("--\tOrdem natural(nome)\t--");
        Set<Linguagens> minhasLinguagensFavoritas2 = new TreeSet<>(minhasLinguagensFavoritas);
        for(Linguagens linguagem : minhasLinguagensFavoritas2) System.out.println(linguagem);

        System.out.println("--\tOrdem (IDE)\t--");
        Set<Linguagens> minhasLinguagensFavoritas3 = new TreeSet<>(new CompareIde());
        minhasLinguagensFavoritas3.addAll(minhasLinguagensFavoritas);
        for(Linguagens linguagens : minhasLinguagensFavoritas3) System.out.println(linguagens);

        System.out.println("--\tOrdem  (Ano de criação e nome)\t--");
        Set<Linguagens> minhasLinguagensFavoritas4 = new TreeSet<>(new CompareDataNome());
        minhasLinguagensFavoritas4.addAll(minhasLinguagensFavoritas);
        for(Linguagens linguagens : minhasLinguagensFavoritas4) System.out.println(linguagens);

        System.out.println("--\tOrdem  (Nome, Ano de criação e Ide)\t--");
        Set<Linguagens> minhasLinguagensFavoritas5 = new TreeSet<>(new CompareNomeDataIde());
        minhasLinguagensFavoritas5.addAll(minhasLinguagensFavoritas);
        for(Linguagens linguagens : minhasLinguagensFavoritas5) System.out.println(linguagens);

    }
}

class Linguagens implements Comparable<Linguagens>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public Linguagens(String nome, Integer anoDeCriacao, String ide) {
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
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linguagens that = (Linguagens) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public int compareTo(Linguagens linguagens) {
        return this.getNome().compareTo(linguagens.getNome());
    }
}

class CompareIde implements Comparator<Linguagens>{

    @Override
    public int compare(Linguagens l1, Linguagens l2) {
        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}

class CompareDataNome implements Comparator<Linguagens>{

    @Override
    public int compare(Linguagens l1, Linguagens l2) {
        int data = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(data!=0) return data;
        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }
}

class CompareNomeDataIde implements Comparator<Linguagens>{

    @Override
    public int compare(Linguagens l1, Linguagens l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        if(nome!=0) return nome;
        int data = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(data!=0) return data;
        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}