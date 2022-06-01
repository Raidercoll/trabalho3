package trabalho3;


import java.util.Scanner;

public class Cadastro {
    private Funcionario[] Funcionarios;
    private int tam = 0;

    public Cadastro(){
        Funcionarios = new Funcionario[1000];

        Funcionarios[tam++] = new Funcionario("Leonardo", "601.374.700-88", (float)12.50, 44, false);
        Funcionarios[tam++] = new Funcionario("João", "653.765.255-63", (float) 8.87, 35, true);
        Funcionarios[tam++] = new Funcionario("Pedro", "523.765.235-66", (float)7.79, 32, true);
        Funcionarios[tam++] = new Funcionario("Thiago", "765.675.865-25", (float)17.0, 28, false);
        Funcionarios[tam++] = new Funcionario("Gustavo", "763.165.867-77", (float)14.20, 44, false);
    }

    public void novoFuncionario(){

            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            boolean filhos = false;

            System.out.println("Nome do novo funcionário: ");
            String nome = sc1.nextLine();
            System.out.println("Cpf do novo funcionário: ");
            String cpf = sc1.nextLine();
            System.out.println("Valor da hora trabalhada: ");
            Float valorHoraTrabalhada = sc1.nextFloat();
            System.out.println("Carga horária semanal: ");
            Float cargaHorariaSemanal = sc1.nextFloat();
            System.out.println("Tem filhos?");
            String temFilhos = sc2.nextLine();
            String p = temFilhos.toUpperCase();

            if (p.equals("SIM")){
                filhos = true;
            } else {
                filhos = false;
            }

            Funcionarios[tam++] = new Funcionario(nome, cpf, valorHoraTrabalhada, cargaHorariaSemanal, filhos);
            // for (int i = 0; i < Funcionarios.length; i++){
            //     if (Funcionarios[i] == null){
            //         Funcionarios[i] = new Funcionario(nome, cpf, valorHoraTrabalhada, cargaHorariaSemanal, filhos);
            //         System.out.println("Cadastro concluído");
            //         break;
            //     }
            // }
    }

    public void imprime (){
        for (int i = 0; i < tam; i++){
                System.out.println(Funcionarios[i]);
        }
    }

    public Funcionario removePosicao(int pos){
        if ( pos < 0 || pos >= tam ){
            return null;
        }

        Funcionario funcionario = Funcionarios[pos];
        for(int i = pos; i < tam; i++){
            Funcionarios[i] = Funcionarios[i+1];
        } 
        tam--;

        return funcionario;
    }

    public void removePorCPF(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do funcinario desejado: ");
        String cpf = sc.nextLine();
        cpf = cpf.replace(" ", "");
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        int pos = tam;
        for(int i = 0; i < tam; i ++){
            if(cpf.equals(Funcionarios[i].getCpf())){
                pos = i;
                System.out.println("Funcionairo excluido com sucesso!");
                break;
            }
        }

        if(pos == tam){
            System.out.println("ERRO: cpf não encontrado");
            
        }

        removePosicao(pos);
    }

    public void editaSalario(){
        Scanner sc3 = new Scanner(System.in);
            System.out.println("Digite o cpf do funcionario");
            String cpf = sc3.nextLine();
            cpf = cpf.replace(" ", "");
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            int p = tam;
            for(int i = 0; i < tam; i ++){
                if(cpf.equals(Funcionarios[i].getCpf())){
                    p = i;
                System.out.println("Qual a nova carga horaria do(a) funionario(a)");
                    float a = Float.parseFloat(sc3.nextLine());
                    if (a > 44){
                                a = (float) 44;
                    }
                    Funcionarios[i].setCargaHorariaSemanal(a);
                    System.out.println("Qual o novo valor da hora do(a) funcionario(a)");
                    float b = Float.parseFloat(sc3.nextLine());
                    Funcionarios[i].setValorHoraTrabalhada(b);
            }
        }
        if(p == tam)
                System.out.println("ERRO: cpf n encontrado!");
    }

    public Funcionario maiorSalario(){
        Funcionario maior1 = Funcionarios[0];
            for (int i = 1; i < tam; i++){
                if (Funcionarios[i].salarioFuncionario() > maior1.salarioFuncionario()){
                    maior1 = Funcionarios[i];
                }
        }
        System.out.println("O funcionario com maior salario é " + maior1.getNome() + " e o salario dele é de " + maior1.salarioFuncionario() + " reais");
        return maior1;
    }

    public void percentualDeFilhos(){
        int tamanho = 0;
        float quant = 0;
            for(int i = 0; i < tam; i++){
                tamanho++;
                if(Funcionarios[i].isFilhos() == true){
                    quant++;
                }
            }
        System.out.println((quant/tamanho)*100 + "%");
    }


    public void menu(int opcao){
        Scanner sc = new Scanner(System.in);
        
        
    }



    public static void main(String[] args) {
        Scanner dc = new Scanner(System.in);

        Cadastro f = new Cadastro();

        for(;;){
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Bem vindo ao sistema de cadastro de funcionários.");
            System.out.println("Selecione a opção desejada: ");
            System.out.println("1. Cadastrar novo funcionário.");
            System.out.println("2. Listar funcionários cadastrados.");
            System.out.println("3. Remover funcionário a partir do cpf");
            System.out.println("4. Editar salário de um funcionário.");
            System.out.println("5. Funcionário com maior salário.");
            System.out.println("6. Percentual de funcionários que possuem filhos.");
            System.out.println("7. sair do programa.");
            System.out.print("Opção: ");
            int opcao = dc.nextInt();
            if(opcao == 1){
                f.novoFuncionario();
            }
            if(opcao == 2){
                f.imprime();
            }
            if(opcao == 3){
                f.removePorCPF();
            }
            if(opcao == 4){
                f.editaSalario();
            }
            if(opcao == 5){
                f.maiorSalario();
            }
            if(opcao == 6){
                f.percentualDeFilhos();
            }
            if (opcao == 7){
                System.out.println("Obrigado por utilizar nosso sistema.");
                    System.out.println("Saindo...");
                break;
            }
        }
    }
}
