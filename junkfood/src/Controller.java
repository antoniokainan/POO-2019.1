import java.util.ArrayList;
import java.util.Scanner;

class Espiral{
    String nome;
    double preco;
    int qtd;

    public Espiral(String nome, double preco, int qtd){
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }
    public String toString(){
        return "[" + this.nome + " : " + this.qtd + "U : " + this.preco + "]";
    }
}

class Maquina{
    ArrayList<Espiral> espirais;
    double saldo;
    int maxProdutos;

    public Maquina(int nEspirais, int maxProdutos){
        espirais = new ArrayList<Espiral>();
        for(int i = 0; i < nEspirais; i++)
            espirais.add(new Espiral("Empty", 0, 0));
        this.maxProdutos = maxProdutos;
    }

    public String toString(){
        String saida = "";
        for(int i = 0; i < espirais.size(); i++){
            saida += i + " " + espirais.get(i) + "\n";
        }
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maq = new Maquina(0, 0);
        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                maq = new Maquina(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("show")){
                System.out.println(maq);
            }
        }
    }
}