package MenuInteração; //MAYCKOW - 29/05/2026

import modeloEntidade.Agendamento;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Puxar Matheus e Isabela para o meu MENU funcionar May.


        Agendamento p1 = new Agendamento();
        int opcao;



        System.out.println();
        System.out.println("==============================");
        System.out.println("  |   ===  | MENU |  ===   | ");
        System.out.println("==============================");
        System.out.println("Marque ou reserve seus horários por aqui,");
        System.out.println("e também, faça a escolha da quadra.");
        System.out.println();
        System.out.println("==============================");
        System.out.println("ESCOLHA NAS OPÇÕES ABAIXO:");
        System.out.println("[1] - NOME - HORÁRIO - DIA");
        System.out.println("[2] - ESPORTE - ID");
        System.out.println("[3] - CONFIRA SUAS ESCOLHAS");
        System.out.println("[4] - APAGAR E ENCERRAR");
        System.out.println("[0] - SALVAR E SAIR");
        System.out.println("-------------------------------");
        do {
            System.out.println();
            System.out.println("QUAL SUA ESCOLHA AGORA: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite seu nome:");
                    String nomeCliente = sc.next();

                    p1.setNomeCliente(nomeCliente);

                    System.out.println("Informe o horário:");
                    String horario = sc.next();

                    p1.setHorario(horario);

                    /////////////////////////////////////////

                    System.out.println("Qual dia:");
                    String dia = sc.next();

                    p1.setDia(dia);
                    break;

                case 2:
                    System.out.println("Qual esporte:");
                    String esporte = sc.next();

                    p1.setTipoEsporte(esporte);

                    System.out.println("Informe o id:");
                    int id = sc.nextInt();

                    p1.setId(id);
                    break;

                case 3:
                    System.out.println("________________________");
                    System.out.println("---- SUAS ESCOLHAS ----");
                    p1.mostrarDados();
                    System.out.println("________________________");
                    break;

                case 4:
                    p1 = new Agendamento();
                    System.out.println("- DADOS APAGADOS -");
                    break;

                case 0:
                    System.out.println("--- SALVAR E SAIR ---");
                    break;
                default:
                    System.out.println("---- OPIÇÃO INVÁLIDA ----");

            }

        } while (opcao !=0);
        System.out.println("PROGRAMA SALVO E ENCERRADO.");
    }
}

//mayckow













/*package MenuInteração;

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
}*/

//mayckow