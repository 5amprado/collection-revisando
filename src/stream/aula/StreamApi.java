package stream.aula;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays
                .asList("1","0","4","1","2","3","9","9","6","5");
        System.out.println("--\tImprima usando Stream");
        //o proprio list ja possui um metodo foreach
        numerosAleatorios.stream()
                .forEach(System.out::println);

        System.out.println("--\tImprima os 5 primeiros numeros e coloque em um set\t--");
        //lembrando que o set não repete elementos
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("--\tTransforme esta lista de String em inteiros\t--");
        List<Integer> collectorList = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("--\tPonha os número pares maior que 2 em uma lista\t--");
        List<Integer> pares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0 && n > 2)
                .collect(Collectors.toList());
        System.out.println(pares);

        System.out.println("--\tMostre a media usando stream\t--");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("--\tRemova os impares\t--");
        List<Integer> inteiros = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        inteiros.removeIf(i -> i % 2 !=0);
        System.out.println(inteiros);

        //stream não altera o array original, o metodo removeIf altera
    }
}
