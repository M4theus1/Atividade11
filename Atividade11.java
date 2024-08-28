package Atividade12;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Classe que representa um Carro
class Carro {
    String modelo;
    String marca;
    int ano;
    double preco;

    // Construtor para criar um carro
    public Carro(String modelo, String marca, int ano, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
    }

    // Método para exibir o carro em formato de texto
    @Override
    public String toString() {
        return "Modelo: " + modelo + "\n" +
               "Marca: " + marca + "\n" +
               "Ano: " + ano + "\n" +
               "Preço: R$ " + preco + "\n";
    }
}

// Classe Principal onde o programa começa
public class Atividade11 {
    public static void main(String[] args) {
        Queue<Carro> filaDeCarros = new LinkedList<>();  // Criando uma fila para armazenar os carros
        Scanner scanner = new Scanner(System.in);

        while (true) {  // Laço de repetição para o menu
            System.out.println("\n1. Adicionar Carro");
            System.out.println("2. Remover Carro (Primeiro da fila)");
            System.out.println("3. Pesquisar Carro");
            System.out.println("4. Exibir Todos os Carros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do scanner

            if (opcao == 1) {
                // Adicionar um carro na fila
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Ano: ");
                int ano = scanner.nextInt();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();

                Carro novoCarro = new Carro(modelo, marca, ano, preco);
                filaDeCarros.add(novoCarro);  // Adiciona o carro na fila

            } else if (opcao == 2) {
                // Remover o carro do início da fila
                if (!filaDeCarros.isEmpty()) {
                    Carro removido = filaDeCarros.poll();  // Remove o primeiro carro da fila
                    System.out.println("Carro removido:\n" + removido);
                } else {
                    System.out.println("A fila está vazia.");
                }

            } else if (opcao == 3) {
                // Pesquisar um carro na fila pelo modelo
                System.out.print("Digite o modelo do carro a ser pesquisado: ");
                String modeloPesquisa = scanner.nextLine();
                boolean encontrado = false;
                for (Carro carro : filaDeCarros) {
                    if (carro.modelo.equalsIgnoreCase(modeloPesquisa)) {
                        System.out.println("Carro encontrado:\n" + carro);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Carro não encontrado.");
                }

            } else if (opcao == 4) {
                // Exibir todos os carros na fila
                if (filaDeCarros.isEmpty()) {
                    System.out.println("A fila está vazia.");
                } else {
                    for (Carro carro : filaDeCarros) {
                        System.out.println(carro);
                    }
                }

            } else if (opcao == 5) {
                // Sair do programa
                System.out.println("Saindo...");
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();  // Fecha o scanner
    }
}
