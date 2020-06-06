import java.io.Serializable;
import java.util.List;

public class Operacao implements Serializable {
    private static final long serialVersionUID = -2829362307114855733L;
    private String nome;

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    private String dataHora;

    private String operation;
    private List<Figura> figuraList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private String ip;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<Figura> getFiguraList() {
        return figuraList;
    }

    public void setFiguraList(List<Figura> figuraList) {
        this.figuraList = figuraList;
    }
}
