package ControleAgendamento;

import modeloEntidade.Agendamento;

import java.util.ArrayList;

public class ServicodeAgendamento {

    //Arraylist como "Banco de dados" dinâmico
    private ArrayList<Agendamento> listaAgendamento = new ArrayList<>();

    //Cadastrar(Create)
    public boolean cadastrar(Agendamento novo) {
        //Verificação de ID duplicado
        for (Agendamento existente : listaAgendamento) {

            //Verifica se outra pessoa possui cadastro com o ID
            if (existente.getId() == novo.getId()){
                return false;//O cadastro é bloqueado,pois outro usuário já utilizou esse ID no sistema
            }

            //Verifica se a quadra já está reservada no mesmo dia e horário
            if (existente.getDia().equalsIgnoreCase(novo.getDia()) &&
                existente.getHorario().equalsIgnoreCase(novo.getHorario())) {
                return false;//Se o dia e o horário escolhido já estiver reservado,o cadastro é barrado,retornando falso
            }
        }
        //Se a quadra estiver livre,no dia e horário desejado,add na lista e retorna verdadeiro
        listaAgendamento.add(novo);
        return true;
    }

    //Listar(Read)

    public ArrayList<Agendamento> listarTodos() {
        //Apenas mostrar a lista cadastrada para a classe Main exibir
        return listaAgendamento;
    }

    //Editar(Update)

    public boolean editar(int id,String  novoDia, String novoHorario, String novoEsporte) {
        //Verifica se o novo horário escolhido para a edição não vai colidir com outro agendamento existente no cadastro
        for (Agendamento a : listaAgendamento) {
            if (a.getId() != id) { //Ignora o próprio agendamento que será editado,o antigo
                if (a.getDia().equalsIgnoreCase(novoDia) && a.getHorario().equalsIgnoreCase(novoHorario)) {
                    return false; // Se o dia e o horário escolhidos,tiverem ocupados por uma pessoa,o processo de edição é barrado
                }
            }
        }

        //Se o horário estiver livre,localiza o agendamento pelo ID e altera os dados cadastrados(os atributos)
        for (Agendamento a : listaAgendamento) {
            if (a.getId() == id) {
                a.setDia(novoDia);
                a.setHorario(novoHorario);
                a.setTipoEsporte(novoEsporte);
                return true; // Alteração feita com sucesso
            }
        }
        return false; // Retorna falso se o ID digitado não for encontrado,ou seja,a pessoa não fez um cadastro para poder editá-lo
    }

    //Excluir(Delete)
    public boolean cancelar(int id) {
        //Busca na lista quem tem o ID que solicitou a exclusão geral do cadastro,removendo da lista
        for (int i = 0; i < listaAgendamento.size(); i++) {
            if (listaAgendamento.get(i).getId() == id) {
                listaAgendamento.remove(i);
                return true; // Remoção do cadastro concluída
            }
        }
        return false; // Retorna falso se o ID não existir,ou seja, a pessoa não fez um cadastro para poder excluí-lo da lista
    }
}