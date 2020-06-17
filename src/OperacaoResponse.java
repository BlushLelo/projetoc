import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class OperacaoResponse implements Serializable {

    private static final long serialVersionUID = -8167573074331114690L;

    private String nomeDoDesenho;

    private String operacao;

    private Date createdDated;

    private Date updatedDate;

    private List<Figura> listaDeFiguras;

    public OperacaoResponse() {
    }

    public OperacaoResponse(String nomeDoDesenho, Date createdDated, Date updatedDate, List<Figura> listaDeFiguras) {
        this.nomeDoDesenho = nomeDoDesenho;
        this.createdDated = createdDated;
        this.updatedDate = updatedDate;
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

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Date getCreatedDated() {
        return createdDated;
    }

    public void setCreatedDated(Date createdDated) {
        this.createdDated = createdDated;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
