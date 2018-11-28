


import java.util.*;


public class Empregado {

    long id;
    String nome;
    String endereco;
    int tipo; //1 hourly, 2 salaried, 3 commissioned
    int salarioHora;
    float salarioMes;
    int comissao;

    int tipoDeAgenda; // 1 1x/mes, 2 2x/mes, 4 4x/mes...
    int metodoPagamento; // 1 cheque correio, 2 cheque maos, 3 conta bancaria

    int pertenceSindicato;
    float taxaSindicato;

    float salarioHoraAcumulado;
    float comissoesAcumuladas;
    float taxaSindAcumulado;


    public Empregado(){}

    public Empregado(int id, String nome, String endereco, int tipo, int hora, int mes, int comissao, int agenda, int metodo, int pertence, float taxasind) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salarioHora = hora;
        this.salarioMes = mes;
        this.comissao = comissao;
        this.tipoDeAgenda = agenda;
        this.metodoPagamento = metodo;
        this.pertenceSindicato = pertence;
        this.taxaSindicato = taxasind;
    }

    public void PerguntarDados (int novo_emp_id) {

        this.setEmpregadoId(novo_emp_id);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o nome do empregado:\n");
        this.SetEmpregadoNome(scanner.nextLine());

        System.out.print("Entre com o endereço:\n");
        this.SetEmpregadoEndereco(scanner.nextLine());

        System.out.print("Entre com o tipo do empregado (1 hourly, 2 salaried, 3 comissioned):\n");
        this.SetEmpregadoTipo(scanner.nextInt());

        if (this.getEmpregadoTipo() == 1) {
            System.out.print("Entre com o salário hora:\n");
            this.SetEmpregadoSalarioH(scanner.nextInt());
            this.SetEmpregadoTipodeAgenda(4);
        }

        if (this.getEmpregadoTipo() == 2) {
            System.out.print("Entre com o salário mensal:\n");
            this.SetEmpregadoSalarioM(scanner.nextInt());
            this.SetEmpregadoTipodeAgenda(1);
        }

        if (this.getEmpregadoTipo() == 3) {
            System.out.print("Entre com o salário parte fixa mensal:\n");
            this.SetEmpregadoSalarioM(scanner.nextInt());
            System.out.print("Entre com a comissão (%):\n");
            this.SetEmpregadoSalarioC(scanner.nextInt());
            this.SetEmpregadoTipodeAgenda(2);
        }

        System.out.print("Pertence a sindicato? (0 não, 1 sim):\n");
        this.SetEmpregadoPertenceSindicato(scanner.nextInt());

        if (this.pertenceSindicato == 1) {
            System.out.print("Qual a taxa mensal cobrada pelo sindicato?\n");
            this.taxaSindicato = scanner.nextFloat();
        }

        System.out.println("Novo empregado incluído: ID: " + novo_emp_id + ", Nome: " + this.nome + ", Endereço: " + this.endereco);

    }

    public void ExcluirEmpregado (ArrayList<Empregado> arrayEmpregados) {

        System.out.println("Conforme a lista abaixo, qual empregado você deseja excluir? (opção)");

        for (int i = 0; i < arrayEmpregados.size(); ++i) {
            System.out.printf("(%d) Nome: %s\n", i, arrayEmpregados.get(i).nome);
        }

        Scanner scanner = new Scanner(System.in);
        int indice = scanner.nextInt();

        arrayEmpregados.remove(indice);

        System.out.println("Lista de empregados atualizada:");
        for (int i = 0; i < arrayEmpregados.size(); ++i) {
            System.out.printf("ID: %d, Nome: %s\n", i, arrayEmpregados.get(i).id, arrayEmpregados.get(i).nome);
        }
    }

    public void LancarCartaodePonto(ArrayList<Empregado> arrayEmpregados) {
        System.out.println("Qual empregado vai lançar horas? (opção) [horista tem tipo 1]");
        for (int i = 0; i < arrayEmpregados.size(); ++i) {
            System.out.printf("(%d) Nome: %s, Tipo: %d\n", i, arrayEmpregados.get(i).nome, arrayEmpregados.get(i).tipo);
        }

        Scanner scanner = new Scanner(System.in);
        int selecionado = scanner.nextInt();

        if (arrayEmpregados.get(selecionado).tipo != 1) {
            System.out.println("Lascou, não é horista");
        } else {
            System.out.printf("Quantas horas o empregado %s trabalhou\n", arrayEmpregados.get(selecionado).nome);
            int horas_trabalhadas = scanner.nextInt();
            float salario_add = 0;

            if (horas_trabalhadas > 8) {
                salario_add += arrayEmpregados.get(selecionado).salarioHoraAcumulado + arrayEmpregados.get(selecionado).salarioHora * 8;
                salario_add += arrayEmpregados.get(selecionado).salarioHoraAcumulado + arrayEmpregados.get(selecionado).salarioHora * (horas_trabalhadas - 8) * 1.5;
            } else {
                salario_add += arrayEmpregados.get(selecionado).salarioHoraAcumulado + arrayEmpregados.get(selecionado).salarioHora * horas_trabalhadas;
            }
            arrayEmpregados.get(selecionado).salarioHoraAcumulado += salario_add;
        }

    }

    public void LancarVenda(ArrayList<Empregado> arrayEmpregados) {
        System.out.println("Qual empregado vai lançar venda? (opção) [comissionado tem tipo 3]");
        for (int i = 0; i < arrayEmpregados.size(); ++i) {
            System.out.printf("(%d) Nome: %s, Tipo: %d\n", i, arrayEmpregados.get(i).nome, arrayEmpregados.get(i).tipo);
        }

        Scanner scanner = new Scanner(System.in);
        int selecionado = scanner.nextInt();

        if (arrayEmpregados.get(selecionado).tipo != 3) {
            System.out.printf("Eita, esse %s não é comissionado.", arrayEmpregados.get(selecionado).nome);
        } else {
            System.out.printf("Qual valor da venda para lançar ao empregado %s?\n", arrayEmpregados.get(selecionado).nome);
            int entrada = scanner.nextInt();
            arrayEmpregados.get(selecionado).comissoesAcumuladas += entrada * arrayEmpregados.get(selecionado).comissao / 100;
        }
    }

    public void LancarTaxas(ArrayList<Empregado> arrayEmpregados) {
        System.out.println("Qual empregado vai lançar taxas de sindicato? (aqui)");
        for (int i = 0; i < arrayEmpregados.size(); ++i) {
            System.out.printf("(%d) Nome: %s, Sindicalizado: %d\n", i, arrayEmpregados.get(i).nome, arrayEmpregados.get(i).pertenceSindicato);
        }

        Scanner scanner = new Scanner(System.in);
        int selecionado = scanner.nextInt();

        if (arrayEmpregados.get(selecionado).tipo != 1) {
            System.out.println("Lascou, não pertence a sindicato");
        } else {
            System.out.printf("Qual o valor da taxa a ser lançada para o empregado %s?\n", arrayEmpregados.get(selecionado).nome);
            int entrada = scanner.nextInt();
            arrayEmpregados.get(selecionado).taxaSindAcumulado += entrada;
        }
    }

    public void GerarFolha(ArrayList<Empregado> arrayEmpregados) {

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
    public float getEmpregadoSalarioM() {
        return salarioMes;
    }
    public int getEmpregadoSalarioC() {
        return comissao;
    }
    public int getEmpregadoPertenceSindicato() {
        return pertenceSindicato;
    }


    public void setEmpregadoId(int id) {
        this.id = id;
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
    public void SetEmpregadoSalarioM(float salarioMes) {
        this.salarioMes = salarioMes;
    }
    public void SetEmpregadoSalarioC(int comissao) {
        this.comissao = comissao;
    }
    public void SetEmpregadoPertenceSindicato(int pertenceSindicato) {
        this.pertenceSindicato = pertenceSindicato;
    }
    public void SetEmpregadoTipodeAgenda(int tipoDeAgenda) {
        this.tipoDeAgenda = tipoDeAgenda;
    }








//    System.out.println("Hello empregado!");
}

