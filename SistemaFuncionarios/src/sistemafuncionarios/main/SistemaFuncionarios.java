package sistemafuncionarios.main;

import sistemafuncionarios.dominio.Funcionario;
import sistemafuncionarios.servico.FuncionarioService;

import java.util.Scanner;

public class SistemaFuncionarios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FuncionarioService funcionarioService = new FuncionarioService();

        int opcao = 1;
        String nomeFuncionario;
        int idadeFuncionario;
        String cargoFuncionario;

        while (opcao != 0){
            System.out.println("1 - Adicionar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Buscar funcionário");
            System.out.println("4 - Remover funcionário");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.println("Escolha uma opção!");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao){
                case 1:
                    System.out.print("Digite o nome do funcionário: ");
                    nomeFuncionario = sc.nextLine();
                    System.out.print("Digite a idade do funcionário: ");
                    idadeFuncionario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o cargo o funcionário: ");
                    cargoFuncionario = sc.nextLine();
                    funcionarioService.adicionarFuncionario(nomeFuncionario,idadeFuncionario,cargoFuncionario);
                    break;
                case 2:
                    funcionarioService.listarFuncionarios();
                    break;
                case 3:
                    System.out.print("Digite o nome do funcionario: ");
                    nomeFuncionario = sc.nextLine();

                    funcionarioService.buscarFuncionario(nomeFuncionario);
                    break;
                case  4:
                    System.out.print("Digite o nome do funcionario: ");
                    nomeFuncionario = sc.nextLine();

                    funcionarioService.removerFuncionario(nomeFuncionario);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;

            }
        }

    }
}
