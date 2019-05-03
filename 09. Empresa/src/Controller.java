class Funcionario{
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getBonificacao(){
            return this.salario*0.10;
        }

    @Override
    public String toString() {
        return "Fun:" + nome + ":" + salario;
    }
}

class Gerente extends Funcionario {
    protected String senha;

    public Gerente(String nome, double salario, String senha) {
        super(nome, salario);
        this.senha = senha;
    }

    String contratar(){
        return "Contratei um funcionario";
    }

    String demitir(){
        return "Demiti um funcionario";
    }

    @Override
    public String toString() {
        return "Ger:" + super.toString();
    }
}


public class Controller {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("davi", 1000,"1234" );
        System.out.println(g1);
        Funcionario f1 = new Funcionario("ana", 500);
        System.out.println(f1);
        System.out.println(g1.contratar());
    }
}
