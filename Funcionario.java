package trabalho3;

public class Funcionario {


    private String nome;
    private String cpf;
    private double valorHoraTrabalhada;
    private double cargaHorariaSemanal;
    private boolean temFilho;

    public Funcionario(String nome, String cpf, double valorHoraTrabalhada, double cargaHorariaSemanal, boolean temFilho) {
        if (cargaHorariaSemanal > 44){
            cargaHorariaSemanal = 44;
        }
        cpf = cpf.replace(" ", "");
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        this.nome = nome.toUpperCase();
        this.cpf = cpf;
        this.valorHoraTrabalhada = valorHoraTrabalhada;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.temFilho = temFilho;
    }

    public String getNome() {
        return nome;
    }

    public double getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public double getValorHoraTrabalhada() {
        return valorHoraTrabalhada;
    }

    public void setCargaHorariaSemanal(double cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public void setValorHoraTrabalhada(double valorHoraTrabalhada) {
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }


    public String getCpf() {
        return cpf;
    }

    public double salarioFuncionario(){
        double salario = cargaHorariaSemanal * valorHoraTrabalhada;
        return salario;
    }
    public boolean isFilhos(){
        return temFilho;
    }
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", valorHoraTrabalhada=" + valorHoraTrabalhada +
                ", cargaHorariaSemanal=" + cargaHorariaSemanal +
                ", temFilho=" + temFilho +
                '}';
    }
}
