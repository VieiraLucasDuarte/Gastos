package Objects;

import java.time.LocalDate;
import java.util.Date;

public class Ganhos {
    private String Ganho;
    private String Tipo;
    private LocalDate Data;
    private double Valor;

    public Ganhos(String ganho, String tipo, LocalDate data, double valor) {
        Ganho = ganho;
        Tipo = tipo;
        Data = data;
        Valor = valor;
    }

    public String getGanho() {
        return Ganho;
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
}
