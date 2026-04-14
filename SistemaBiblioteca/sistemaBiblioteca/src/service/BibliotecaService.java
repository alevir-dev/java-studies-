package service;

import domain.Livro;


public class BibliotecaService {
    private static final int ESTOQUE_MAXIMO = 20;

    private final Livro[] livros = new Livro[ESTOQUE_MAXIMO];
    private int posicao = 0;


    public void adicionarLivro(String tituloLivro, String autorLivro, double precoLivro, int numeroDePaginasDoLivro){

        if (posicao == ESTOQUE_MAXIMO){
            System.out.println("Acervo cheio!");
            return;
        }


        Livro livro = new Livro(tituloLivro, autorLivro, precoLivro, numeroDePaginasDoLivro, posicao + 1);

        livros[posicao] = livro;
        posicao++;

    }

    private boolean acervoVazio(){
        if (posicao == 0){
            System.out.println("Não há livros no acervo!");
            return true;
        }
        return false;
    }


    public void listarLivros(){

        if(acervoVazio()){
            return;
        }

        for (int i = 0; i < posicao; i++){
            livros[i].imprime();
        }
    }

    public void buscarPorTitulo(String procurarTitulo){

        if (acervoVazio()){
            return;
        }


        for (int i = 0; i < posicao; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(procurarTitulo)){
                livros[i].imprime();
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public void desconto(String titulo, double desconto){

        if (acervoVazio()){
            return;
        }

        for (int i = 0; i < posicao; i++){
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)){
                livros[i].aplicarDesconto(desconto);
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public void removerLivroPorID(int ID){

        if (acervoVazio()){
            return;
        }

        if (posicao == 0){
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        int indiceEncontrado = -1;

        for (int i = 0; i < posicao; i++){
            if (livros[i].getID() == ID) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1){
            System.out.println("Livro não encontrado!");
            return;
        }

        for (int i = indiceEncontrado; i < posicao -1; i++){
            livros[i] = livros[i + 1];
        }

        livros[posicao -1] = null;
        posicao--;

    }


    public void disponibilidade(String titulo, String disponivel){

        if (acervoVazio()){
            return;
        }

        boolean estaDisponivel = disponivel.equalsIgnoreCase("S");


        for(int i =0; i < posicao; i++){
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)){
                livros[i].setDisponivel(estaDisponivel);
                return;
            }
        }

        System.out.println("Livro não encontrado");

    }

    public void valorTotalAcervo(){

        if (acervoVazio()){
            return;
        }

        double valorAcervo = 0;

        for (int i = 0; i < posicao; i++){
            valorAcervo += livros[i].getPreco();
        }

        System.out.println("O valor total do acervo é de: R$"+valorAcervo);
    }




}
