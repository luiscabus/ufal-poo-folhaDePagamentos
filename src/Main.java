//javac -d /projects/folhaDePagamentos/bin/ /projects/folhaDePagamentos/src/*.java
//java Main /projects/folhaDePagamentos/bin/Main.class
//https://www.caelum.com.br/apostila-java-orientacao-objetos/orientacao-a-objetos-basica/#exerccios-orientao-a-objetos

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");
        System.out.println("Este sistema é uma folha de pagamentos!");

        java.util.ArrayList<Empregado> meusEmpregados = new java.util.ArrayList<Empregado>();

        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("O que você deseja fazer?\n");
            System.out.print("1- Adição de empregado\n");
            System.out.print("2- Remoção de empregado\n");
            System.out.print("3- Lançar um Cartão de Ponto\n");
            System.out.print("4- Lançar um Resultado Venda\n");
            System.out.print("5- Lançar uma taxa de serviço\n");
            System.out.print("6- Alterar detalhes de um empregado\n");
            System.out.print("7- Rodar a folha de pagamento para hoje\n");
            System.out.print("8- Undo\n");
            System.out.print("9- Redo\n");
            System.out.print("10- Agenda de Pagamento\n");
            System.out.print("11- Criação de Novas Agendas de Pagamento?\n");
            System.out.print("12- Listar empregados\n");  
            System.out.print("99- SAIR\n");
            
            index = scanner.nextInt();
            System.out.println("Sua escolha foi: " + index + "\t");

            if (index == 1) {
                Empregado novoEmpregado = new Empregado();
                novoEmpregado.PerguntarDados();
                meusEmpregados.add(novoEmpregado);
            }

        } while (index != 99);
        scanner.close();


    }
}