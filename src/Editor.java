import javax.swing.JFrame;
import java.io.IOException;
import java.net.Socket;
//187.74.67.11 | 2134
public class Editor {
    public static void main(String args[]) throws IOException {
        new Janela(new Socket("187.74.67.11", 2134)).setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
