package Service;

import Objects.Ganhos;
import Objects.Gastos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collectors;

public class Servicos {
    public Gastos AdicionarGastos() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        System.out.println("Qual foi o gasto?");
        String GastoID = scan.nextLine();

        System.out.println("Qual foi o tipo de gasto?");
        String tipo = scan.nextLine();

        System.out.println("Qual foi o Valor?");
        Double valor = scan.nextDouble();

        System.out.println("Qual foi a forma de pagamento?");
        String formapgmt = scan2.nextLine();

        Gastos diario = new Gastos(GastoID, tipo, LocalDate.now(), valor, formapgmt);

        return diario;
    }

    public Ganhos AdicionaGanhos() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        System.out.println("Qual foi o ganho?");
        String ganho = scan.nextLine();

        System.out.println("Qual foi o tipo de ganho?");
        String tipo = scan.nextLine();

        System.out.println("Qual foi valor do ganho?");
        double valor = scan.nextDouble();

        Ganhos ganhos = new Ganhos(ganho, tipo, LocalDate.now(), valor);

        return ganhos;
    }

    public void RelatorioGastos(List<Gastos> gastos) {
        for (Gastos gasto : gastos) {
            System.out.println("Gastos: " + gasto.getGasto());
            System.out.println("Tipo do gasto: " + gasto.getTipo());
            System.out.println("Data do gasto: " + gasto.getData().toString());
            System.out.println("Valor do gasto: " + gasto.getValor());
            System.out.println("Forma de pagamnto: " + gasto.getFrmPgtm());
        }
    }

    public void RelatoriosGanhos(List<Ganhos> ganhos) {
        for (Ganhos ganho : ganhos) {
            System.out.println("Gastos: " + ganho.getGanho());
            System.out.println("Tipo de ganho: " + ganho.getTipo());
            System.out.println(String.format("Data do ganho: " + ganho.getData().toString()));
            System.out.println("Valor do ganho: " + ganho.getValor());
        }
    }

    public void RelatorioMensal(List<Ganhos> ganhos, List<Gastos> gastos) {

        Scanner scan = new Scanner(System.in);
        Scanner scanYear = new Scanner(System.in);
        System.out.println("Digite o mês: ");
        int mes = scan.nextInt();
        System.out.println("Digite o ano: ");
        int ano = scanYear.nextInt();

        LocalDate data = LocalDate.of(ano, mes, 1);
        LocalDate dataBefore = LocalDate.of(ano, mes, 30);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Date data1 = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Ganhos> ganhoAcima = ganhos.stream().filter(x -> x.getData().getMonthValue() == mes && x.getData().getYear() == ano)
                .collect(Collectors.toList());

        double ganhoValor = ganhoAcima.stream().mapToDouble(Ganhos::getValor).sum();

        List<Gastos> gastosAcima = gastos.stream().filter(x -> x.getData().getMonthValue() == mes && x.getData().getYear() == ano)
                .collect(Collectors.toList());

        double gastosValor = gastosAcima.stream().mapToDouble(Gastos::getValor).sum();

        double result = ganhoValor - gastosValor;

        YearMonth date = YearMonth.of(ano, mes);
        System.out.println("Relatorio data: " + date);
        System.out.println("Ganho total foi: " + ganhoValor);
        System.out.println("Gasto total foi: " + gastosValor);
        System.out.println("O seu saldo foi de " + result);
    }
}
