import javax.swing.JFrame;
import java.io.IOException;
import java.net.Socket;

public class Editor {
    public static void main(String args[]) throws IOException {
        new Janela(new Socket("192.168.15.76", 2134)).setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
