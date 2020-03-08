package controle;

import java.util.Arrays;

/**
 *
 * @author Alexandre
 */
public class BaseDeProducao {

    static int manilha = 5;

    public static void main(String[] args) {

        /* 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, mO, mE, mC, mP*/
        int[] c = {3, 5, 2};
        System.out.println("melhor carta " + melhorJogada(c, 4));

    }

    static int melhorJogada(int[] cartas, int jogada) {

        System.out.println("" + Arrays.toString(cartas));
        
        
        
        
        return 0;

    }

}
