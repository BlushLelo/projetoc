/*
* Usar MySQL - 1 tabela apenas contendo informa��oes do desenho.
* Colunas da tabela:.
* Nome: nome do desenho.
* IP: ip do cliente para identifica��o
* data: data de cria��o do desenho (criada quando o desenho for criado).
* modificado: data de ultima modifica��o do desenho.
* conteudo: conteudo do desenho (text).
*
* - Se o nome ja existir o desenho deve ser sobreescrito no banco, caso n�o exista cria-se um registro.
* - Uso de Threads para aceitar v�rios clientes. (1 threads por cliente)
* -
* */

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket request = new ServerSocket (12345);

            Socket conn = request.accept();
        } catch (Exception erro){
            System.out.println(erro.getMessage());
        }
    }
}
