import java.awt.*;
import java.io.Serializable;
import java.util.StringTokenizer;

public class Texto extends Figura implements Serializable {

    private static final long serialVersionUID = 6548308103191019816L;
    protected int x, y;
    protected String textoDigitado;
    protected Font fontStyle;

    public Texto(int x, int y, String texto, Font fontStyle) {
        this(x, y, texto, fontStyle, Color.BLACK);
    }

    public Texto(int x, int y, String texto, Font fontStyle, Color cor) {
        super(cor);

        this.x = x;
        this.y = y;
        this.textoDigitado = texto;
        this.cor = cor;
        this.fontStyle = fontStyle;
    }

    public Texto(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        this.x = Integer.parseInt(quebrador.nextToken());
        this.y = Integer.parseInt(quebrador.nextToken());

        this.cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        String fontName = quebrador.nextToken();
        int fotnStyleOpt = Integer.parseInt(quebrador.nextToken());
        int fontSize = Integer.parseInt(quebrador.nextToken());
        this.fontStyle = new Font(fontName, fotnStyleOpt, fontSize);

        this.textoDigitado = quebrador.nextToken();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void torneSeVisivel(Graphics g) {
        g.setFont(this.fontStyle);
        g.setColor(this.cor);
        g.drawString(this.textoDigitado, this.x, this.y);
    }

    public String toString() {
        return "t:" +
                this.x +
                ":" +
                this.y +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue() +
                ":" +
                this.fontStyle.getFontName() + //font family name String
                ":" +
                this.fontStyle.getStyle() + //0-plain 1-bold 2-italic 3-boldItalic
                ":" +
                this.fontStyle.getSize() + //font size int
                ":" +
                this.textoDigitado;
    }
}