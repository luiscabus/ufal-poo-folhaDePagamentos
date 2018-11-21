import java.util.*;


public class Adicionarempregado {
    
    public Adicionarempregado () {
        Empregado novoEmpregado;
        novoEmpregado = new Empregado();
        
        try (Scanner scanner = new Scanner(System.in)) {
            novoEmpregado.SetEmpregadoNome(scanner.nextLine());
            System.out.println("Novo empregado: " + novoEmpregado.getEmpregadoNome());
    //        System.out.println("Novo empregado: " + novoEmpregado.nome);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }
    
    public void test(){
        System.out.println("testando");
    }
}
