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
