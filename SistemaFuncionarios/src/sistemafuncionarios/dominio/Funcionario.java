package sistemafuncionarios.dominio;

public class Funcionario {
    private String nome;
    private int idade;
    private String cargo;
    private static int contadorID = 0;
    private final int ID;

    public Funcionario(String nome, int idade, String cargo){
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.ID = ++contadorID;
    }

    public void imprime(){
        System.out.println("_______________________________");
        System.out.printf("ID: %04d%n", this.ID);
        System.out.println("Nome: "+this.nome);
        System.out.println("Idade: "+this.idade);
        System.out.println("Cargo: "+this.cargo);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public static int getContadorID() {
        return contadorID;
    }

    public static void setContadorID(int contadorID) {
        Funcionario.contadorID = contadorID;
    }

    public int getID() {
        return ID;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
