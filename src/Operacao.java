import java.io.Serializable;
import java.util.List;

public class Operacao implements Serializable {
    private static final long serialVersionUID = -2829362307114855733L;
    private String operation;
    private List<Figura> figuraList;

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
