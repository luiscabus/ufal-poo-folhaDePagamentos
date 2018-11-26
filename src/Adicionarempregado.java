import java.util.*;


public class Adicionarempregado {
    
    public Empregado AdicionarNovoEmpregado () {
        Empregado novoEmpregado;
        novoEmpregado = new Empregado();
        
        try (Scanner scanner = new Scanner(System.in)) {
            novoEmpregado.SetEmpregadoNome(scanner.nextLine());
            System.out.println("Novo empregado: " + novoEmpregado.getEmpregadoNome());
    //        System.out.println("Novo empregado: " + novoEmpregado.nome);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
        return novoEmpregado;

    }
    
    public void test(){
        System.out.println("testando");
    }
}
