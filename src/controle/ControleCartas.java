package controle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author YU7
 */
public class ControleCartas {

    private final String path;

    public ControleCartas() {
        this.path = System.getProperty("user.dir") + "\\img\\";
    }

    public int ValordaCarta(String carta) {

        int valor = 0;

        for (int i = 1; i < 11; i++) {

            if (carta.equals(i + "p")) {
                valor = i;
            }
            if (carta.equals(i + "c")) {
                valor = i;
            }
            if (carta.equals(i + "e")) {
                valor = i;
            }
            if (carta.equals(i + "o")) {
                valor = i;
            }
        }
        return valor;

    }

    public int JogarCarta(JLabel lb, String carta, int manilha) {

        int naipe = 0;

        for (int i = 1; i < 11; i++) {
            if (carta.equals(i + "p")) {
                lb.setEnabled(true);
                lb.setIcon(new ImageIcon(path + i + "P.png"));
                if (i == manilha) {
                    naipe = 4;
                }
            }
            if (carta.equals(i + "c")) {
                lb.setEnabled(true);
                lb.setIcon(new ImageIcon(path + i + "C.png"));
                if (i == manilha) {
                    naipe = 3;
                }
            }

            if (carta.equals(i + "e")) {
                lb.setEnabled(true);
                lb.setIcon(new ImageIcon(path + i + "E.png"));
                if (i == manilha) {
                    naipe = 2;
                }
            }
            if (carta.equals(i + "o")) {
                lb.setEnabled(true);
                lb.setIcon(new ImageIcon(path + i + "O.png"));
                if (i == manilha) {
                    naipe = 1;
                }
            }

        }

        return naipe;

    }

    public void DistribuirCartas(JLabel[] labels, String[] cartas, boolean mostra) {

        for (int i = 1; i < 11; i++) {
            //cartas jogador
            if (cartas[0].equals(i + "c")) {
                labels[0].setIcon(new ImageIcon(path + i + "C.png"));
            }
            if (cartas[1].equals(i + "c")) {
                labels[1].setIcon(new ImageIcon(path + i + "C.png"));
            }
            if (cartas[2].equals(i + "c")) {
                labels[2].setIcon(new ImageIcon(path + i + "C.png"));
            }
            //cartas computador
            if (cartas[3].equals(i + "c")) {
                labels[3].setIcon(new ImageIcon(path + i + "C.png"));
            }
            if (cartas[4].equals(i + "c")) {
                labels[4].setIcon(new ImageIcon(path + i + "C.png"));
            }
            if (cartas[5].equals(i + "c")) {
                labels[5].setIcon(new ImageIcon(path + i + "C.png"));
            }
        }

        //distribuição das cartas de paus dos jogadores
        for (int i = 1; i < 11; i++) {
            //cartas jogador
            if (cartas[0].equals(i + "p")) {
                labels[0].setIcon(new ImageIcon(path + i + "P.png"));
            }
            if (cartas[1].equals(i + "p")) {
                labels[1].setIcon(new ImageIcon(path + i + "P.png"));
            }
            if (cartas[2].equals(i + "p")) {
                labels[2].setIcon(new ImageIcon(path + i + "P.png"));
            }
            
            //cartas computador
            if (cartas[3].equals(i + "p")) {
                labels[3].setIcon(new ImageIcon(path + i + "P.png"));
            }
            if (cartas[4].equals(i + "p")) {
                labels[4].setIcon(new ImageIcon(path + i + "P.png"));
            }
            if (cartas[5].equals(i + "p")) {
                labels[5].setIcon(new ImageIcon(path + i + "P.png"));
            }
        }

        //distribuição das cartas de espadas dos jogadores
        for (int i = 1; i < 11; i++) {
            //cartas jogador
            if (cartas[0].equals(i + "e")) {
                labels[0].setIcon(new ImageIcon(path + i + "E.png"));
            }
            if (cartas[1].equals(i + "e")) {
                labels[1].setIcon(new ImageIcon(path + i + "E.png"));
            }
            if (cartas[2].equals(i + "e")) {
                labels[2].setIcon(new ImageIcon(path + i + "E.png"));
            }
            //cartas computador
            if (cartas[3].equals(i + "e")) {
                labels[3].setIcon(new ImageIcon(path + i + "E.png"));
            }
            if (cartas[4].equals(i + "e")) {
                labels[4].setIcon(new ImageIcon(path + i + "E.png"));
            }
            if (cartas[5].equals(i + "e")) {
                labels[5].setIcon(new ImageIcon(path + i + "E.png"));
            }
        }

        //distribuição das cartas de ouros dos jogadores
        for (int i = 1; i < 11; i++) {
            //cartas jogador
            if (cartas[0].equals(i + "o")) {
                labels[0].setIcon(new ImageIcon(path + i + "O.png"));
            }
            if (cartas[1].equals(i + "o")) {
                labels[1].setIcon(new ImageIcon(path + i + "O.png"));
            }
            if (cartas[2].equals(i + "o")) {
                labels[2].setIcon(new ImageIcon(path + i + "O.png"));
            }
            //cartas computador
            if (cartas[3].equals(i + "o")) {
                labels[3].setIcon(new ImageIcon(path + i + "O.png"));
            }
            if (cartas[4].equals(i + "o")) {
                labels[4].setIcon(new ImageIcon(path + i + "O.png"));
            }
            if (cartas[5].equals(i + "o")) {
                labels[5].setIcon(new ImageIcon(path + i + "O.png"));
            }
        }
        
        //mostra as cartas do Computador
        if (mostra == false) {
            labels[3].setIcon(new ImageIcon(path + "baralho72.png"));
            labels[4].setIcon(new ImageIcon(path + "baralho72.png"));
            labels[5].setIcon(new ImageIcon(path + "baralho72.png"));
        }
        
    }

}
