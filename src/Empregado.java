import java.util.*;


public class Empregado {

    long id;
    String nome;
    String endereco;
    int tipo; //1 hourly, 2 salaried, 3 commissioned
    int salarioHora;
    int salarioMes;
    int comissao;

    public Empregado(){}

    public Empregado(String nome, String endereco, int tipo, int salarioHora, int salarioMes, int comissao) {
        this.id = 1;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salarioHora = salarioHora;
        this.salarioMes = salarioMes;
        this.comissao = comissao;
    }

    public void PerguntarDados (Empregado n) {

        System.out.print("Entre com o nome do empregado:\n");
        try (Scanner scanner = new Scanner(System.in)) {
            n.SetEmpregadoNome(scanner.nextLine());
//            System.out.println("Novo empregado: " + novoEmpregado.nome);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }



    }


    public String getEmpregadoNome() {
        return nome;
    }
    public String getEmpregadoEndereco() {
        return endereco;
    }
    public int getEmpregadoTipo() {
        return tipo;
    }
    public int getEmpregadoSalarioH() {
        return salarioHora;
    }
    public int getEmpregadoSalarioM() {
        return salarioMes;
    }
    public int getEmpregadoSalarioC() {
        return comissao;
    }



    public void SetEmpregadoNome(String nome) {
        this.nome = nome;
    }
    public void SetEmpregadoEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void SetEmpregadoTipo(int tipo) {
        this.tipo = tipo;
    }
    public void SetEmpregadoSalarioH(int salarioHora) {
        this.salarioHora = salarioHora;
    }
    public void SetEmpregadoSalarioM(int salarioMes) {
        this.salarioMes = salarioMes;
    }
    public void SetEmpregadoSalarioC(int comissao) {
        this.comissao = comissao;
    }








//    System.out.println("Hello empregado!");
}

