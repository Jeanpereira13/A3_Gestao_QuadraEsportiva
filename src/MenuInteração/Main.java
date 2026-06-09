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

                    // VALIDAÇÃO DO HORÁRIO (Limite de 1h - Apenas horas cheias)
                    String horarioCadastro;
                    while (true) {
                        System.out.print("Informe o horário de início (Apenas horas cheias, Ex: 14:00): ");
                        horarioCadastro = sc.nextLine().trim();

                        // REGEX MODIFICADA: O final obrigatoriamente tem que ser ":00"
                        if (horarioCadastro.matches("^(0[0-9]|1[0-9]|2[0-3]):00$")) {
                            novo.setHorario(horarioCadastro);
                            break; // Horário válido, sai do loop
                        }
                        System.out.println("ERRO: A quadra só pode ser reservada em blocos de 1h fechada! Digite com ':00' no final (Ex: 08:00, 14:00, 22:00).");
                    }

                    // VALIDAÇÃO DO DIA (Padrão DD/MM)
                    String diaCadastro;
                    while (true) {
                        System.out.print("Qual o dia (Ex: 15/06): ");
                        diaCadastro = sc.nextLine().trim();
                        if (diaCadastro.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])$")) {
                            novo.setDia(diaCadastro);
                            break;
                        }
                        System.out.println("ERRO: Formato inválido! Use o padrão DD/MM com dois dígitos (Ex: 05/04, 15/06).");
                    }

                    System.out.print("Qual o esporte: ");
                    novo.setTipoEsporte(sc.nextLine());

                    // ENVIA PARA A SUA CLASSE E "TRADUZ" O RETORNO BOOLEAN
                    boolean cadastrou = servico.cadastrar(novo);
                    if (cadastrou) {
                        System.out.println("SUCESSO: Agendamento realizado!");
                    } else {
                        System.out.println("ERRO: Cadastro negado! ID já existente ou conflito de horário.");
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
                            a.mostrarDados(); // Usa o método mostrarDados que a Isabela criou
                        }
                        System.out.println("---------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("\n--- TELA DE EDIÇÃO ---");
                    System.out.print("Digite o ID do agendamento que deseja editar: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine(); // Limpa buffer

                    // VALIDAÇÃO DO NOVO DIA NA EDIÇÃO
                    String novoDia;
                    while (true) {
                        System.out.print("Digite o NOVO dia (Ex: 16/06): ");
                        novoDia = sc.nextLine().trim();
                        if (novoDia.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])$")) {
                            break;
                        }
                        System.out.println("ERRO: Formato inválido! Use o padrão DD/MM com dois dígitos (Ex: 05/04, 16/06).");
                    }

                    // VALIDAÇÃO DO NOVO HORÁRIO NA EDIÇÃO (Travado em hora cheia)
                    String novoHorario;
                    while (true) {
                        System.out.print("Digite o NOVO horário de início (Ex: 15:00): ");
                        novoHorario = sc.nextLine().trim();
                        if (novoHorario.matches("^(0[0-9]|1[0-9]|2[0-3]):00$")) {
                            break;
                        }
                        System.out.println("ERRO: Blocos de 1h fechada apenas! Digite com ':00' no final (Ex: 09:00, 15:00).");
                    }

                    System.out.print("Digite o NOVO esporte: ");
                    String novoEsporte = sc.nextLine();

                    // ENVIA PARA O SEU MÉTODO EDITAR E TRADUZ A RESPOSTA
                    boolean editou = servico.editar(idEditar, novoDia, novoHorario, novoEsporte);
                    if (editou) {
                        System.out.println("SUCESSO: Dados alterados com sucesso!");
                    } else {
                        System.out.println("ERRO: Edição negada! ID não existe ou o novo horário já está ocupado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- TELA DE EXCLUSÃO ---");
                    System.out.print("Digite o ID do agendamento a ser cancelado: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer do teclado

                    // BUSCA LOCAL DO AGENDAMENTO PARA MOSTRAR OS DADOS ANTES DE DELETAR
                    Agendamento agendamentoEncontrado = null;
                    for (Agendamento a : servico.listarTodos()) {
                        if (a.getId() == idExcluir) {
                            agendamentoEncontrado = a;
                            break;
                        }
                    }

                    // SE ENCONTROU, EXIBE OS DADOS E DEPOIS EXCLUI
                    if (agendamentoEncontrado != null) {
                        System.out.println("\nATENÇÃO! O seguinte agendamento será removido:");
                        System.out.println("---------------------------------");
                        agendamentoEncontrado.mostrarDados();
                        System.out.println("---------------------------------");

                        // EXECUTA A EXCLUSÃO DE FATO
                        boolean excluiu = servico.cancelar(idExcluir);
                        if (excluiu) {
                            System.out.println("SUCESSO: O agendamento acima foi cancelado e removido!");
                        } else {
                            System.out.println("ERRO: Código de ID não encontrado no sistema.");
                        }
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