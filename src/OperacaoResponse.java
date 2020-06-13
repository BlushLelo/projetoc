import java.io.Serializable;
import java.util.List;

public class OperacaoResponse implements Serializable {

    private static final long serialVersionUID = -8167573074331114690L;

    String nomeDoDesenho;

    List<Figura> listaDeFiguras;

    public OperacaoResponse() {
    }

    public OperacaoResponse(String nomeDoDesenho, List<Figura> listaDeFiguras) {
        this.nomeDoDesenho = nomeDoDesenho;
        this.listaDeFiguras = listaDeFiguras;
    }

    public String getNomeDoDesenho() {
        return nomeDoDesenho;
    }

    public void setNomeDoDesenho(String nomeDoDesenho) {
        this.nomeDoDesenho = nomeDoDesenho;
    }

    public List<Figura> getListaDeFiguras() {
        return listaDeFiguras;
    }

    public void setListaDeFiguras(List<Figura> listaDeFiguras) {
        this.listaDeFiguras = listaDeFiguras;
    }
}