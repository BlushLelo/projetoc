import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Poligono extends Figura implements Serializable {

    private static final long serialVersionUID = 4973656244032944210L;
    protected ArrayList<Ponto> pontosDoPol;
    protected boolean preenchido;

    public Poligono(ArrayList<Ponto> pontos, boolean preenchido) {
        this(pontos, Color.BLACK, preenchido);
    }

    public Poligono(ArrayList<Ponto> pontos, Color cor, boolean preenchido) {
        super(cor);
        this.pontosDoPol = pontos;
        this.preenchido = preenchido;
    }

    public Poligono(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");
        quebrador.nextToken();

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        boolean isPreenchido = Boolean.parseBoolean(quebrador.nextToken());
        this.cor = cor;
        this.preenchido = isPreenchido;

        pontosDoPol = new ArrayList<Ponto>();

        while (quebrador.hasMoreElements()) {
            pontosDoPol.add(new Ponto(Integer.parseInt(quebrador.nextToken()), Integer.parseInt(quebrador.nextToken())));
        }
    }

    public void torneSeVisivel(Graphics g) {
        int i = 0;
        int pontosX[] = new int[pontosDoPol.size()];//vetor de pontos x
        int pontosY[] = new int[pontosDoPol.size()];//vetor de pontos y
        for (Ponto intr : pontosDoPol) {
            pontosX[i] = intr.getX();
            pontosY[i] = intr.getY();
            i++;
        }
        if (!preenchido) {
            g.setColor(cor);
            g.drawPolygon(pontosX, pontosY, pontosDoPol.size());
        } else {
            g.setColor(cor);
            g.fillPolygon(pontosX, pontosY, pontosDoPol.size());
        }
    }

    public String toString() {
        String auxiliar = "";
        for (Ponto ponto : this.pontosDoPol)
            auxiliar += ponto.getX() + ":" + ponto.getY() + ":";
        return "g:" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue() +
                ":" +
                this.preenchido +
                ":" +
                auxiliar;
    }
}