import say.swing.JFontChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Janela extends JFrame {
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto = new JButton("Ponto"),
            btnLinha = new JButton("Linha"),
            btnCirculo = new JButton("Circulo"),
            btnElipse = new JButton("Elipse"),
            btnCores = new JButton("Cores"),
            btnAbrir = new JButton("Abrir"),
            btnSalvar = new JButton("Salvar"),
            btnApagar = new JButton("Apagar"),
            btnSair = new JButton("Sair"),
            btnRect = new JButton("Retangulo"),
            btnQuad = new JButton("Quadrado"),
            btnText = new JButton("Texto");

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
            esperaTexto;
    protected boolean isPreenchido;

    protected Color corAtual = Color.BLACK;
    protected Ponto p1;
    protected Font fontAtual;
    protected String textoDigitado;

    protected Vector<Figura> figuras = new Vector<Figura>();

    public Janela() {
        super("Editor Gr�fico");

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


        JPanel pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout();
        pnlBotoes.setLayout(flwBotoes);

        pnlBotoes.add(btnAbrir);
        pnlBotoes.add(btnSalvar);
        pnlBotoes.add(btnPonto);
        pnlBotoes.add(btnLinha);
        pnlBotoes.add(btnRect);
        pnlBotoes.add(btnQuad);
        pnlBotoes.add(btnCirculo);
        pnlBotoes.add(btnElipse);
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

        Container cntForm = this.getContentPane();
        cntForm.setLayout(new BorderLayout());
        cntForm.add(pnlBotoes, BorderLayout.NORTH);
        cntForm.add(pnlDesenho, BorderLayout.CENTER);
        cntForm.add(pnlStatus, BorderLayout.SOUTH);

        this.addWindowListener(new FechamentoDeJanela());

        this.setSize(1280, 500);
        this.setVisible(true);
    }

    protected class MeuJPanel extends JPanel
            implements MouseListener,
            MouseMotionListener {
        public MeuJPanel() {
            super();

            this.addMouseListener(this);
            this.addMouseMotionListener(this);
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
                figuras.add(new Elipse(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, isPreenchido));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem: clique o ponto inicial da elipse");
                
            } else if (esperaTexto) {
//                JOptionPane textPanel = new JOptionPane();
//                textoDigitado = textPanel.showInputDialog(this, "Digite um texto.");
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
                
                figuras.add(new Texto(e.getX(), e.getY(), "meu texto de test", fontAtual,corAtual));
                statusBar1.setText("Mensagem:");
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
            statusBar1.setText("Mensagem: clique onde será adicionado o texto e escolha a font");

            JFontChooser fontChooser = new JFontChooser();
            if(fontChooser.showDialog(null) == JFontChooser.OK_OPTION){
                fontAtual = fontChooser.getSelectedFont();
            }
            statusBar1.setText("Mensagem: Digite o texto a ser inserido.");
        }
    }

}
