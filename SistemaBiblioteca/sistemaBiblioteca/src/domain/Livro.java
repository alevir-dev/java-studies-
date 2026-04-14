package domain;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int ID;
    private int numeroDePaginas;
    private boolean disponivel;

    {
        System.out.println("Novo livro sendo registrado...");
    }

    public Livro(){
        this.disponivel = true;
        System.out.println("Construtor vazio");
    }

    public Livro(String titulo, String autor, double preco, int numeroDePaginas, int ID){
        this();
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.ID = ID;
        this.numeroDePaginas = numeroDePaginas;
    }


    public void aplicarDesconto(double desconto){
        this.preco -= desconto;
    }

    public void aplicarDesconto(double desconto, String motivo){
        this.aplicarDesconto(desconto);
        System.out.println("Motivo: "+ motivo);
    }


    public double getValorTotal(){
        return preco;
    }


    public void imprime(){
        System.out.printf("ID: %04d%n", this.ID);
        System.out.println("Titulo: "+ this.titulo);
        System.out.println("Autor: "+ this.autor);
        System.out.printf("Preço: R$%.2f%n", this.preco);
        System.out.println("Status: "+ (this.disponivel ? "Disponível" : "Indisponível"));
        System.out.println("Numero de Paginas: "+ this.numeroDePaginas);
    }


    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
