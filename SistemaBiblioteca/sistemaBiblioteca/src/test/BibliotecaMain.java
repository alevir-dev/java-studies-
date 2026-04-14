package test;


import service.BibliotecaService;

import java.util.Locale;
import java.util.Scanner;

public class BibliotecaMain {
    public static void main(String[] args) {

        BibliotecaService biblioteca = new BibliotecaService();

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        String tituloLivro;
        String autorLivro;
        double precoLivro;
        int numeroDePaginasLivro;
        int removerPorID;
        double adicionarDesconto;
        String disponibilidade;

        while (opcao != 0){
            System.out.println("===== SISTEMA DE BIBLIOTECA =====");
            System.out.println();
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Remover livro por ID");
            System.out.println("5 - Aplicar desconto");
            System.out.println("6 - Marcar disponibilidade");
            System.out.println("7 - Valor total do acervo");
            System.out.println("8 - Valor por livro");
            System.out.println("9 - Listar apenas livros disponíveis");
            System.out.println("10 - Listar apenas livros indisponíveis");
            System.out.println("11 - Buscar livro por autor");
            System.out.println("12 - Contar quantos livros tem no acervo");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao){
                case 1:
                    System.out.print("Digite o titulo do livro: ");
                    tituloLivro = sc.nextLine();
                    System.out.print("Digite o autor: ");
                    autorLivro = sc.nextLine();
                    System.out.print("Digite o preço do livro: ");
                    precoLivro = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Digite o numero de paginas do livro: ");
                    numeroDePaginasLivro = sc.nextInt();
                    sc.nextLine();

                    biblioteca.adicionarLivro(tituloLivro,autorLivro,precoLivro,numeroDePaginasLivro);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o titulo do livro: ");
                    tituloLivro = sc.nextLine();

                    biblioteca.buscarPorTitulo(tituloLivro);
                    break;
                case 4:
                    System.out.print("Digite o ID do livro para remover: ");
                    removerPorID = sc.nextInt();
                    sc.nextLine();

                    biblioteca.removerLivroPorID(removerPorID);
                    break;
                case 5:
                    System.out.println("Digite o titulo do livro");
                    tituloLivro = sc.nextLine();
                    System.out.print("Digite o desconto: ");
                    adicionarDesconto = sc.nextDouble();
                    sc.nextLine();
                    biblioteca.desconto(tituloLivro,adicionarDesconto);
                    break;
                case 6:
                    System.out.print("Digite o titulo do livro: ");
                    tituloLivro = sc.nextLine();
                    System.out.print("O livro está disponível (S/N) ?");
                    disponibilidade = sc.nextLine();

                    biblioteca.disponibilidade(tituloLivro, disponibilidade);
                    break;
                case 7:
                    biblioteca.valorTotalAcervo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha uma opção valida!");
                    break;
            }
        }











        sc.close();
    }
}