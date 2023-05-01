import Objects.Ganhos;
import Objects.Gastos;
import Service.Servicos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var roda = true;
        Servicos servicos = new Servicos();
        List<Gastos> gastosTotais = new ArrayList<>();
        List<Ganhos> ganhosTotais = new ArrayList<>();
        while (roda) {
            int opcao;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a opção que você quer: ");
            opcao = scanner.nextInt();
            if (opcao == 1) {
                Scanner scanOP = new Scanner(System.in);
                Gastos gastos = servicos.AdicionarGastos();
                gastosTotais.add(gastos);
            }
            if (opcao == 2) {
                Scanner scanOP = new Scanner(System.in);
                Ganhos ganhos = servicos.AdicionaGanhos();
                ganhosTotais.add(ganhos);
            }
            if (opcao == 3) {
                Scanner scanOP = new Scanner(System.in);
                servicos.RelatorioGastos(gastosTotais);
            }
            if(opcao == 4) {
                Scanner scanOP = new Scanner(System.in);
                servicos.RelatoriosGanhos(ganhosTotais);
            }
            if(opcao == 5) {
                Scanner scanOP = new Scanner(System.in);
                servicos.RelatorioMensal(ganhosTotais, gastosTotais);
            }
        }

    }
}