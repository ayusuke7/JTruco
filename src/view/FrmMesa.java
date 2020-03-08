package view;

import controle.ControleCartas;
import controle.ControleBaralho;
import controle.ControleComputador;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrmMesa extends javax.swing.JFrame {

    ControleCartas contC = new ControleCartas();

    private final String path;
    private String jog_c1, jog_c2, jog_c3, comp_c1, comp_c2, comp_c3, manilha;
    private int jogada1, jogada2, naipeJ1, naipeJ2, ma, contadorJog = 0, contadorComp = 0;

    int contadorPart = 1;

    ArrayList maos = new ArrayList();

    public FrmMesa(String pers, int op) {
        initComponents();
        path = System.getProperty("user.dir") + "\\img\\";
        setIconePersonagem(pers, op);
        DistribuirCartas(true);
    }

    public final void setIconePersonagem(String pers, int op) {

        URL url = getClass().getResource("icone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);

        switch (op) {
            case 1:
                lbPersonJog.setIcon(new ImageIcon(path + "P1_mesa.png"));
                tfNomeJog.setText(pers);
                break;
            case 2:
                lbPersonJog.setIcon(new ImageIcon(path + "P2_mesa.png"));
                tfNomeJog.setText(pers);
                break;
        }

    }

    public final void DistribuirCartas(boolean op) {

        ControleBaralho carteiro = new ControleBaralho();
        String[] cartas = carteiro.Embaralhamento();

        //Cartas Jogador
        jog_c1 = cartas[0];
        jog_c2 = cartas[1];
        jog_c3 = cartas[2];

        //Cartas Computador
        comp_c1 = cartas[3];
        comp_c2 = cartas[4];
        comp_c3 = cartas[5];

        //Carta vira para indicar a manilha
        manilha = cartas[6];

        //Distribuição/virar as dartas dos jogadores
        JLabel[] labels = new JLabel[6];
        labels[0] = lbJogadorC1;
        labels[1] = lbJogadorC2;
        labels[2] = lbJogadorC3;
        labels[3] = lbCompC1;
        labels[4] = lbCompC2;
        labels[5] = lbCompC3;

        //valor boolean para mostrar ou ocultar as cartas do computador
        contC.DistribuirCartas(labels, cartas, true);

        //Virar a manilha do Jogo e salva na variavel "ma" o vira+1, no caso é a manilha     
        for (int i = 1; i < 11; i++) {

            if (manilha.equals(i + "p")) {
                lbBaralho.setIcon(new ImageIcon(path + i + "P.png"));
                if (i == 10) {
                    ma = 1;
                } else {
                    ma = i + 1;
                }
            }
            if (manilha.equals(i + "c")) {
                lbBaralho.setIcon(new ImageIcon(path + i + "C.png"));
                if (i == 10) {
                    ma = 1;
                } else {
                    ma = i + 1;
                }
            }
            if (manilha.equals(i + "e")) {
                lbBaralho.setIcon(new ImageIcon(path + i + "E.png"));
                if (i == 10) {
                    ma = 1;
                } else {
                    ma = i + 1;
                }
            }
            if (manilha.equals(i + "o")) {
                lbBaralho.setIcon(new ImageIcon(path + i + "O.png"));
                if (i == 10) {
                    ma = 1;
                } else {
                    ma = i + 1;
                }
            }
        }

        System.out.println("manilha: " + ma);

    }

    public void VerificaVencedorMao() {

        //Caso a jogada seja maninha
        if (jogada1 == ma) {
            //Caso seja jogado 2 manilhas comparar naipes
            if (jogada1 == ma && jogada2 == ma) {
                if (naipeJ1 > naipeJ2) {
                    contadorJog++;
                    System.out.println("Jogador vencedor\n");
                    Placares(contadorJog, "Jogador");
                    rbJogador.setSelected(true);
                    maos.add("J");
                    tfAndamento.setText(tfAndamento.getText() + "-" + "J");
                } else {
                    contadorComp++;
                    System.out.println("Computador vencedor\n");
                    Placares(contadorComp, "Computador");
                    rbComputador.setSelected(true);
                    maos.add("C");
                    tfAndamento.setText(tfAndamento.getText() + "-" + "J");
                }
            } else {
                contadorJog++;
                System.out.println("Jogador vencedor\n");
                Placares(contadorJog, "Jogador");
                maos.add("J");
                rbJogador.setSelected(true);
            }
            //Compara caso a jogada for um 3 2 e 1 (As)
        } else if (jogada1 == 3 && jogada2 != 3 && jogada2 != ma) {
            contadorJog++;
            System.out.println("Jogador vencedor\n");
            Placares(contadorJog, "Jogador");
            maos.add("J");
            rbJogador.setSelected(true);
        } else if (jogada1 == 2 && jogada2 != 2 && jogada2 != 3 && jogada2 != ma) {
            contadorJog++;
            System.out.println("Jogador vencedor\n");
            Placares(contadorJog, "Jogador");
            maos.add("J");
            rbJogador.setSelected(true);
        } else if (jogada1 == 1 && jogada2 != 1 && jogada2 != 2 && jogada2 != 3 && jogada2 != ma) {
            contadorJog++;
            System.out.println("Jogador vencedor\n");
            Placares(contadorJog, "Jogador");
            maos.add("J");
            rbJogador.setSelected(true);
            //Demais possibilidades K, J, Q, 7, 6, 5, 4
        } else if (jogada1 > jogada2 && jogada2 != 1 && jogada2 != 2 && jogada2 != 3 && jogada2 != ma) {
            contadorJog++;
            System.out.println("Jogador vencedor\n");
            Placares(contadorJog, "Jogador");
            maos.add("J");
            rbJogador.setSelected(true);
            //Caso as jogadas sejam iguais e não sejam manilhas
        } else if (jogada1 == jogada2) {
            System.out.println("Mão Empatada\n");
            Placares(0, "Empate");
            maos.add("E");
        } else {
            contadorComp++;
            System.out.println("Computador vencedor\n");
            Placares(contadorComp, "Computador");
            maos.add("C");
            rbComputador.setSelected(true);
        }
        
    }

    public void Placares(int contador, String jogador) {
        
        if (contador == 2) {
            switch (jogador) {
                case "Jogador":
                    JOptionPane.showMessageDialog(null, tfNomeJog.getText() + " venceu a Mão");
                    int aux1 = Integer.parseInt(tfGeralJog.getText());
                    tfGeralJog.setText(String.valueOf(aux1 + 1));
                    lbJOGADOR.setIcon(null);
                    lbCOMPUT.setIcon(null);
                    contadorJog = 0;
                    contadorComp = 0;
                    DistribuirCartas(true);
                    maos.clear();
                    tfAndamento.setText("");
                    break;
                case "Computador":
                    JOptionPane.showMessageDialog(null, "Computador venceu a Mão");
                    int aux2 = Integer.parseInt(tfGeralComp.getText());
                    tfGeralComp.setText(String.valueOf(aux2 + 1));
                    lbJOGADOR.setIcon(null);
                    lbCOMPUT.setIcon(null);
                    contadorJog = 0;
                    contadorComp = 0;
                    DistribuirCartas(true);
                    maos.clear();
                    tfAndamento.setText("");
                    break;               
            }
        }
        
        if(contador == 3){
            if(maos.get(0).equals("J")){
                JOptionPane.showMessageDialog(null, tfNomeJog.getText() + " venceu a Mão");
                    int aux1 = Integer.parseInt(tfGeralJog.getText());
                    tfGeralJog.setText(String.valueOf(aux1 + 1));
                    lbJOGADOR.setIcon(null);
                    lbCOMPUT.setIcon(null);
                    contadorJog = 0;
                    contadorComp = 0;
                    DistribuirCartas(true);
                    maos.clear();
                    tfAndamento.setText("");
            }
            if(maos.get(0).equals("C")){
                JOptionPane.showMessageDialog(null, "Computador venceu a Mão");
                    int aux2 = Integer.parseInt(tfGeralComp.getText());
                    tfGeralComp.setText(String.valueOf(aux2 + 1));
                    lbJOGADOR.setIcon(null);
                    lbCOMPUT.setIcon(null);
                    contadorJog = 0;
                    contadorComp = 0;
                    DistribuirCartas(true);
                    maos.clear();
                    tfAndamento.setText("");
            }
        }
    }

    public void resetMesa() {
        jogada1 = 0;
        jogada2 = 0;
        lbJOGADOR.setEnabled(false);
        lbCOMPUT.setEnabled(false);

    }

    public void simularJogadaPC() {

        if (rbComputador.isSelected()) {

            ControleComputador comp = new ControleComputador();
            int jogadaSort = comp.retornaJogada(3);

            if (jogadaSort == 1 && lbCompC1.getIcon() != null) {

                lbCompC1.setIcon(null);

                naipeJ2 = contC.JogarCarta(lbCOMPUT, comp_c1, ma);
                jogada2 = contC.ValordaCarta(comp_c1);

                System.out.println("Comp " + jogada2);
                rbJogador.setSelected(true);

                if (jogada1 > 0 && jogada2 > 0) {
                    VerificaVencedorMao();
                    tfAndamento.setText(maos.toString());
                    resetMesa();
                }

            } else if (jogadaSort == 2 && lbCompC2.getIcon() != null) {
                lbCompC2.setIcon(null);

                naipeJ2 = contC.JogarCarta(lbCOMPUT, comp_c2, ma);
                jogada2 = contC.ValordaCarta(comp_c2);
                System.out.println("Comp " + jogada2);
                rbJogador.setSelected(true);

                if (jogada1 > 0 && jogada2 > 0) {
                    VerificaVencedorMao();
                    tfAndamento.setText(maos.toString());
                    resetMesa();
                }

            } else if (jogadaSort == 3 && lbCompC3.getIcon() != null) {
                lbCompC3.setIcon(null);

                naipeJ2 = contC.JogarCarta(lbCOMPUT, comp_c3, ma);
                jogada2 = contC.ValordaCarta(comp_c3);
                System.out.println("Comp " + jogada2);
                rbJogador.setSelected(true);

                if (jogada1 > 0 && jogada2 > 0) {
                    VerificaVencedorMao();
                    tfAndamento.setText(maos.toString());
                    resetMesa();
                }
            } else {
                simularJogadaPC();
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbCompC3 = new javax.swing.JLabel();
        lbCompC2 = new javax.swing.JLabel();
        lbCompC1 = new javax.swing.JLabel();
        lbJogadorC1 = new javax.swing.JLabel();
        lbJogadorC2 = new javax.swing.JLabel();
        lbJogadorC3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbJOGADOR = new javax.swing.JLabel();
        lbCOMPUT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rbComputador = new javax.swing.JRadioButton();
        rbJogador = new javax.swing.JRadioButton();
        btJogadaPC = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btAbadonar = new javax.swing.JButton();
        btEmbaralhar = new javax.swing.JButton();
        lbBaralho = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfGeralComp = new javax.swing.JTextField();
        tfGeralJog = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        tfAndamento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        lbPersonJog = new javax.swing.JLabel();
        tfNomeJog = new javax.swing.JTextField();
        lbPersonComp = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JTruco v1.0");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCompC3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompC3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho72.PNG"))); // NOI18N

        lbCompC2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho72.PNG"))); // NOI18N

        lbCompC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho72.PNG"))); // NOI18N

        lbJogadorC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJogadorC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho72.PNG"))); // NOI18N
        lbJogadorC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbJogadorC1MouseClicked(evt);
            }
        });

        lbJogadorC2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJogadorC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho72.PNG"))); // NOI18N
        lbJogadorC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbJogadorC2MouseClicked(evt);
            }
        });

        lbJogadorC3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJogadorC3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho72.PNG"))); // NOI18N
        lbJogadorC3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbJogadorC3MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbJOGADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbCOMPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbJOGADOR, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(lbCOMPUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("jogador");

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("Computador");

        rbComputador.setBackground(new java.awt.Color(102, 255, 102));
        buttonGroup1.add(rbComputador);
        rbComputador.setEnabled(false);
        rbComputador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        rbJogador.setBackground(new java.awt.Color(102, 255, 102));
        buttonGroup1.add(rbJogador);
        rbJogador.setSelected(true);
        rbJogador.setEnabled(false);
        rbJogador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btJogadaPC.setText("JOGAR");
        btJogadaPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJogadaPCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbJogador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(lbJogadorC1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbJogadorC2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbJogadorC3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(lbCompC1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCompC2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCompC3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(btJogadaPC)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbCompC3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(lbCompC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCompC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rbComputador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btJogadaPC)))
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbJogadorC2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(lbJogadorC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbJogadorC3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rbJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        btAbadonar.setText("Abandonar");
        btAbadonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbadonarActionPerformed(evt);
            }
        });
        jPanel2.add(btAbadonar);
        btAbadonar.setBounds(20, 410, 128, 23);

        btEmbaralhar.setText("Embaralhar");
        btEmbaralhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmbaralharActionPerformed(evt);
            }
        });
        jPanel2.add(btEmbaralhar);
        btEmbaralhar.setBounds(20, 380, 128, 23);

        lbBaralho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baralho.PNG"))); // NOI18N
        jPanel2.add(lbBaralho);
        lbBaralho.setBounds(42, 31, 82, 123);

        jLabel3.setText("Truco ♣♥♠♦");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(42, 11, 82, 14);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Computador");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 240, 80, 14);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Jogador");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(100, 240, 50, 14);

        tfGeralComp.setEditable(false);
        tfGeralComp.setBackground(new java.awt.Color(255, 255, 255));
        tfGeralComp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfGeralComp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfGeralComp.setText("0");
        jPanel2.add(tfGeralComp);
        tfGeralComp.setBounds(22, 260, 32, 31);

        tfGeralJog.setEditable(false);
        tfGeralJog.setBackground(new java.awt.Color(255, 255, 255));
        tfGeralJog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfGeralJog.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfGeralJog.setText("0");
        jPanel2.add(tfGeralJog);
        tfGeralJog.setBounds(110, 260, 32, 31);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 270, 40, 14);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel2.add(btSair);
        btSair.setBounds(20, 443, 128, 20);

        tfAndamento.setEditable(false);
        tfAndamento.setBackground(new java.awt.Color(255, 255, 255));
        tfAndamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAndamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAndamento.setBorder(null);
        jPanel2.add(tfAndamento);
        tfAndamento.setBounds(10, 210, 140, 15);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 340, 160, 2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbPersonJog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tfNomeJog.setEditable(false);
        tfNomeJog.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeJog.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tfNomeJog.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNomeJog.setBorder(null);

        lbPersonComp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPersonComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-eyes.png"))); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Computador");
        jTextField2.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPersonJog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNomeJog)
                    .addComponent(lbPersonComp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPersonComp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(tfNomeJog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPersonJog, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(836, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAbadonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbadonarActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(tfGeralJog.getText()) > Integer.parseInt(tfGeralComp.getText())) {
            JOptionPane.showConfirmDialog(null, "Tem certeza que deseja abadonar a partida?\n"
                    + "Aparentemente você está ganhando!", "SAIR", JOptionPane.YES_NO_OPTION);
        } else {
            JOptionPane.showConfirmDialog(null, "Termine a partida JOGADOR!\n"
                    + "tudo pode acontecer, acredite!\n"
                    + "deseja sair?", "SAIR", JOptionPane.YES_NO_OPTION);
        }

    }//GEN-LAST:event_btAbadonarActionPerformed

    private void lbJogadorC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbJogadorC1MouseClicked
        // TODO add your handling code here:

        if (rbJogador.isSelected()) {
            lbJogadorC1.setIcon(null);

            naipeJ1 = contC.JogarCarta(lbJOGADOR, jog_c1, ma);
            jogada1 = contC.ValordaCarta(jog_c1);
            System.out.println("Jog " + jogada1);
            rbComputador.setSelected(true);

            if (jogada1 > 0 && jogada2 > 0) {
                VerificaVencedorMao();
                contadorPart++;
//                tfAndamento.setText(maos.toString());
                resetMesa();
            }

            simularJogadaPC();

        }
    }//GEN-LAST:event_lbJogadorC1MouseClicked

    private void lbJogadorC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbJogadorC2MouseClicked
        // TODO add your handling code here:

        if (rbJogador.isSelected()) {
            lbJogadorC2.setIcon(null);

            naipeJ1 = contC.JogarCarta(lbJOGADOR, jog_c2, ma);
            jogada1 = contC.ValordaCarta(jog_c2);

            System.out.println("Jog " + jogada1);
            rbComputador.setSelected(true);

            if (jogada1 > 0 && jogada2 > 0) {
                VerificaVencedorMao();
                contadorPart++;
//                tfAndamento.setText(maos.toString());
                resetMesa();
            }

            simularJogadaPC();

        }

    }//GEN-LAST:event_lbJogadorC2MouseClicked

    private void lbJogadorC3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbJogadorC3MouseClicked
        // TODO add your handling code here:

        if (rbJogador.isSelected()) {
            lbJogadorC3.setIcon(null);

            naipeJ1 = contC.JogarCarta(lbJOGADOR, jog_c3, ma);
            jogada1 = contC.ValordaCarta(jog_c3);

            System.out.println("Jog " + jogada1);
            rbComputador.setSelected(true);

            if (jogada1 > 0 && jogada2 > 0) {
                VerificaVencedorMao();
                contadorPart++;
//                tfAndamento.setText(maos.toString());
                resetMesa();
            }

            simularJogadaPC();

        }

    }//GEN-LAST:event_lbJogadorC3MouseClicked

    private void btEmbaralharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmbaralharActionPerformed
        // TODO add your handling code here:

        lbJOGADOR.setIcon(null);
        lbCOMPUT.setIcon(null);
        tfGeralComp.setText("0");
        tfGeralJog.setText("0");
        tfAndamento.setText(null);
        jogada1 = 0;
        jogada2 = 0;
        contadorJog = 0;
        contadorComp = 0;
        DistribuirCartas(true);

    }//GEN-LAST:event_btEmbaralharActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btJogadaPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJogadaPCActionPerformed
        // TODO add your handling code here:

        simularJogadaPC();

    }//GEN-LAST:event_btJogadaPCActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbadonar;
    private javax.swing.JButton btEmbaralhar;
    private javax.swing.JButton btJogadaPC;
    private javax.swing.JButton btSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbBaralho;
    private javax.swing.JLabel lbCOMPUT;
    private javax.swing.JLabel lbCompC1;
    private javax.swing.JLabel lbCompC2;
    private javax.swing.JLabel lbCompC3;
    private javax.swing.JLabel lbJOGADOR;
    private javax.swing.JLabel lbJogadorC1;
    private javax.swing.JLabel lbJogadorC2;
    private javax.swing.JLabel lbJogadorC3;
    private javax.swing.JLabel lbPersonComp;
    private javax.swing.JLabel lbPersonJog;
    private javax.swing.JRadioButton rbComputador;
    private javax.swing.JRadioButton rbJogador;
    private javax.swing.JTextField tfAndamento;
    private javax.swing.JTextField tfGeralComp;
    private javax.swing.JTextField tfGeralJog;
    private javax.swing.JTextField tfNomeJog;
    // End of variables declaration//GEN-END:variables
}
