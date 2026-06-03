# 🏀🏐⚽ Sistema de Gestão e Agendamento de Quadras Esportivas

## 📋 Descrição do Projeto
Este projeto consiste em um sistema de software desenvolvido inteiramente na linguagem Java para execução em ambiente de terminal (console). O objetivo principal da aplicação é resolver problemas logísticos reais enfrentados por administradores de complexos esportivos, tais como conflitos de horários em reservas de quadras e duplicidade de identificadores de registros.

O sistema foi estruturado seguindo as boas práticas da Programação Orientada a Objetos (POO) em três camadas isoladas (Entidade, Controle/Serviço e Visão), garantindo um código modularizado, limpo e de fácil manutenção. A persistência de dados ocorre de maneira volátil em memória RAM através da estrutura dinâmica `ArrayList`.

---

## 🛠️ Funcionalidades do Sistema (CRUD)
* **[1] Cadastrar Agendamento:** Permite registrar uma nova locação validando se o ID informado já existe ou se há colisão de horários (bloqueando agendamentos para a mesma quadra, no mesmo dia e horário).
* **[2] Listar Agendamentos:** Percorre a lista interna de memória e renderiza na tela o relatório completo de reservas ativas com formatação limpa.
* **[3] Editar Agendamento:** Localiza uma reserva existente por meio do ID e atualiza o dia, o bloco de horário e o esporte, aplicando as mesmas regras de validação contra conflitos de agenda.
* **[4] Cancelar/Excluir Agendamento:** Remove de forma permanente e segura um registro do array de memória localizando-o pelo ID.

---

## 🏗️ Estrutura e Arquitetura do Código
O projeto foi dividido em 3 módulos principais para atender aos critérios de avaliação da arquitetura de software:
1. **`modeloEntidade.Agendamento`:** Objeto de modelo com atributos privados encapsulados (`id`, `nomeCliente`, `dia`, `horario`, `TipoEsporte`), métodos getters/setters e rotinas de exibição.
2. **`ControleAgendamento.ServicodeAgendamento`:** Classe de controle responsável pela inteligência do sistema, gerenciamento do `ArrayList` e execução das regras de validação lógica (retornando respostas booleanas).
3. **`MenuInteração.Main`:** Interface de usuário que gerencia o loop contínuo do menu no terminal, captura entradas via `Scanner` e traduz as respostas lógicas do serviço em mensagens textuais claras para o operador.

---

## 🚀 Como Executar o Sistema

### Pré-requisitos
* Possuir o Java Development Kit (JDK 8 ou superior) instalado na máquina.
* Uma IDE de preferência (IntelliJ IDEA, Eclipse ou VS Code) ou terminal do sistema operacional.

### Passo a Passo
1. Faça o clone deste repositório para a sua máquina local utilizando o terminal:
   ```bash
   git clone <https://github.com/Jeanpereira13/A3_Gestao_QuadraEsportiva.git>

2. Abra o projeto na sua IDE de preferência.


3. Localize o arquivo Main.java localizado dentro do pacote MenuInteração.


4. Execute (Run) a classe Main.


5. Interaja com o sistema utilizando os comandos numéricos indicados no menu do terminal (digite 0 para encerrar e salvar com segurança).


## Integrantes do Grupo

Isabela Alves de Carvalho

Jean Pereira de Araújo

Matheus Henrique Leocádio Peres da Silva

Mayckow Pedro Moura Romão

Willian Gabriel Correa de Azevedo

*Projeto acadêmico desenvolvido como critério de Avaliação Final (A3) para a Unidade Curricular de Algoritmos e Programação sob a orientação do Prof. Matheus Figueiredo - Ano 2026.*