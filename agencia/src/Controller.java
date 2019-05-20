import java.util.ArrayList;
import java.util.Scanner;

class Cliente{
    String idCliente;
    int cp;
    int cc;

    public Cliente(String idCliente, int cp, int cc) {
        this.idCliente = idCliente;
        this.cp = 0;
        this.cc = 0;
    }

    @Override
    public String toString() {
        return idCliente;
    }
}

class Banco{
    ArrayList<Cliente> clientes;

    void cadastrar(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public String toString() {
        String saida = " ";
        for (Cliente cliente : clientes) {
            saida += cliente + "\n";
        }
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split("");
            if (ui[0].equals("end")){
                break;
            }else if (ui[0].equals("show")){
                System.out.println(banco.clientes);
            }else if (ui[0].equals("addCli")){
                String idCliente = ui[1];
                banco.cadastrar(new Cliente(idCliente,0 ,0));
            }
        }
    }
}
