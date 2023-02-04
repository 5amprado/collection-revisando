package map.aula;

import java.util.*;

public class ExemploMap {

    public static void main(String[] args) {
        Map<String, Double> carrosPopulares = new HashMap<String, Double>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("Substitua o consumo de gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson esta no dicionario: "
                + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: "+ carrosPopulares.get("uno"));

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Qual o modelo mais economico? ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo: "+ modeloMaisEficiente + "\nComsumo: "+ consumoMaisEficiente);
            }
        }

        System.out.println("Qual modelo menos economico? ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entradas = carrosPopulares.entrySet();
        String modeloMenosEconomico = "";

        for (Map.Entry<String, Double> entrada : entradas) {
            if(entrada.getValue().equals(consumoMenosEficiente)){
                modeloMenosEconomico = entrada.getKey();
                System.out.println("Modelo: "+ modeloMenosEconomico + "\nComsumo: "+ consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Double soma = 0d;
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("Exiba a média dos consumos: " +
                soma/carrosPopulares.size());

        System.out.println("Remova os modelos com consumos igual 15.6 km/l: ");
        System.out.println(carrosPopulares);
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Ordene por ordem de adição: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<String, Double>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Ordem Natural (Nome)");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague o Dicionario de carros");
        carrosPopulares.clear();
        System.out.println("Confira se o dicionário esta vazio: " + carrosPopulares.isEmpty());
    }
}
