package sistemafuncionarios.servico;

import sistemafuncionarios.dominio.Funcionario;

public class FuncionarioService {

    private final int TAMANHO_MAXIMO = 10;

    private final Funcionario[] funcionarios = new Funcionario[TAMANHO_MAXIMO];
    private int posicao = 0;


    public void adicionarFuncionario(String nome, int idade, String cargo){

        if (posicao == TAMANHO_MAXIMO){
            System.out.println("Limite de funcionários atingido!");
            return;
        }

        if (nome.isBlank() ||cargo.isBlank()){
            System.out.println("O nome e o cargo não podem estar vazios!");
            return;
        }

        if(idade <= 0){
            System.out.println("Digite uma idade válida!");
            return;
        }

        Funcionario funcionario = new Funcionario(nome,idade,cargo);

        funcionarios[posicao] = funcionario;
        posicao++;

        System.out.println("Funcionário adicionado com sucesso!");
    }

    public void listarFuncionarios(){

        if (arrayVazio()) return;

        for (int i = 0; i < posicao; i++){
            funcionarios[i].imprime();
        }

    }

    public void listarFuncionariosPorIdade(boolean crescente){

        if (arrayVazio()) return;

        Funcionario[] ordenados = new Funcionario[posicao];

        for (int i = 0; i < posicao; i++){
            ordenados[i] = funcionarios[i];
        }

        for (int i  = 0; i < posicao; i++){
            for (int j = i + 1; j < posicao; j++){
                boolean foraDeOrdem = crescente
                        ? ordenados[i].getIdade() > ordenados[j].getIdade()
                        : ordenados[i].getIdade() < ordenados[j].getIdade();

                if (foraDeOrdem){

                    Funcionario temp = ordenados[i];
                    ordenados[i] = ordenados[j];
                    ordenados[j] = temp;
                }
            }
        }

        for (Funcionario imprimir : ordenados){
            imprimir.imprime();
        }
    }

    public void buscarFuncionario(String funcionario){

        if (arrayVazio()) return;

        for (int i = 0; i < posicao; i++){
            if (funcionarios[i].getNome().equalsIgnoreCase(funcionario)){
                System.out.println("Funcionario "+funcionarios[i].getNome()+" Encontrado!");
                funcionarios[i].imprime();
                return;
            }
        }

        System.out.println("Funcionario "+funcionario +" não encontrado!");
    }

    public void removerFuncionario(String funcionario){

        if (arrayVazio()) return;

        int encontrado = -1;

        for (int i = 0; i < posicao; i++) {
            if(this.funcionarios[i].getNome().equalsIgnoreCase(funcionario)){
                encontrado = i;
                break;
            }
        }

        if (encontrado == -1){
            System.out.println("Funcionario não encontrado!");
            return;
        }

        for (int i = encontrado; i < posicao - 1; i++){
            this.funcionarios[i] = this.funcionarios[i + 1];
        }

        this.funcionarios[posicao - 1] = null;
        posicao--;

        System.out.println("Funcionario removido com sucesso!");

    }


    public void editarFuncionario(String nomeFuncionario, String editarNomeFuncionario) {

        if (arrayVazio()) return;

        for (int i = 0; i < posicao; i++) {
            if (funcionarios[i].getNome().equalsIgnoreCase(nomeFuncionario)) {
                funcionarios[i].setNome(editarNomeFuncionario);
                return;
            }
        }

        System.out.println("Funcionário não encontrado!");

    }
        private boolean arrayVazio (){
            if (posicao == 0) {
                System.out.println("Nenhum funcionário adicionado");
                return true;
            }
            return false;
        }
}
