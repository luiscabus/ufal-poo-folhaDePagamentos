package com.company;

//javac -d /projects/folhaDePagamentos/bin/ /projects/folhaDePagamentos/src/*.java
//java Main /projects/folhaDePagamentos/bin/Main.class
//https://www.caelum.com.br/apostila-java-orientacao-objetos/orientacao-a-objetos-basica/#exerccios-orientao-a-objetos

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println();System.out.println();

        int emp_count = 0;
        int dia_de_hoje = 1;
        int mes_de_hoje = 1;
        int ano_de_hoje = 2018;
        int diasCorridos = 2;
        String diaDaSemana = "";

        ArrayList<Empregado> meusEmpregadosList = new ArrayList<Empregado>();

        emp_count+=1;
        Empregado novoEmp = null;
        novoEmp = new Empregado(emp_count, "HH Horista", "HOR",
                1, 12, 0, 0, 4, 3, 0, 0);
        meusEmpregadosList.add(novoEmp);

        emp_count+=1;
        novoEmp = new Empregado(emp_count, "AA Assalariado", "ASS",
                2, 0, 964, 0, 1, 3,0, 0);
        meusEmpregadosList.add(novoEmp);

        emp_count+=1;
        novoEmp = new Empregado(emp_count, "CC Comissionado", "COM",
                3, 0, 600, 12, 2, 3, 0, 0);
        meusEmpregadosList.add(novoEmp);

        emp_count+=1;
        novoEmp = new Empregado(emp_count, "HORIST Sindical", "HOR SIN Endereço",
                1, 12, 0, 0, 4, 1, 1, 7);
        meusEmpregadosList.add(novoEmp);

        emp_count+=1;
        novoEmp = new Empregado(emp_count, "ASSALA Sindical", "ASS",
                2, 0, 964, 0, 1, 3, 1, 8);
        meusEmpregadosList.add(novoEmp);

        // adicionar horas ao hh horista
        meusEmpregadosList.get(0).salarioHoraAcumulado += meusEmpregadosList.get(0).salarioHora * 7;

        // adicionar comissões ao comissionado
        meusEmpregadosList.get(2).comissoesAcumuladas += meusEmpregadosList.get(2).comissao * 220.00 / 100.00;
        meusEmpregadosList.get(2).comissoesAcumuladas += meusEmpregadosList.get(2).comissao * 438.00 / 100.00;

        // adicionar horas e taxas ao horista sindicalizado
        meusEmpregadosList.get(3).salarioHoraAcumulado += meusEmpregadosList.get(3).salarioHora * 4;
        meusEmpregadosList.get(3).taxaSindAcumulado += 13;
        meusEmpregadosList.get(3).taxaSindAcumulado += 16;

        // adicionar taxas ao assalariado sindicalizado
        meusEmpregadosList.get(4).taxaSindAcumulado += 31;


        int index = 0;
        Scanner scanner = new Scanner(System.in);
        do {

            switch (diasCorridos % 7) {
                case 1:
                    diaDaSemana = "Domingo";
                    break;
                case 2:
                    diaDaSemana = "Segunda-feira";
                    break;
                case 3:
                    diaDaSemana = "Terça-feira";
                    break;
                case 4:
                    diaDaSemana = "Quarta-feira";
                    break;
                case 5:
                    diaDaSemana = "Quinta-feira";
                    break;
                case 6:
                    diaDaSemana = "Sexta-feira";
                    break;
                case 0:
                    diaDaSemana = "Sábado";
                    break;
            }



            System.out.printf("### ---- DIA DE HOJE: %d/%d/%d -- %s ---- ###    ", dia_de_hoje, mes_de_hoje, ano_de_hoje, diaDaSemana);
            System.out.printf("Esta é a gambiarra de uma folha de pagamentos!\n\n");
            System.out.print("O que você deseja fazer?\n");
            System.out.print("1- Adição de empregado\t\t\t\t");
            System.out.print("2- Remoção de empregado\t\t\t\t");
            System.out.print("6- Alterar detalhes de um empregado\t\t");
            System.out.print("10- Alterar agenda de pagamento\n");

            System.out.print("3- Lançar um Cartão de Ponto\t\t");
            System.out.print("4- Lançar um Resultado Venda\t\t");
            System.out.print("5- Lançar uma taxa de serviço\n");

            System.out.print("7- Rodar a folha de pagamento para hoje\n");
            System.out.print("8- Undo\t\t");
            System.out.print("9- Redo\n");
            System.out.print("11- Criação de Novas Agendas de Pagamento\n");
            System.out.print("12- Listar empregados cadastrados\n");
            System.out.print("99- SAIR:\n");

            index = scanner.nextInt();
            System.out.println("Sua escolha foi: " + index + "\t");

            if (index == 1) { //adicionar empregado
                Empregado novoEmpregado = new Empregado();
                emp_count += 1;
                novoEmpregado.PerguntarDados(emp_count);
                meusEmpregadosList.add(novoEmpregado);
            }

            if (index == 2) { //remover empregado
                System.out.println();System.out.println();
                new Empregado().ExcluirEmpregado(meusEmpregadosList);
                System.out.println();System.out.println();
            }

            if (index == 3) { //inserir cartao de ponto
                System.out.println();System.out.println();
                new Empregado().LancarCartaodePonto(meusEmpregadosList);
                System.out.println();System.out.println();
            }

            if (index == 4) { //inserir venda
                System.out.println();System.out.println();
                new Empregado().LancarVenda(meusEmpregadosList);
                System.out.println();System.out.println();
            }

            if (index == 5) { //lançar taxa de serviços de sindicato
                System.out.println();System.out.println();
                new Empregado().LancarTaxas(meusEmpregadosList);
                System.out.println();System.out.println();
            }

            if (index == 6) {

            }

            if (index == 7) {
                System.out.println();System.out.printf("# Folha de Pagamentos\n\n");

                for (int i = 0; i < meusEmpregadosList.size(); ++i) {
                    boolean temPagamento = false;

                    String formapagamento = "";
                    switch (meusEmpregadosList.get(i).metodoPagamento) {
                        case 1:
                            formapagamento = "Cheque pelos correios para o endereço: " + meusEmpregadosList.get(i).endereco;
                            break;
                        case 2:
                            formapagamento = "Cheque entregue em mãos";
                            break;
                        case 3:
                            formapagamento = "Depósito em conta bancária";
                            break;
                    }

                    float salarioMensalProporcional = 0;
                    switch (meusEmpregadosList.get(i).tipo) {
                        case 2:
                            salarioMensalProporcional = meusEmpregadosList.get(i).salarioMes;
                            break;
                        case 3:
                            salarioMensalProporcional = (meusEmpregadosList.get(i).salarioMes / 2);
                            break;
                    }

//                    String sindicalizado = (meusEmpregadosList.get(i).pertenceSindicato == 1) ? "Sim" : "Não";

                    float saldoLiquido = 0;

                    if (meusEmpregadosList.get(i).tipoDeAgenda == 30) { // horistas -> todo dia
                        temPagamento = true;
                        saldoLiquido = meusEmpregadosList.get(i).salarioHoraAcumulado
                                - meusEmpregadosList.get(i).taxaSindicato
                                - meusEmpregadosList.get(i).taxaSindAcumulado;
                    }

                    if (diasCorridos % 7 == 6 && meusEmpregadosList.get(i).tipoDeAgenda == 4) { // horistas -> sexta-feira
                        temPagamento = true;
                        saldoLiquido = meusEmpregadosList.get(i).salarioHoraAcumulado
                                - meusEmpregadosList.get(i).taxaSindicato
                                - meusEmpregadosList.get(i).taxaSindAcumulado;
                    }

                    if ((dia_de_hoje == 15 || dia_de_hoje == 30) && meusEmpregadosList.get(i).tipoDeAgenda == 2) { // mensalistas comissionados -> 2x/mes
                        temPagamento = true;
                        saldoLiquido = (meusEmpregadosList.get(i).salarioMes / 2)
                                + meusEmpregadosList.get(i).comissoesAcumuladas
                                - meusEmpregadosList.get(i).taxaSindicato
                                - meusEmpregadosList.get(i).taxaSindAcumulado;
                    }

                    if (dia_de_hoje == 30 && meusEmpregadosList.get(i).tipoDeAgenda == 1) { // mensalistas -> 1x/mes
                        temPagamento = true;
                        saldoLiquido = meusEmpregadosList.get(i).salarioMes
                                - meusEmpregadosList.get(i).taxaSindicato
                                - meusEmpregadosList.get(i).taxaSindAcumulado;
                    }

                    if (temPagamento) {
                        System.out.printf("---=--- início item %d\n", i);
                        System.out.printf("[%s]\n", meusEmpregadosList.get(i).nome);
                        System.out.printf("   [%.2f] Salário mensal proporcional\n", salarioMensalProporcional);
                        System.out.printf(" + [%.2f] Horas \n", meusEmpregadosList.get(i).salarioHoraAcumulado);
                        System.out.printf(" + [%.2f] Comissões \n", meusEmpregadosList.get(i).comissoesAcumuladas);
                        System.out.printf(" - [%.2f] Desconto do Sindicato \n", meusEmpregadosList.get(i).taxaSindicato);
                        System.out.printf(" - [%.2f] Taxas do Sindicato \n", meusEmpregadosList.get(i).taxaSindAcumulado);
                        System.out.printf("== [%.2f] Valor Líquido a Receber \n", saldoLiquido);
                        System.out.printf("** Pagamento na forma:\n   [%s]\n", formapagamento);
                        System.out.printf("---=--- fim item %d\n\n", i);

                        meusEmpregadosList.get(i).salarioHoraAcumulado = 0;
                        meusEmpregadosList.get(i).comissoesAcumuladas = 0;
                        meusEmpregadosList.get(i).taxaSindAcumulado = 0;
                    }

                }



                if (dia_de_hoje < 30) {
                    dia_de_hoje++;
                } else if (dia_de_hoje == 30) {
                    dia_de_hoje = 1;
                    if (mes_de_hoje == 12) {
                        mes_de_hoje = 1;
                        ano_de_hoje++;
                    } else {
                        mes_de_hoje++;
                    }
                }
                diasCorridos++;
                System.out.println();System.out.println();
            }

            if (index == 12) {
                System.out.println();System.out.println("# Lista de Empregados");
                for (int i = 0; i < meusEmpregadosList.size(); ++i) {
                    System.out.printf("" +
                                    "ID: %d, " +
                                    "Nome: %s, " +
                                    "Tipo %d, " +
                                    "SH %d, " +
                                    "SM %.2f, " +
                                    "SC %d, " +

                                    "Agenda %d, " +
                                    "MetPag %d, " +

                                    "Sind? %d, " +
                                    "TaxaSind %.2f, " +

                                    "SalHoraAcum %.2f, " +
                                    "ComissoesAcum %.2f, " +
                                    "TxSAcum %.2f\n",
                            meusEmpregadosList.get(i).id,
                            meusEmpregadosList.get(i).nome,
                            meusEmpregadosList.get(i).tipo,
                            meusEmpregadosList.get(i).salarioHora,
                            meusEmpregadosList.get(i).salarioMes,
                            meusEmpregadosList.get(i).comissao,

                            meusEmpregadosList.get(i).tipoDeAgenda,
                            meusEmpregadosList.get(i).metodoPagamento,

                            meusEmpregadosList.get(i).pertenceSindicato,
                            meusEmpregadosList.get(i).taxaSindicato,

                            meusEmpregadosList.get(i).salarioHoraAcumulado,
                            meusEmpregadosList.get(i).comissoesAcumuladas,
                            meusEmpregadosList.get(i).taxaSindAcumulado);
                }
                System.out.println();System.out.println();
            }

        } while (index != 99);
        scanner.close();


    }

}