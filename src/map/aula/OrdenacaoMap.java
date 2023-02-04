package map.aula;

import java.util.*;

public class OrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("--\tOrdem Aleatório\t--");
        Map<String, Livro> meusLivros = new HashMap<String, Livro>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História no Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21",432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() +" - "+ livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<String, Livro>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História no Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21",432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()){
            System.out.println(livro.getKey() +" - "+ livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabética Autores\t--");
        Map<String, Livro> meuslivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String, Livro> livro : meuslivros2.entrySet()){
            System.out.println(livro.getKey() +" - "+ livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabética Livros\t--");
        Set<Map.Entry<String, Livro>> meuslivros3 = new TreeSet<>(new ComparatorNome());
        meuslivros3.addAll(meusLivros1.entrySet());
        for(Map.Entry<String, Livro> livro : meuslivros3){
            System.out.println(livro.getKey() +" - "+ livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Numérica Paginas\t--");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
        meusLivros4.addAll(meusLivros1.entrySet());
        for(Map.Entry<String, Livro> livroentry : meusLivros4){
            System.out.println(livroentry.getKey()+ " - " + livroentry.getValue());
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
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}
