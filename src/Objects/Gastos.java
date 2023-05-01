package Objects;

import java.time.LocalDate;
import java.util.Date;

public class Gastos {
    private String Gasto;
    private String Tipo;
    private LocalDate Data;
    private double Valor;
    private String FrmPgtm;

    public Gastos(String gasto, String tipo, LocalDate data, double valor, String frmPgtm) {
        Gasto = gasto;
        Tipo = tipo;
        Data = data;
        Valor = valor;
        FrmPgtm = frmPgtm;
    }

    public String getGasto() {
        return Gasto;
    }

    public String getTipo() {
        return Tipo;
    }

    public LocalDate getData() {
        return Data;
    }

    public double getValor() {
        return Valor;
    }

    public String getFrmPgtm() {
        return FrmPgtm;
    }

    public void setGasto(String gasto) {
        Gasto = gasto;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public void setFrmPgtm(String frmPgtm) {
        FrmPgtm = frmPgtm;
    }
}
