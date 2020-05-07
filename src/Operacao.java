import java.io.Serializable;
import java.util.List;

public class Operacao implements Serializable {
    private static final long serialVersionUID = -1309972794650681881L;
    private String operation;
    private List<Figura> figuraList;

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
