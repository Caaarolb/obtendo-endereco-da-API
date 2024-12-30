import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();

        int opcao;

        do {
            // Exibição do menu
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Buscar Endereço pelo CEP");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitura.nextInt();
            leitura.nextLine(); // Consumir o newline deixado pelo nextInt()

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do CEP: ");
                    var cep = leitura.nextLine();

                    try {
                        Endereco novoEndereco = consultaCep.buscarEndereco(cep);
                        System.out.println(novoEndereco);
                        GeradorDeArquivo gerador = new GeradorDeArquivo();
                        gerador.salvaJson(novoEndereco);
                    } catch (RuntimeException | IOException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Erro ao buscar o endereço.");
                    }
                    break;

                case 2:
                    showExitMessage();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);

        leitura.close();
    }

    // Método para exibir a mensagem de saída
    public static void showExitMessage() {
        System.out.println("\n" + "=".repeat(22) + " ✨🐱 Programa encerrado! 🐱✨ " + "=".repeat(20));
        System.out.println("Desenvolvido por: Jeisa Boaventura");
        System.out.println("GitHub: https://github.com/Caaarolb");
        System.out.println("LinkedIn: https://www.linkedin.com/in/-caroline-boaventura/");
        System.out.println("=" + "=".repeat(68) + "\n");
    }
}

