package set.aula;

import java.util.*;

public class ExemplosSet {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(
                Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d,3.6));
        System.out.println(notas);

        System.out.println("Confira se a nota 5 esta no conjunto: "+ notas.contains(5));

        System.out.println("Exiba a menor nota desse conjunto: "+ Collections.min(notas));

        System.out.println("Exiba a maior nota: "+ Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
    //Lembrando que o set não repete elementos, logo a soma é menor do que a dos valores setados inicialmente

        System.out.printf("Exiba a soma dos valores: %.2f\n", soma);

        System.out.printf("Exiba a média das notas: %.2f\n",(soma/ notas.size()));

        System.out.println("Remova a nota 0: ");
        notas.remove(0.0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba as notas na ordem que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>(
                Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d,3.6));
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto!");
        notas.clear();

        System.out.println("Confira se o conjunto 1 esta vazio: "+notas.isEmpty());
        System.out.println("Confira se o conjunto 2 esta vazio: "+notas2.isEmpty());
    }
}
