import javax.swing.JFrame;
import java.io.IOException;
import java.net.Socket;
//187.74.67.11 | 2134

//189.46.60.184
public class Editor {
    private static boolean runLocal = false;

    public static void main(String args[]) throws IOException {
        if (runLocal)
            new Janela(null).setExtendedState(JFrame.MAXIMIZED_BOTH);
        else
            new Janela(new Socket("200.100.214.118", 2134)).setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
