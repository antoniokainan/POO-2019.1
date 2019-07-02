import java.util.ArrayList;
import java.util.Scanner;

class Passageiro{
    String id;
    int idade;

    public Passageiro(String id, int idade) {
        this.id = id;
        this.idade = idade;
    }

    public boolean prioridade(){
        return idade >= 60;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.idade;
    }
}

class Topic {
    ArrayList<Passageiro> poltronas;
    int qtdPrioridade;
    int capacidade;

    public Topic(int capacidade, int qtdPrioridade) {
        poltronas = new ArrayList<Passageiro>();
        for (int i = 0; i < capacidade; i++) {
            poltronas.add(null);
        }
        this.qtdPrioridade = qtdPrioridade;
    }

    public void inserir (Passageiro pass) {
        if (pass.prioridade()) {
            for (int i = 0; i < qtdPrioridade; i++) {
                if (poltronas.get(i) == null) {
                    poltronas.set(i, pass);
                    return;
                }
            }

            for (int i = qtdPrioridade; i < poltronas.size(); i++) {
                if (poltronas.get(i) == null) {
                    poltronas.set(i, pass);
                    return;
                }
            }
        }

        else{
            for (int i = qtdPrioridade; i < poltronas.size(); i++) {
            if (poltronas.get(i) == null) {
                poltronas.set(i, pass);
                return;
            }

            for (i = 0; i < qtdPrioridade; i++) {
            if (poltronas.get(i) == null) {
                poltronas.set(i, pass);
                return;
                    }
                }
            }
        }
    }

    public void remover(String id){
        for (int i = 0; i < poltronas.size(); i++){
            if (poltronas.get(i) != null){
                if (poltronas.get(i).id.equals(id)){
                    poltronas.set(i, null);
                }
            }
        }
    }


    @Override
    public String toString() {
        String saida = "[";
        for (int i = 0; i < this.poltronas.size(); i++) {
            if (i < this.qtdPrioridade) {
                saida += (" @");
            } else {
                saida += (" =");
            }
            if (poltronas.get(i) != null)
                saida += poltronas.get(i);
            }
        return saida + " ]";
    }
}

public class Controller {
    public static void main(String[] args) {
        Topic topic = new Topic(0, 0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("init")) {
                topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("show")) {
                System.out.println(topic);
            } else if (ui[0].equals("inserir")) {
                topic.inserir(new Passageiro((ui[1]), Integer.parseInt(ui[2])));
            }else if (ui[0].equals("remover")) {
                topic.remover(ui[1]);
            }else {
                System.out.println("comando invalido");;
            }
        }
    }
}