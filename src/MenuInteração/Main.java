package MenuInteração;

import ControleAgendamento.ServicodeAgendamento;
import modeloEntidade.Agendamento;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Puxar Matheus e Isabela para o meu MENU funcionar May.

        String nomeCliente;
        String dia;
        String horario;
        String esporte;
        int id;

        ServicodeAgendamento p1 = new ServicodeAgendamento();
        Agendamento p2 = new Agendamento();
        int opcao;


        do {
            System.out.println();
            System.out.println("==============================");
            System.out.println("  |   ===  | MENU |  ===   | ");
            System.out.println("==============================");
            System.out.println("Marque ou reserve seus horários por aqui,");
            System.out.println("e também, faça a escolha da quadra.");
            System.out.println();
            System.out.println("==============================");
            System.out.println("ESCOLHA NAS OPÇÕES ABAIXO:");
            System.out.println("[1] - ");
            System.out.println("[2] - ");
            System.out.println("[3] - ");
            System.out.println("[4] - ");
            System.out.println("-------------------------------");

            System.out.println("Digite aqui: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;
                default:
                    System.out.println("---- OPÇÃO INVÁLIDA ----");
            }

        } while (opcao !=0);
        System.out.println("PROGRAMA ENCERRADO.");
    }
}

//mayckow