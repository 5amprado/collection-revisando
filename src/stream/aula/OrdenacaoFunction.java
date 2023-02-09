package stream.aula;


import java.util.*;

public class OrdenacaoFunction {
    public static void main(String[] args) {
        Map<Integer, Contato> agenda = new HashMap<Integer, Contato>(){{
            put(1, new Contato("Sam", 888888));
            put(4, new Contato("Josuke", 999999));
            put(3, new Contato("Dio", 777777));
        }};


        System.out.println("--\tOrganize por telefone (classe anonima)\t--");
        //Classe Anonima
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(
                new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getTelefone(), cont2.getValue().getTelefone());
            }
        });*/

        //Functional interface
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getTelefone();
                    }
                }
        ));*/

        //Lambda
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                cont ->  cont.getValue().getTelefone()));


        set.addAll(agenda.entrySet());
        System.out.println(set);
    }
}
