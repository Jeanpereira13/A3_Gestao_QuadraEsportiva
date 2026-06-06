
/*package Main;

import modeloentidade.Agendamento;
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

//mayckow*/

package MenuInteração;

import ControleAgendamento.ServicodeAgendamento;
import modeloEntidade.Agendamento;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INSTANCIANDO O SEU SERVIÇO (O "BANCO DE DADOS")
        ServicodeAgendamento servico = new ServicodeAgendamento();
        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("  |   ===  | MENU |  ===   | ");
            System.out.println("==============================");
            System.out.println("ESCOLHA NAS OPÇÕES ABAIXO:");
            System.out.println("[1] - CADASTRAR NOVO AGENDAMENTO");
            System.out.println("[2] - LISTAR TODOS OS AGENDAMENTOS");
            System.out.println("[3] - EDITAR AGENDAMENTO");
            System.out.println("[4] - CANCELAR/EXCLUIR AGENDAMENTO");
            System.out.println("[0] - SAIR DO SISTEMA");
            System.out.println("-------------------------------");
            System.out.print("QUAL SUA ESCOLHA AGORA: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do teclado pós-número

            switch (opcao) {
                case 1:
                    System.out.println("\n--- TELA DE CADASTRO ---");
                    Agendamento novo = new Agendamento();

                    System.out.print("Digite o ID único do agendamento: ");
                    novo.setId(sc.nextInt());
                    sc.nextLine(); // Limpa buffer

                    System.out.print("Digite seu nome: ");
                    novo.setNomeCliente(sc.nextLine());

                    System.out.print("Informe o horário (Ex: 14:00): ");
                    novo.setHorario(sc.nextLine());

                    System.out.print("Qual o dia (Ex: 15/06): ");
                    novo.setDia(sc.nextLine());

                    System.out.print("Qual o esporte: ");
                    novo.setTipoEsporte(sc.nextLine());

                    // ENVIA PARA A SUA CLASSE E "TRADUZ" O RETORNO BOOLEAN
                    boolean cadastrou = servico.cadastrar(novo);
                    if (cadastrou) {
                        System.out.println("✅ SUCESSO: Agendamento realizado!");
                    } else {
                        System.out.println("❌ ERRO: Cadastro negado! ID já existente ou conflito de horário.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- RELATÓRIO DE AGENDAMENTOS ---");
                    // SE A SUA LISTA RETORNAR VAZIA
                    if (servico.listarTodos().isEmpty()) {
                        System.out.println("Nenhum agendamento cadastrado até o momento.");
                    } else {
                        // FAZ O LAÇO PARA EXIBIR CADA UM
                        for (Agendamento a : servico.listarTodos()) {
                            System.out.println("---------------------------------");
                            a.mostrarDados(); // Usa o método que a Isabela criou
                        }
                        System.out.println("---------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("\n--- TELA DE EDIÇÃO ---");
                    System.out.print("Digite o ID do agendamento que deseja editar: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine(); // Limpa buffer

                    System.out.print("Digite o NOVO dia (Ex: 16/06): ");
                    String novoDia = sc.nextLine();

                    System.out.print("Digite o NOVO horário (Ex: 15:00): ");
                    String novoHorario = sc.nextLine();

                    System.out.print("Digite o NOVO esporte: ");
                    String novoEsporte = sc.nextLine();

                    // ENVIA PARA O SEU MÉTODO EDITAR E TRADUZ A RESPOSTA
                    boolean editou = servico.editar(idEditar, novoDia, novoHorario, novoEsporte);
                    if (editou) {
                        System.out.println("🔄 SUCESSO: Dados alterados com sucesso!");
                    } else {
                        System.out.println("❌ ERRO: Edição negada! ID não existe ou o novo horário já está ocupado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- TELA DE EXCLUSÃO ---");
                    System.out.print("Digite o ID do agendamento a ser cancelado: ");
                    int idExcluir = sc.nextInt();

                    // ENVIA PARA O SEU MÉTODO CANCELAR E TRADUZ A RESPOSTA
                    boolean excluiu = servico.cancelar(idExcluir);
                    if (excluiu) {
                        System.out.println("🗑️ SUCESSO: Agendamento cancelado e removido!");
                    } else {
                        System.out.println("❌ ERRO: Código de ID não encontrado no sistema.");
                    }
                    break;

                case 0:
                    System.out.println("--- SISTEMA ENCERRADO ---");
                    break;

                default:
                    System.out.println("---- OPÇÃO INVÁLIDA ----");
            }

        } while (opcao != 0);
    }
}







/*package MenuInteração; //MAYCKOW - 29/05/2026

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
}*\

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