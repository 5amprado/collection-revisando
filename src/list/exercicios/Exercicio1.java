package list.exercicios;



/*Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.*;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        List<Double> temperaturasSemestrais = new ArrayList<Double>();
        //String[] meses = {"JANEIRO","FEVEREIRO","MARÇO","ABRIL","MAIO","JUNHO"};

        //PARA DECLARAR ARRAYSLIST COM VALORES:
        List<String> mesess = new ArrayList<String>(
                Arrays.asList("JANEIRO","FEVEREIRO","MARÇO","ABRIL","MAIO","JUNHO"));


        double soma = 0.0;
        for(int i = 1; i <=6; i++){
            System.out.println("Qual a temperatura do mês "+i+" ?");
            double temperatura = scan.nextDouble();
            temperaturasSemestrais.add(temperatura);
            soma += temperatura;
        }

        double media = soma / 6;

        System.out.println("Temperaturas Semestrais: "+temperaturasSemestrais);
        System.out.println("A média das temperaturas semestrais foi de "+media+"oC");

        System.out.println("As Temperatiras acima desta média sao: ");
        int count = 0;
        for(double tempa : temperaturasSemestrais){
            if(tempa > media){
                System.out.println(mesess.get(count) +" : "+tempa);
                /*Simplificando o codigo, estava usando indexof para listar os meses
                mas estava dando erro de repetição quando havia temperaturas iguais*/
            }
            count++;
        }

    }
}
