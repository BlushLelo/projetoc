import javax.swing.JFrame;
import java.io.IOException;
import java.net.Socket;

public class Editor {
    public static void main(String args[]) throws IOException {
        new Janela(new Socket("127.0.0.1", 1234)).setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}

