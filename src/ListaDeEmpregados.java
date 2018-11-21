public class ListaDeEmpregados {

    java.util.ArrayList<Empregado> lista_de_empregados = new java.util.ArrayList<Empregado>();

    public ListaDeEmpregados() {

    }

    public void AdicionarEmpregado (Empregado e) {
        this.lista_de_empregados.add(e);
    }


}
