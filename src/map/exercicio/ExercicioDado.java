package map.exercicio;

import java.util.*;

public class ExercicioDado {

    /*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */
    public static void main(String[] args) {
        int lancamentos = 100;
        List<Integer> resultadosLista = new ArrayList<>();
        Random gerador = new Random();

        for(int i=0; i<lancamentos ; i++){
            int numero = gerador.nextInt(6) + 1;
            resultadosLista.add(numero);
        }
        Map<Integer, Integer> resultadosDicionario = new HashMap<>();
        for(Integer resultado : resultadosLista){
            if(resultadosDicionario.containsKey(resultado)){
                resultadosDicionario.put(resultado, resultadosDicionario.get(resultado) + 1);
            } else {
                resultadosDicionario.put(resultado, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : resultadosDicionario.entrySet()){
            System.out.println("Resultado: " + entry.getKey() + " | Lançamentos: "
            + entry.getValue());
        }


    }
}
