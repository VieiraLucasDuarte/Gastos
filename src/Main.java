import Objects.Ganhos;
import Objects.Gastos;
import Service.Servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean roda = true;
        Servicos servicos = new Servicos();
        List<Gastos> gastosTotais = new ArrayList<>();
        List<Ganhos> ganhosTotais = new ArrayList<>();
        while (roda) {
            int opcao;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a opção que você quer:\n" +
                    "1 - Adicionar Gasto\n" +
                    "2 - Adicionar Ganho\n" +
                    "3 - Relatório de Gastos\n" +
                    "4 - Relatório de Ganhos\n" +
                    "5 - Relatório Mensal\n" +
                    "6 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    boolean op1 = true;
                    while (op1) {
                        Scanner scanop1 = new Scanner(System.in);
                        Gastos gastos = servicos.AdicionarGastos();
                        gastosTotais.add(gastos);
                        System.out.println("Inserir mais gastos? S/N");
                        String op = scanop1.nextLine();
                        if (!op.equalsIgnoreCase("S"))
                            op1 = false;
                    }
                    break;
                case 2:
                    boolean op2 = true;
                    while (op2) {
                        Scanner scanop2 = new Scanner(System.in);
                        Ganhos ganhos = servicos.AdicionaGanhos();
                        ganhosTotais.add(ganhos);
                        System.out.println("Inserir mais ganhos? S/N");
                        String op = scanop2.nextLine();
                        if (!op.equalsIgnoreCase("S"))
                            op2 = false;
                    }
                    break;
                case 3:
                    servicos.RelatorioGastos(gastosTotais);
                    break;
                case 4:
                    servicos.RelatoriosGanhos(ganhosTotais);
                    break;
                case 5:
                    servicos.RelatorioMensal(ganhosTotais, gastosTotais);
                    break;
                case 6:
                    roda = false;
            }
        }
    }
}