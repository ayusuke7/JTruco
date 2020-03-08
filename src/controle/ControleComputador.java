package controle;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author YU7
 */
public class ControleComputador {

    public int retornaJogada(int qtCartas) {

        Random rd = new Random();

        int jogada = rd.nextInt(qtCartas)+1; //retorna de acordo com a qtd de cartas
        
        System.out.println("sorteada carta "+jogada);
        
        return jogada;
    }
    
    public void timerJogada(){
        
        Timer time = new Timer();
        
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                
                
            }
        };
        
        time.scheduleAtFixedRate(tarefa, 0, 0);
    }

}
