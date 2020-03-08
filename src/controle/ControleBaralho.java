package controle;

import java.util.Random;

/**
 *
 * @author YU7
 */
public class ControleBaralho {

    String[] baralho = {"1p", "2p", "3p", "4p", "5p", "6p", "7p", "8p", "9p", "10p",
                        "1c", "2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "10c",
                        "1e", "2e", "3e", "4e", "5e", "6e", "7e", "8e", "9e", "10e",
                        "1o", "2o", "3o", "4o", "5o", "6o", "7o", "8o", "9o", "10o"};

    public String[] Embaralhamento() {

        int numero;
        int[] dealer = new int[7];
        Random r = new Random();

        for (int i = 0; i < dealer.length; i++) {       //Laço que preenche a posição do Vetor com um numero Aleatorio de 0 a 39
            numero = r.nextInt(38) + 1;                 //Sorteia entre 0 e 39 pois é a posição do Vetor
            for (int j = 0; j < dealer.length; j++) {   //Laço pra fazer os teste de numeros repetidos
                if (numero == dealer[j] && j != i) {    //caso o numero for igual a a posição [i] do vetor dealer 
                    numero = r.nextInt(38) + 1;         //sorteia novamente  
                } else {
                    dealer[i] = numero;                 //Senão a posição recebe o numero sorteado
                }
            }
        }

        String cartas[] = new String[7];

        //Cartas do Jogador1 
        cartas[0] = baralho[dealer[0]];
        cartas[1] = baralho[dealer[1]];
        cartas[2] = baralho[dealer[2]];

        //Cartas do Computador
        cartas[3] = baralho[dealer[3]];
        cartas[4] = baralho[dealer[4]];
        cartas[5] = baralho[dealer[5]];

        //Carta de maior valor do Jogo
        cartas[6] = baralho[dealer[6]];

        return cartas;

    }

}
