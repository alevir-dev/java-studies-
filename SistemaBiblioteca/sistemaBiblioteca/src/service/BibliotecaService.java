package service;

import domain.Livro;

import javax.swing.*;


public class BibliotecaService {
    private static final int ESTOQUE_MAXIMO = 100;

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
        System.out.println("Livro '"+tituloLivro+"' adicionado com sucesso!");

    }

    private boolean acervoVazio(){
        if (posicao == 0){
            System.out.println("Não há livros no acervo!");
            return true;
        }
        return false;
    }

    public void listarLivros(){

        if (acervoVazio()) return;

        for (int i = 0; i < posicao; i++){
            System.out.println("----------------------------------");
            livros[i].imprime();
        }
    }

    public void buscarPorTitulo(String procurarTitulo){

        if (acervoVazio()) return;

        for (int i = 0; i < posicao; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(procurarTitulo)){
                livros[i].imprime();
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public void buscarLivroPorID(int ID){
        if (acervoVazio()) return;

        for (int i = 0; i < posicao; i++){
            if (livros[i].getID() == ID){
                livros[i].imprime();
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }


    public void desconto(String titulo, double desconto){

        if (acervoVazio()) return;

        for (int i = 0; i < posicao; i++){
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)){
                livros[i].aplicarDesconto(desconto);
                System.out.println("Desconto de R$"+desconto+" aplicado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    public void removerLivroPorID(int ID){

        if (acervoVazio()) return;

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
        System.out.println("Livro removido com sucesso!");

    }


    public void disponibilidade(String titulo, String disponivel){

        if (acervoVazio()) return;

        boolean estaDisponivel = disponivel.equalsIgnoreCase("S");


        for(int i =0; i < posicao; i++){
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)){
                livros[i].setDisponivel(estaDisponivel);
                System.out.println("Disponibilidade do livro '"+titulo+"' atualizada com sucesso!");
                return;
            }
        }

        System.out.println("Livro não encontrado");

    }

    public void valorTotalAcervo(){

        if (acervoVazio()) return;

        double valorAcervo = 0;

        for (int i = 0; i < posicao; i++){
            valorAcervo += livros[i].getPreco();
        }

        System.out.printf("O valor total do acervo é de: R$%.2f%n", valorAcervo);
    }

    public void valorPorLivro(){
        if (acervoVazio()) return;

        for (int i =0; i < posicao; i++){
            System.out.println("__________________");
            System.out.println("Titulo: "+livros[i].getTitulo());
            System.out.printf("Valor: R$%.2f%n", livros[i].getPreco());
        }

    }

    public void listarLivrosDisponiveis(){

        if (acervoVazio()) return;

        boolean encontrou = false;

        for (int i = 0; i < posicao; i++){
            if (livros[i].isDisponivel()){
                if (!encontrou){
                    System.out.println("===== LIVROS DISPONÍVEIS =====");
                    encontrou = true;
                }
                livros[i].imprime();
                System.out.println("_____________________");
            }

        }
        if (!encontrou){
            System.out.println("Nenhum livro disponível no acervo!");
        }

    }

    public void listarLivrosIndisponiveis(){
        if (acervoVazio()) return;

        boolean encontrou = false;

        for (int i = 0; i < posicao; i++){
            if (!livros[i].isDisponivel()){

                if (!encontrou){
                    System.out.println("===== LIVROS INDISPONÍVEIS =====");
                    encontrou = true;
                }
                livros[i].imprime();
                System.out.println("_____________________");
            }
        }

        if (!encontrou){
            System.out.println("Nenhum livro indisponível no acervo!");
        }

    }

    public void listarLivrosPorAutor(String nomeAutor){

        if (acervoVazio()) return;

        boolean encontrou = false;

        for (int i = 0; i < posicao; i++){
            if (livros[i].getAutor().equalsIgnoreCase(nomeAutor)){
                if (!encontrou){
                    System.out.println("===== LIVROS DE "+ nomeAutor+" =====");
                    encontrou = true;
                }
                livros[i].imprime();
                System.out.println("_____________________");
            }
        }

        if (!encontrou){
            System.out.println("Autor não encontrado!");
        }

    }

    public void totalDeLivros(){

        if (acervoVazio()) return;

        System.out.println("Total de livros no acervo: " + posicao);
    }


    public void listarLivrosPorFaixaDePreco(double valorMinimo, double valorMaximo){

        if(acervoVazio()) return;

        boolean encontrou = false;

        for (int i = 0; i < posicao; i++){

            double preco = livros[i].getPreco();

            if (preco >= valorMinimo && preco <= valorMaximo){
                if (!encontrou){
                    System.out.printf("===== LIVROS ENTRE R$%.2f E R$%.2f =====%n", valorMinimo, valorMaximo);
                    encontrou = true;
                }

                livros[i].imprime();
                System.out.println("_____________________");
            }
        }

        if(!encontrou){
            System.out.println("Não há livros nessa faixa de preço");
        }

    }

    public void listarOrdenadoPorPreco(boolean crescente){

        if(acervoVazio()) return;

        Livro[] listarLivrosOrdenadosPorPreco = new Livro[posicao];

        for (int i = 0; i < posicao; i++){
            listarLivrosOrdenadosPorPreco[i] = livros[i];
        }

        for (int i = 0; i < posicao; i++) {
            for (int j = i + 1; j < posicao; j++) {

                if (
                        (crescente && listarLivrosOrdenadosPorPreco[i].getPreco() > listarLivrosOrdenadosPorPreco[j].getPreco()) ||
                                       (!crescente && listarLivrosOrdenadosPorPreco[i].getPreco() < listarLivrosOrdenadosPorPreco[j].getPreco())
                ) {

                    Livro temp = listarLivrosOrdenadosPorPreco[i];
                    listarLivrosOrdenadosPorPreco[i] = listarLivrosOrdenadosPorPreco[j];
                    listarLivrosOrdenadosPorPreco[j] = temp;
                }


            }


        }


        for(int i = 0; i < posicao; i++){
            listarLivrosOrdenadosPorPreco[i].imprime();
            System.out.println("_____________________");
        }


    }




}
