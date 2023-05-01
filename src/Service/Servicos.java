package Service;

import Objects.Ganhos;
import Objects.Gastos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        for (Gastos gasto : gastos) {
            System.out.println("Gastos: " + gasto.getGasto());
            System.out.println("Tipo do gasto: " + gasto.getTipo());
            String date = formatador.format(gasto.getData());
            System.out.println(String.format("Data do gasto: " + date));
            System.out.println("Valor do gasto: " + gasto.getValor());
            System.out.println("Forma de pagamnto: " + gasto.getFrmPgtm());

        }
    }

    public void RelatoriosGanhos(List<Ganhos> ganhos) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        for (Ganhos ganho : ganhos) {
            System.out.println("Gastos: " + ganho.getGanho());
            System.out.println("Tipo de ganho: " + ganho.getTipo());
            String date = formatador.format(ganho.getData());
            System.out.println(String.format("Data do ganho: " + date));
            System.out.println("Valor do ganho: " + ganho.getValor());
        }
    }

    public void RelatorioMensal(List<Ganhos> ganhos, List<Gastos> gastos) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o mês: ");
        int mes = scan.nextInt();
        System.out.println("Digite o ano: ");
        int ano = scan.nextInt();

        LocalDate data = LocalDate.of(ano, mes, 1);
        LocalDate dataBefore = LocalDate.of(ano, mes, 30);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        /*List<Ganhos> ganhoAcima =  ganhos.stream().filter(x -> x.getData().isAfter(data) && x.getData().isBefore(dataBefore))
                .collect(Collectors.toList());
        List<Ganhos> ganhoFinal = ganhoAcima.stream().filter(x -> x.getData().isBefore(dataBefore) || x.getData().isEqual(dataBefore))
                .collect(Collectors.toList());
        double ganhoValor = ganhoFinal.stream().mapToDouble(Ganhos::getValor).sum();

        List<Gastos> gastosAcima =  gastos.stream().filter(x -> x.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(data))
                .collect(Collectors.toList());
        List<Gastos> gastosFinal = gastosAcima.stream().filter(x -> x.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(dataBefore))
                .collect(Collectors.toList());*/

        List<Ganhos> gnsFim = new ArrayList<>();

        for (Ganhos ganho: ganhos)
        {

            if(ganho.getData().isBefore(dataBefore))
            {
                if(ganho.getData().isAfter(data))
                    gnsFim.add(ganho);
            }
        }

        List<Gastos> gtsFim = new ArrayList<>();

        for (Gastos gasto: gastos)
        {

            if(gasto.getData().isAfter(dataBefore))
            {
                if(gasto.getData().isAfter(data))
                    gtsFim.add(gasto);
            }
        }

        double gastosValor = gnsFim.stream().mapToDouble(Ganhos::getValor).sum();

        double ganhsoValor = gtsFim.stream().mapToDouble(Gastos::getValor).sum();

        double result = ganhsoValor - gastosValor;

        if(result > 0)
            System.out.println("O SEU LUCRO FOI DE " + result);
        else if(result < 0)
            System.out.println("Sua divida foi de " + result);
        else
            System.out.println("Voces não lucrou");

    }

}
