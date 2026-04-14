package service;

import domain.Livro;


public class BibliotecaService {
    private static final int ESTOQUE_MAXIMO = 20;

    Livro[] livros = new Livro[ESTOQUE_MAXIMO];
    int posicao = 0;


    public void adicionarLivro(String tituloLivro, String autorLivro, double precoLivro, int numeroDePaginasDoLivro){

        Livro livro = new Livro(tituloLivro, autorLivro, precoLivro, numeroDePaginasDoLivro, posicao + 1);

        livros[posicao] = livro;
        posicao++;

    }


    public void listarLivros(){
        for (int i = 0; i < posicao; i++){
            livros[i].imprime();
        }
    }

    public void buscarPorTitulo(String procurarTitulo){

        for (int i = 0; i < posicao; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(procurarTitulo)){
                livros[i].imprime();
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public void desconto(String titulo, double desconto){
        for (int i = 0; i < posicao; i++){
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)){
                livros[i].aplicarDesconto(desconto);
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public void removerLivroPorID(int ID){

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

        for (int i = indiceEncontrado; i < posicao; i++){
            livros[i] = livros[i + 1];
        }

        livros[posicao -1] = null;
        posicao--;

    }


    public void disponibilidade(String titulo, String disponivel){
        boolean estaDisponivel = disponivel.equalsIgnoreCase("S");



        for(int i =0; i < posicao; i++){
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)){
                livros[i].setDisponivel(estaDisponivel);
                return;
            }
        }

        System.out.println("Livro não encontrado");


    }





}
