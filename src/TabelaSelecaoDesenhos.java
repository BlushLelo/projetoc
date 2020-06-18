import javafx.geometry.HorizontalDirection;
import jdk.nashorn.internal.runtime.ListAdapter;
import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TabelaSelecaoDesenhos extends JDialog {

    private List<OperacaoResponse> responses;

    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private int selectedIndex = -1;
    private JButton button = new JButton("Abrir desenho");


    private String[] colunas = {"Nome", "Data de criação", "Data de atualização", "Conteudo","IP"};
    private String[][] dados;
    public Integer getSelectedPaint(){
        return selectedIndex;
    }

    public TabelaSelecaoDesenhos(List<OperacaoResponse> responses) {
        this.responses = responses;

        int row = 0;
        dados = new String[responses.size()][5];

        StringBuilder conteudo = new StringBuilder();

        for(OperacaoResponse response : responses){

            conteudo.delete(0,conteudo.length());
            response.getListaDeFiguras().stream().forEach(figura -> {
                if (figura instanceof Quadrado) {
                    conteudo.append("Quadrado, ");
                }
                if(figura instanceof Linha){
                    conteudo.append("Linha, ");
                }
                if(figura instanceof Circulo){
                    conteudo.append("Circulo, ");
                }
                if(figura instanceof Elipse){
                    conteudo.append("Elipse, ");
                }
                if(figura instanceof Poligono){
                    conteudo.append("Poligno, ");
                }
                if(figura instanceof Retangulo){
                    conteudo.append("Retangulo, ");
                }
                if(figura instanceof Texto){
                    conteudo.append("Texto, ");
                }
            });

            dados[row][0] = response.getNomeDoDesenho();
            dados[row][1] = response.getCreatedDated().toString();
            dados[row][2] = response.getUpdatedDate().toString();
            dados[row][3] = conteudo.toString();
            dados[row][4] = response.getIp();
            row++;
        }

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(0,1));
        tabela = new JTable(dados, colunas);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getSelectedRow();
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);
        painelFundo.add(button);
        button.setSize(300, 50);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setLocationRelativeTo(null);

        button.addActionListener(e -> {
            selectedIndex = tabela.getSelectedRow();
            dispose();
        });
        setModal(true);
        setVisible(true);
    }
}
