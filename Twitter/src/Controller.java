import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Usuario{
    String id;
    ArrayList<Usuario> seguidores;
    ArrayList<Usuario> seguidos;
    ArrayList<String> tweets;

    public Usuario(String id) {
        this.id = id;
        seguidores = new ArrayList<Usuario>();
        seguidos = new ArrayList<Usuario>();
    }

    public void seguir(Usuario other){
        for (Usuario user : seguidos)
            if (user.id.equals(other.id))
                return;
        this.seguidos.add(other);
        other.seguidores.add(this);
    }

    @Override
    public String toString() {
        String saida = id + "\n";
        saida += "<- [ ";
        for (Usuario user : seguidos)
            saida += user.id + " ";
        saida += "]/n->[";
        for (Usuario user : seguidores)
            saida+=user.id +" ";
        saida += "]";
        return saida;
    }
}

class Sistema{
    Map<String, Usuario> usuarios;

    public Sistema(){
        usuarios = new TreeMap<String, Usuario>();
    }

    public void addUsuario(String id){
        Usuario user = usuarios.get(id);
        if (user==null){
            usuarios.put(id, new Usuario(id));
        }
    }

    public Usuario getUsuario(String id){
        Usuario user =usuarios.get(id);
        if (user == null)
            throw new RuntimeException("fail:user nao encontrado");
        return user;
    }

    @Override
    public String toString() {
        String saida =" ";
        for (Usuario user : usuarios.values())
            saida += user + "\n";
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");

            try {

                if (ui[0].equals("end")) {
                    break;
                } else if (ui[0].equals("addUser")) {
                    sistema.addUsuario(ui[1]);
                } else if (ui[0].equals("show")) {
                    System.out.println(sistema);
                } else if (ui[0].equals("seguir")) {
                    Usuario um = sistema.getUsuario(ui[1]);
                    Usuario dois = sistema.getUsuario(ui[2]);
                    um.seguir(dois);
                }

            } catch (RuntimeException rt) {
                System.out.println(rt.getMessage());
            }
        }
    }
}
