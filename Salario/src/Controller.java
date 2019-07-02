import java.util.ArrayList;
import java.util.Scanner;

abstract class Funcionario{
    String nome;

    abstract double calcSalario();

    public Funcionario(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " ";
    }
}

class Professor extends Funcionario{
    char classe;

    Professor(String nome, char classe){
        super(nome);
        this.classe = classe;
    }

    double calcSalario(){
        return (classe - 'A') * 2000 + 3000;
    }

    @Override
    public String toString() {
        return "Prof " + super.toString() + " classe: " + this.classe + " salario: " + calcSalario();
    }
}

class Sta extends Funcionario{
    int nivel;

    public Sta(String nome, int nivel) {
        super(nome);
        this.nivel = nivel;
    }


    double calcSalario() {
        return 3000 + (300 * nivel);
    }


    @Override
    public String toString() {
        return "STA " + super.nome + " " + "nivel: " + this.nivel + "salario: " + calcSalario();
    }
}

class Tercerizado extends Funcionario{
    int horas;
    boolean insalubre;

    public Tercerizado(String nome, int horas, boolean insalubre) {
        super(nome);
        this.horas = horas;
        this.insalubre = insalubre;
    }

    @Override
    double calcSalario() {
        if (insalubre == true){
            return 4*this.horas + 500;
        }else {
            return 4*this.horas;
        }
    }


    @Override
    public String toString() {
        if (insalubre == true){
            return "Ter " + super.nome + " " + this.horas + "h" + " insalubre" + " salario:" + calcSalario();
        }else{
            return "Ter " + super.nome + " " + this.horas + "h " + " salario:" + calcSalario();
        }
    }
}

class Sistema {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Sistema(){
        funcionarios = new ArrayList<Funcionario>();
    }

    public void addFunc(Funcionario func){
        funcionarios.add(func);
    }

    public void show(String nome){
        for(Funcionario funcionario : funcionarios){
            if(funcionario.nome.equals(nome)){
                System.out.println(funcionario);
            }
        }
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            }else if (ui[0].equals("show")){
                sistema.show(ui[1]);
            }else if (ui[0].equals("addProf")){
                Funcionario prof = new Professor((ui[1]),ui[2].charAt(0));
                sistema.addFunc(prof);
                prof.calcSalario();
            }else if (ui[0].equals("addSta")){
                Funcionario sta = new Sta((ui[1]),Integer.parseInt(ui[2]));
                sistema.addFunc(sta);
                sta.calcSalario();
            }else if (ui[0].equals("addTer")){
                Funcionario ter = new Tercerizado((ui[1]),Integer.parseInt(ui[2]),Boolean.parseBoolean(ui[3]));
                sistema.addFunc(ter);
                ter.calcSalario();
            }
        }
    }
}
