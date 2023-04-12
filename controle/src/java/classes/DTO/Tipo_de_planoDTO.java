package classes.DTO;

public class Tipo_de_planoDTO {
    
     private String semanal;
    private String quinzenal;
    private String mensal;
    private int valor;

    public String getSemanal() {
        return semanal;
    }

    public void setSemanal(String semanal) {
        this.semanal = semanal;
    }

    public String getQuinzenal() {
        return quinzenal;
    }

    public void setQuinzenal(String quinzenal) {
        this.quinzenal = quinzenal;
    }

    public String getMensal() {
        return mensal;
    }

    public void setMensal(String mensal) {
        this.mensal = mensal;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
