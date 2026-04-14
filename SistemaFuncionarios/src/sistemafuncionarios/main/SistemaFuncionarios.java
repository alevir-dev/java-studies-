package sistemafuncionarios.main;

import sistemafuncionarios.dominio.Funcionario;

import java.util.Scanner;

public class SistemaFuncionarios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcaoMenu = 0;

        while (opcaoMenu != 5){
            System.out.println("1- Adicionar Funcionário");
            System.out.println("2- Listar Funcionário");
            System.out.println("3- Buscar Funcionário");
            System.out.println("4- Remover Funcionário");
            System.out.println("5- Sair");
            opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu){
                case 1:

            }



        }

    }
}
