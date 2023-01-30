package exercicios;

import java.util.*;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
public class Exercicio2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> respostas = new ArrayList<String>();
        List<String> perguntas = new ArrayList<String>(
                Arrays.asList(
                         "Telefonou para a vítima?",
                        "Esteve no local do crime?",
                        "Mora perto da vítima?",
                        "Devia para a vítima?",
                        "Já trabalhou com a vítima?"
                )
        );

        for(String pergunta : perguntas){
            System.out.print(pergunta);
            String resposta = scan.next();
            respostas.add(resposta.toLowerCase());

        }
        System.out.println(respostas);

        int count = 0;
        Iterator<String> contador = respostas.iterator();
        while(contador.hasNext()){
            String resp = contador.next();
            if(resp.contains("s")){
                count++;
            }
        }

        switch (count){
            case 2:
                System.out.println("SUSPEITA");
                break;
            case 3:
                System.out.println("CUMPLÍCE");
                break;
            case 4:
                System.out.println("CÚMPLICE");
                break;
            case 5:
                System.out.println("ASSASSINO");
                    break;
            default:
                System.out.println("INOCENTE");
                break;
        }
    }


}
