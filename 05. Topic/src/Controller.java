import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.ws.client.ClientTransportException;

import java.util.ArrayList;
import java.util.Scanner;

class Passageiros{
    public String id;
    public int idade;

    public Passageiros (String id, int idade){
        this.id = id;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.idade;
    }

    public boolean prioridade(){
        return idade <= 60;
    }
}

class Topic {
    ArrayList<Passageiros> cadeiras;

    int prioridade;

    public Topic(int capacidade, int prioridade) {
        cadeiras = new ArrayList<Passageiros>();

        for (int i = 0; i < capacidade; i++) {
            cadeiras.add(null);
        }

        this.prioridade = prioridade;
    }

    public String toString() {
        String saida = "[";
        for (int i = 0; i < cadeiras.size(); i++) {
            if (i < prioridade)
                saida += "@";
            else
                saida += "=";
            if (cadeiras.get(i) != null)
                saida += cadeiras.get(i);
        }
        return saida + " ]";
    }

    private boolean inserir(int inicio, int fim, Passageiros pass) {
        for (int i = inicio; i < fim; i++) {
            if (cadeiras.get(i) == null) {
                cadeiras.set(i, pass);
                return true;
            }
        }
        return false;
    }

    public void inserir(Passageiros pass) {
        if (pass.prioridade()) {
            inserir(0, this.cadeiras.size(),pass);
        } else {
            if (!inserir(this.prioridade, this.cadeiras.size(), pass))
                inserir(0, this.prioridade, pass);
        }
    }

    boolean remover (String id){
        for (int i = 0; i < cadeiras.size(); i ++) {
            if (cadeiras.get(i).id != null) {
                if (cadeiras.get(i).id.equals(id)){
                    cadeiras.set(i, null);
                    return true;
                }
            }
        }
        return false;
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0,0);

        while (true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")){
                break;
            }else if (ui[0].equals("init")){
                topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if (ui[0].equals("show")){
                System.out.println(topic.toString());
            }else if (ui[0].equals("inserir")){
                topic.inserir(new Passageiros(ui[1], Integer.parseInt(ui[2])));
            }else if (ui[0].equals("remover")){
                topic.remover(ui[1]);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
    }
}
