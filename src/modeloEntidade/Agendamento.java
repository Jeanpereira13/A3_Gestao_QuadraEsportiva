package modeloEntidade;

public class Agendamento {

    private String nomeCliente;
    private String horario;
    private String dia;
    private String TipoEsporte;
    private int id;

    //construtor, vai receber os dados
    public Agendamento(String nomeCliente, String dia, String horario, String esporte, int id){
     this.nomeCliente = nomeCliente;
     this.dia = dia;
     this.horario = horario;
     this.TipoEsporte = esporte;
     this.id = id;
    }

    //set altera o valor
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    //get pega o valor
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setTipoEsporte(String esporte) {
        this.TipoEsporte = esporte;
    }

    public String getTipoEsporte() {
        return TipoEsporte;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void mostrarDados(){
        System.out.println("NOME: " + nomeCliente);
        System.out.println("HORÁRIO: " + horario);
        System.out.println("DIA: " + dia);
        System.out.println("ESPORTE: " + TipoEsporte);
        System.out.println("ID: " + id);
    }
    //atributos privados

}
