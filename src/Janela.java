//import org.apache.commons.lang.StringUtils;


import say.swing.JFontChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class Janela extends JFrame {
    protected static final long serialVersionUID = 1L;

    Container cntForm = this.getContentPane();
    protected JButton btnPonto = new JButton("Ponto"),
            btnLinha = new JButton("Linha"),
            btnCirculo = new JButton("Circulo"),
            btnElipse = new JButton("Elipse"),
            btnCores = new JButton("Cores"),
            btnAbrir = new JButton("Abrir"),
            btnAbrirRemoto = new JButton("Abrir remoto"),
            btnSalvar = new JButton("Salvar"),
            btnSalvarRemoto = new JButton("Salvar Remoto"),
            btnApagar = new JButton("Apagar"),
            btnSair = new JButton("Sair"),
            btnRect = new JButton("Retangulo"),
            btnQuad = new JButton("Quadrado"),
            btnText = new JButton("Texto"),
            btnPoligono = new JButton("Poligono");

    protected JCheckBox ckPreenchido = new JCheckBox("isPreechido");

    protected MeuJPanel pnlDesenho = new MeuJPanel();

    protected JLabel statusBar1 = new JLabel("Mensagem:"),
            statusBar2 = new JLabel("Coordenada:");

    protected boolean esperaPonto,
            esperaInicioReta,
            esperaFimReta,
            esperaInicioCirculo,
            esperaFimCirculo,
            esperaInicioRetangulo,
            esperaFimRetangulo,
            esperaInicioQuadrado,
            esperaFimQuadrado,
            esperaInicioElipse,
            esperaFimElipse,
            esperaTexto,
            esperaInicioPoligono;
    protected boolean isPreenchido;

    protected Color corAtual = Color.BLACK;
    protected Ponto p1;
    protected Font fontAtual;
    protected String textoDigitado = "";
    protected boolean isTyping = false;
    protected int txtCordX = 0;
    protected int txtCordY = 0;
    protected ArrayList<Ponto> vetorPontosPoligono = new ArrayList<Ponto>();

    protected boolean isDrawingPoligon = false;

    protected Vector<Figura> figuras = new Vector<Figura>();

    private Socket socket;

    public Janela(Socket socket) throws IOException {
        super("Editor Gráfico");
        if(socket != null)
            this.socket = socket;

        try {
            Image btnPoligonoImg = ImageIO.read(getClass().getResource("resources/poligono.jpg"));
            btnPoligono.setIcon(new ImageIcon(btnPoligonoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo poligono.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            Image btnTextImg = ImageIO.read(getClass().getResource("resources/texto.jpg"));
            btnText.setIcon(new ImageIcon(btnTextImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo texto.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            Image btnQuadImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
            btnQuad.setIcon(new ImageIcon(btnQuadImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo quadrado.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            Image btnRectImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
            btnRect.setIcon(new ImageIcon(btnRectImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo retangulo.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }
        try {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo ponto.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo linha.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo circulo.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo elipse.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo cores.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo abrir.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo salvar.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo apagar.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        try {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Arquivo sair.jpg não foi encontrado",
                    "Arquivo de imagem ausente",
                    JOptionPane.WARNING_MESSAGE);
        }

        btnSair.addActionListener(new SairDoPrograma());
        btnPonto.addActionListener(new DesenhoDePonto());
        btnLinha.addActionListener(new DesenhoDeReta());
        btnCirculo.addActionListener(new DesenhoCirculo());
        btnCores.addActionListener(new PaletaDeCores());
        btnRect.addActionListener(new DesenhoDeRetangulo());
        btnQuad.addActionListener(new DesenhoDeQuadrado());
        btnElipse.addActionListener(new DesenhoElipse());
        btnText.addActionListener(new AdicionaTexto());
        btnSalvar.addActionListener(new SalvarDesenho());
        btnSalvarRemoto.addActionListener(new SalvarDesenhoRemoto());
        btnAbrir.addActionListener(new AbrirDesenho());
        btnAbrirRemoto.addActionListener(new AbrirDesenhoRemoto());
        btnPoligono.addActionListener(new DesenhoDePoligono());


        JPanel pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout();
        pnlBotoes.setLayout(flwBotoes);

        pnlBotoes.add(btnAbrir);
        pnlBotoes.add(btnAbrirRemoto);
        pnlBotoes.add(btnSalvar);
        pnlBotoes.add(btnSalvarRemoto);
        pnlBotoes.add(btnPonto);
        pnlBotoes.add(btnLinha);
        pnlBotoes.add(btnRect);
        pnlBotoes.add(btnQuad);
        pnlBotoes.add(btnCirculo);
        pnlBotoes.add(btnElipse);
        pnlBotoes.add(btnPoligono);
        pnlBotoes.add(btnText);
        pnlBotoes.add(btnCores);
        pnlBotoes.add(btnApagar);
        pnlBotoes.add(btnSair);
        pnlBotoes.add(ckPreenchido);

        JPanel pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1, 2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);


        cntForm.setLayout(new BorderLayout());
        cntForm.add(pnlBotoes, BorderLayout.NORTH);
        cntForm.add(pnlDesenho, BorderLayout.CENTER);
        cntForm.add(pnlStatus, BorderLayout.SOUTH);

        this.addWindowListener(new FechamentoDeJanela());

        this.setSize(1280, 500);
        this.setVisible(true);
    }

    protected class MeuJPanel extends JPanel
            implements MouseListener, KeyListener, FocusListener,
            MouseMotionListener {
        public MeuJPanel() {
            super();

            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.addKeyListener(this);
            this.addFocusListener(this);

            this.setFocusable(true);
            this.requestFocus();
        }

        @Override
        public void focusGained(FocusEvent e) {
            //nothing
        }

        @Override
        public void focusLost(FocusEvent e) {
            //this.requestFocus();
        }

        public void paint(Graphics g) {
            for (int i = 0; i < figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }

        public void mousePressed(MouseEvent e) {
            if (esperaPonto) {
                figuras.add(new Ponto(e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = false;

            } else if (esperaInicioReta) {
                p1 = new Ponto(e.getX(), e.getY(), corAtual);
                esperaFimReta = true;
                esperaInicioReta = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                statusBar1.setText("Mensagem: clique o ponto final da reta");
            } else if (esperaFimReta) {
                esperaInicioReta = true;
                esperaFimReta = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                figuras.add(new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique o ponto inicial da reta");

            } else if (esperaInicioCirculo) {
                statusBar1.setText("Mensagem: clique o ponto inicial do circulo");
                p1 = new Ponto(e.getX(), e.getY(), corAtual);
                esperaFimCirculo = true;
                esperaInicioCirculo = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                statusBar1.setText("Mensagem: clique o centro do circulo");
            } else if (esperaFimCirculo) {
                esperaInicioCirculo = true;
                esperaFimCirculo = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                figuras.add(new Circulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, isPreenchido));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique o ponto inicial do circulo");

            } else if (esperaInicioRetangulo) {
                statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");
                p1 = new Ponto(e.getX(), e.getY(), corAtual);
                esperaFimRetangulo = true;
                esperaInicioRetangulo = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                statusBar1.setText("Mensagem: clique o fim do retangulo");
            } else if (esperaFimRetangulo) {
                esperaInicioRetangulo = true;
                esperaFimRetangulo = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                figuras.add(new Retangulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, isPreenchido));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");

            } else if (esperaInicioQuadrado) {
                statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");
                p1 = new Ponto(e.getX(), e.getY(), corAtual);
                esperaFimQuadrado = true;
                esperaInicioQuadrado = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                statusBar1.setText("Mensagem: clique o fim do quadrado");
            } else if (esperaFimQuadrado) {
                esperaInicioQuadrado = true;
                esperaFimQuadrado = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                figuras.add(new Quadrado(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, isPreenchido));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");


            } else if (esperaInicioElipse) {
                p1 = new Ponto(e.getX(), e.getY(), corAtual);
                esperaInicioElipse = false;
                esperaFimElipse = true;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                statusBar1.setText("Mensagem: clique o ponto final da elipse");
            } else if (esperaFimElipse) {
                esperaInicioElipse = true;
                esperaFimElipse = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaTexto = false;
                isTyping = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                figuras.add(new Elipse(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, isPreenchido));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique o ponto inicial da elipse");

            } else if (esperaTexto) {
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioRetangulo = false;
                esperaFimRetangulo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaTexto = false;
                esperaInicioPoligono = false;
                isDrawingPoligon = false;
                isTyping = true;

                if (isTyping) {
                    txtCordX = e.getX();
                    txtCordY = e.getY();
                    this.requestFocus();
                    statusBar1.setText("Mensagem: Digite o texto desejado");
                }
            } else if (esperaInicioPoligono) {
                statusBar1.setText("Mensagem: clique o ponto inicial do poligono");
                esperaFimRetangulo = false;
                esperaInicioRetangulo = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaInicioCirculo = false;
                esperaFimCirculo = false;
                esperaInicioQuadrado = false;
                esperaFimQuadrado = false;
                esperaInicioElipse = false;
                esperaFimElipse = false;
                esperaTexto = false;
                isTyping = false;
                isDrawingPoligon = true;

                if (isDrawingPoligon) {
                    this.requestFocus();
                    vetorPontosPoligono.add(new Ponto(e.getX(), e.getY()));
                }

                statusBar1.setText("Mensagem: clique nos próximos pontos | Precione ESC para finalizar o poligono.");
            }
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
            statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());
        }

        @Override
        public void keyTyped(KeyEvent x) {
            if (x.getKeyChar() == KeyEvent.VK_ESCAPE && isTyping) {
                isTyping = false;
                statusBar1.setText("Mensagem: ");
                textoDigitado = "";
                txtCordX = 0;
                txtCordY = 0;
            }
            if (isTyping) {
                textoDigitado += x.getKeyChar();
                figuras.add(new Texto(txtCordX, txtCordY, textoDigitado, fontAtual, corAtual));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
            }
            if (x.getKeyChar() == KeyEvent.VK_ESCAPE && isDrawingPoligon) {
                isDrawingPoligon = false;

                ArrayList<Ponto> aux = new ArrayList<Ponto>();
                aux = (ArrayList<Ponto>) vetorPontosPoligono.clone();
                Poligono poligono = new Poligono(aux, corAtual, isPreenchido);
                figuras.add(poligono);
//                System.out.println("aux: " + Arrays.toString(vetorPontosPoligono.toArray()));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                vetorPontosPoligono.clear();//limpa os pontos para o proximo desenho
//                System.out.println("Size: "+figuras.size());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //nothing
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //nothing
        }
    }

    protected class DesenhoDePonto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaPonto = true;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            statusBar1.setText("Mensagem: clique o local do ponto desejado");
        }
    }

    protected class DesenhoDeReta implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaPonto = false;
            esperaInicioReta = true;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }

    protected class SairDoPrograma implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    protected class FechamentoDeJanela extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    protected class DesenhoCirculo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isPreenchido = ckPreenchido.isSelected();
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = true;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            statusBar1.setText("Mensagem: clique o ponto inicial do circulo");
        }
    }

    protected class PaletaDeCores implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color tempColor = Color.BLACK;
            statusBar1.setText("Mensagem: selecione a cor a ser usada");
            JColorChooser cores = new JColorChooser();
            corAtual = JColorChooser.showDialog(cores, "Escolha uma cor", tempColor);
            cores.getSelectionModel().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    corAtual = cores.getColor();
                }
            });
        }
    }

    protected class DesenhoDeRetangulo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isPreenchido = ckPreenchido.isSelected();
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = true;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");
        }
    }

    protected class DesenhoDeQuadrado implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isPreenchido = ckPreenchido.isSelected();
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = true;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");
        }
    }

    protected class DesenhoElipse implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isPreenchido = ckPreenchido.isSelected();
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = true;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da elipse");
        }
    }

    protected class AdicionaTexto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;

            esperaTexto = true;
            statusBar1.setText("Mensagem: escolha a font a ser usado no texto.");

            //aqui tem a font
            JFontChooser fontChooser = new JFontChooser();
            if (fontChooser.showDialog(null) == JFontChooser.OK_OPTION) {
                fontAtual = fontChooser.getSelectedFont();
            }

            //limpa textoDigitado
            textoDigitado = "";
            statusBar1.setText("Mensagem: Clique onde será adicionado o texto.");
        }
    }

    protected class SalvarDesenho implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            String dir = System.getProperty("user.home");
            JFileChooser fChoose = new JFileChooser(dir + "/Downloads/"); //open at 'Downloads' folder
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Paint files (*.paint)", "paint", "text");
            fChoose.setFileFilter(filter);
            File file = null;

            if (fChoose.showSaveDialog(Janela.this) == JFileChooser.APPROVE_OPTION) {
                String fileName = fChoose.getSelectedFile().toString();
                String substring = fileName.substring(fileName.length() - 6, fileName.length());
                if( !substring.equals(".paint"))
                    fChoose.setSelectedFile(new File(fChoose.getSelectedFile() + ".paint"));

                file = fChoose.getSelectedFile();
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null,
                            "Ao confirmar o arquivo será sobrescrito.",
                            "Arquivo já existente.",
                            3);
                }
            }
            try {
//                Operacao operacao = new Operacao();
//                operacao.setOperation("SAV");
                ArrayList<Figura> listaDeFiguras = new ArrayList<>();
                PrintWriter writer = new PrintWriter(new FileWriter(file));
                for (Figura aux : figuras) {
                    listaDeFiguras.add(aux);
                    writer.println(aux.toString());
                }
//                operacao.setFiguraList(listaDeFiguras);
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                objectOutputStream.writeObject(operacao);
//                writer.print(savedContent);
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            statusBar1.setText("Mensagem: Desenho salvo.");
        }
    }

    protected class SalvarDesenhoRemoto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                //salvar desenho no banco.
            String nomeDoDesenho = JOptionPane.showInputDialog("Nome do desenho a ser salvo.");

            String substring = nomeDoDesenho.substring(nomeDoDesenho.length() - 6, nomeDoDesenho.length());
            if( !substring.equals(".paint"))
                nomeDoDesenho = nomeDoDesenho + ".paint";
            File file = null;

            try {
                Operacao operacao = new Operacao();
                operacao.setOperation("SAV");
                ArrayList<Figura> listaDeFiguras = new ArrayList<>();
//                PrintWriter writer = new PrintWriter(new FileWriter(file));
                for (Figura aux : figuras) {
                    listaDeFiguras.add(aux);
//                    writer.println(aux.toString());
                }
                operacao.setFiguraList(listaDeFiguras);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(operacao);
//                writer.print(savedContent);
//                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        }

    protected class AbrirDesenho implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;

            String dir = System.getProperty("user.home");
            JFileChooser fChoose = new JFileChooser(dir + "/Downloads/"); //open at 'Downloads' folder
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Paint files (*.paint)", "paint", "text");
            fChoose.setFileFilter(filter);
            File file = null;
            Operacao operacao = new Operacao();
            operacao.setOperation("CON");


            if (fChoose.showOpenDialog(Janela.this) == JFileChooser.APPROVE_OPTION) {
                file = fChoose.getSelectedFile();
                //clean paint, frame, figuras.
                figuras.clear();
                pnlDesenho.repaint();
                repaint();
            }
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(operacao);
                BufferedReader in = new BufferedReader(new FileReader(file));
                String line = in.readLine();

                while (line != null) {
                    switch (line.charAt(0)) {
                        case 'c':
                            figuras.add(new Circulo(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 'e':
                            figuras.add(new Elipse(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 'l':
                            figuras.add(new Linha(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 'q':
                            figuras.add(new Quadrado(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 'r':
                            figuras.add(new Retangulo(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 't':
                            figuras.add(new Texto(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 'g':
                            figuras.add(new Poligono(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        case 'p':
                            figuras.add(new Ponto(line));
                            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                            break;
                        default:
                            break;
                    }
                    line = in.readLine(); //next line
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            statusBar1.setText("Mensagem: ");
        }
    }

    protected class AbrirDesenhoRemoto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //abrir desenho no bando.

            try {
                Operacao operacao = new Operacao();
                operacao.setOperation("CON");

                //send IP address
                operacao.setIp(socket.getInetAddress().getAddress().toString());

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(operacao);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        }

    protected class DesenhoDePoligono implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isPreenchido = ckPreenchido.isSelected();
            esperaPonto = false;
            esperaInicioReta = false;
            esperaFimReta = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaTexto = false;
            isTyping = false;
            esperaInicioPoligono = true;
            isDrawingPoligon = true;

            statusBar1.setText("Mensagem: Clique no ponto inicial do polígono.");
        }
    }
}
