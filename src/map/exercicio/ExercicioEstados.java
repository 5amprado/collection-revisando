package map.exercicio;

import java.util.*;

public class ExercicioEstados {/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> estadosPopulacao = new HashMap<String, Integer>(){{
           put("PE",9616621);
           put("AL",3351543);
           put("CE",9187103);
           put("RN",3534265);
        }};
        System.out.println(estadosPopulacao);

        System.out.println("Substitua a população do estado RN por : 3.534.165");
        estadosPopulacao.put("RN", 3534165);
        System.out.println(estadosPopulacao);

        System.out.println("Confira se o estado da Paraíba (PB)está no dicionário, " +
                "caso não, adicione PB - 4.039.277: ");
        if(estadosPopulacao.containsKey("PB")){
            System.out.println("Ja Contém");
        } else{
            estadosPopulacao.put("PB", 4039277);
        }
        System.out.println(estadosPopulacao);

        System.out.println("Exiba a população do estado PE: " + estadosPopulacao.get("PE"));

        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> estadosPopulacao1 = new LinkedHashMap<String, Integer>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};
        System.out.println(estadosPopulacao1);

        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> estadosPopulacao3 = new TreeMap<>(estadosPopulacao);
        System.out.println(estadosPopulacao3);

        System.out.println("Exiba o estado com a menor população e seu respectivo valor: ");
        Collection<Integer> populacao = estadosPopulacao.values();
        String estadoMenosPopuloso = "";

        for(Map.Entry<String, Integer> entry : estadosPopulacao.entrySet()){
            if(entry.getValue().equals(Collections.min(populacao))) estadoMenosPopuloso = entry.getKey();
        }
        System.out.println(estadoMenosPopuloso);

        System.out.println("Exiba o estado com a maior população e seu respectivo valor: ");
        Collection<Integer> populacao1 = estadosPopulacao.values();
        String estadoMaisPopuloso = "";
        for(Map.Entry<String, Integer> entry1 : estadosPopulacao.entrySet()){
            if(entry1.getValue().equals(Collections.max(populacao1))) estadoMaisPopuloso = entry1.getKey();
        }
        System.out.println(estadoMaisPopuloso);

        System.out.println("Exiba a soma da população desses estados: ");
        int soma = 0;
        Iterator<Integer> iterator = estadosPopulacao.values().iterator();
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("Exiba a média da população deste dicionário de estados: "
                + (soma / estadosPopulacao.size()));

        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = estadosPopulacao.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next() < 4000000) iterator1.remove();
        }
        System.out.println(estadosPopulacao);

        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        estadosPopulacao.clear();

        System.out.println("Confira se a lista está vazia: " + estadosPopulacao.isEmpty());
    }
}
