import javafx.geometry.HorizontalDirection;
import jdk.nashorn.internal.runtime.ListAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TabelaSelecaoDesenhos extends JFrame {
    private List<OperacaoResponse> responses;

    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private int selectedIndex = -1;
    private JButton button = new JButton("Abrir desenho");


    private String[] colunas = {"Nome", "Data de criação", "Data de atualização", "Conteudo","IP"};
    private Object[][] dados = {{}};
    public Integer getSelectedPaint(){
        return selectedIndex;
    }

//    private Object [][] dados = {
//            {"desenho1", "05-04-2020","05-04-2020", "2 figuras","127.0.0.1"},
//            {"desenho2", "05-04-2020","05-04-2020", "3 figuras","45.33.11.3"},
//            {"deesnho3", "02-02-2020","02-02-2020", "1 figura","200.12.3.22"}
//    };
    public TabelaSelecaoDesenhos(List<OperacaoResponse> responses) {
        this.responses = responses;

        Object [][] dados = {
                {"desenho1", "05-04-2020","05-04-2020", "2 figuras","127.0.0.1"},
                {"desenho2", "05-04-2020","05-04-2020", "3 figuras","45.33.11.3"},
                {"deesnho3", "02-02-2020","02-02-2020", "1 figura","200.12.3.22"}
        };

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 550);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIndex = tabela.getSelectedRow();
                System.out.println("Selected: " + selectedIndex);
                dispose();
            }
        });

//        list.setModel(model);
//        for (OperacaoResponse responseAux : response) {
//            model.addElement(responseAux);
//        }
//
//        list.getSelectionModel().addListSelectionListener(x -> {
//            OperacaoResponse response1 = list.getSelectedValue();
//
//            lblNome.setText("Nome: " + response1.getNomeDoDesenho());
////            lblDataCriacao.setText("Data Criação: " + response1.ge);
////            lblDataAtualizacao.setText("Data Última Atualização: " + formatarData(desenho.getDataAtualizacao()));
//            lblIpAtualizacao.setText("Ip Última Atualização: " + response1.getOperacao());
//        });
    }
}
