import java.util.Scanner;

class Calc {
    public int bateriaMax;
    public int bateria;
    public int total;

    public Calc(int bateriaMax) {
        this.bateriaMax = bateriaMax;
        this.bateria = 0;
    }

    public void charge(int value){
        this.bateria += value;
        if (this.bateria > this.bateriaMax){
            this.bateria = this.bateriaMax;
        }
    }

    public boolean gastarBateria(int a, int b){
        if (this.bateria == 0){
            System.out.println("fail: bateria insuficiente");
            return false;}
        System.out.println("a+b");
            return true;
    }

    public void somar(int a, int b){
        if (this.bateria > 0){
            this.bateria -=1;
            total = a + b;
            System.out.println(total);
        }else{
            System.out.println("fail: bateria insuficiente");
        }
    }

    public void dividir(int a, int b){
        if (this.bateria > 0){
            this.bateria -= 1;
            total = a / b;
            System.out.println(total);
            if (total == 0){
                System.out.println("erro");
            }
        }else{
            System.out.println("fail: bateria insuficiente");
        }
    }

    @Override
    public String toString() {
        return "battery = " + this.bateria;
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc(0);

        while (true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            }else if (ui[0].equals("show")){
                System.out.println(calc);
            }else if (ui[0].equals("init")){
                calc = new Calc(Integer.parseInt(ui[1]));
            }else if (ui[0].equals("charge")){
                calc.charge(Integer.parseInt(ui[1]));
            }else if (ui[0].equals("sum")) {
                calc.somar(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("div")){
                calc.dividir(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else{
                System.out.println("comando invalido");
            }
        }
    }
}
