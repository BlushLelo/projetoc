import java.util.List;


public class OperacaoResponse {

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
