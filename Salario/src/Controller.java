abstract class Funcionario{
    String nome;
    abstract double calcSalario();

    public Funcionario(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}

class Professor extends Funcionario{
    char classe;

    Professor(String nome, char class){
        super(nome);
        this.classe = classe;
    }

    double calcSalario(){
        return (classe - 'A') * "classe: " + this.classe;
    }

    @Override
    public String toString() {
        return super.toString() + "classe: " + this.class;
    }
}



public class Controller {
    public static void main(String[] args) {
        Professor david = new Professor("david","d")
        System.out.println(david);
        System.out.println(david.calcSalario());
    }

}
