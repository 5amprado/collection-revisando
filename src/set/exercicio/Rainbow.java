package set.exercicio;

import java.util.*;

public class Rainbow {
    /*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */
    public static void main(String[] args) {
        Set<String> coresArcoIris = new HashSet<>(
                Arrays.asList("violeta","anil","azul","verde","amarelo","laranja","vermelho")
        );
        System.out.println("Exiba todas as cores o arco-íris uma abaixo da outra: ");
        for(String cor : coresArcoIris) System.out.println(cor);

        System.out.println("A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris2);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        Set<String> coresArcoIris3 = new LinkedHashSet<>(
                Arrays.asList("violeta","anil","azul","verde","amarelo","laranja","vermelho")
        );
        System.out.println(coresArcoIris3);
        //Collections.reverse só pode ser usado em List
        List<String> coresArcoIrisList = new ArrayList<>(coresArcoIris3);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);

        System.out.println("Exiba todas as cores que começam com a letra 'v': ");
        for(String cor: coresArcoIris){
            if(cor.toLowerCase().startsWith("v")) System.out.println(cor);
        }

        System.out.println("Remova todas as cores que não começam com a letra 'v'");
        Iterator<String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext()){
            if(!iterator.next().toLowerCase().startsWith("v")) iterator.remove();
        }
        System.out.println(coresArcoIris);

        System.out.println("Limpe o conjunto: ");
        coresArcoIris.clear();
        System.out.println("Limpando...:D");

        System.out.println("Confira se o conjunto está vazio: " + (coresArcoIris.isEmpty() ? "Está Vazio" :
                "Não Está Vazio"));
    }
}
