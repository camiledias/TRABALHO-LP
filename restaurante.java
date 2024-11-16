import java.util.ArrayList;
import java.util.Scanner;

class Prato {

    String nome;
    String descricao;
     double preco;
     boolean disponivel;

    public Prato(String nome, String descricao, double preco, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    
     String getNome() { return nome; }
     String getDescricao() { return descricao; }
     double getPreco() { return preco; }
     boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$ " + preco + " (" + (disponivel ? "Disponível" : "Indisponível") + ")";
    }
}



class Pedido {
     ArrayList<Prato> pratos = new ArrayList<>();
     double valorTotal;

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
        valorTotal += prato.getPreco();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    @Override
    public String toString() {
        StringBuilder resumo = new StringBuilder("Pedido:\n");
        for (Prato prato : pratos) {
            resumo.append("- ").append(prato.getNome()).append("\n");
        }
        resumo.append("Valor total: R$ ").append(valorTotal);
        return resumo.toString();
    }
}




public class restaurante {
    private static ArrayList<Prato> cardapio = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerenciamento de Pedidos do restaurante ===");
            System.out.println("1. Cadastrar prato");
            System.out.println("2. Listar todos os pratos do cardápio");
            System.out.println("3. Consultar pratos disponíveis");
            System.out.println("4. Alterar status de um prato");
            System.out.println("5. Registrar pedido");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 :
                 cadastrarPrato(scanner);

                case 2 :
                 listarPratos();
                case 3 :
                consultarDisponiveis();
                
                case 4 :
                 alterarStatusPrato(scanner);
                
                 case 5 :
                 registrarPedido(scanner);
                
                 case 6 :
                 
                System.out.println("Fechando gerenciamento");
                
                default : System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

        scanner.close();
    }

    private static void cadastrarPrato(Scanner scanner) {
        System.out.print("Digite o nome do prato: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição do prato: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o preço do prato: ");
        double preco = scanner.nextDouble();   
        scanner.nextLine();

        /*Mudar true e false */

        System.out.print("O prato está disponível? (true/false): ");
        boolean disponivel = scanner.nextBoolean();
        scanner.nextLine(); 

        Prato prato = new Prato(nome, descricao, preco, disponivel);
        cardapio.add(prato);
        System.out.println("Prato cadastrado com sucesso!");
    }

    private static void listarPratos() {
        System.out.println("\n--- Cardápio Completo ---");
        for (Prato prato : cardapio) {
            System.out.println(prato);
        }
    }

    private static void consultarDisponiveis() {
        System.out.println("\n--- Pratos Disponíveis ---");
        for (Prato prato : cardapio) {
            if (prato.isDisponivel()) {
                System.out.println(prato);
            }
        }
    }

    private static void alterarStatusPrato(Scanner scanner) {
        System.out.print("Digite o nome do prato para alterar o status: ");
        String nome = scanner.nextLine();
        for (Prato prato : cardapio) {
            if (prato.getNome().equalsIgnoreCase(nome)) {
                prato.setDisponivel(!prato.isDisponivel());
                System.out.println("Status do prato '" + prato.getNome() + "' alterado para " + 
                                   (prato.isDisponivel() ? "Disponível" : "Indisponível"));
                return;
            }
        }
        System.out.println("Prato não encontrado!");
    }

    private static void registrarPedido(Scanner scanner) {
        Pedido pedido = new Pedido();
        while (true) {
            System.out.print("Digite o nome do prato para adicionar ao pedido (ou 'fim' para concluir): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) break;

            for (Prato prato : cardapio) {
                if (prato.getNome().equalsIgnoreCase(nome) && prato.isDisponivel()) {
                    pedido.adicionarPrato(prato);
                    System.out.println("Prato '" + prato.getNome() + "' adicionado ao pedido!");
                    break;
                }
            }
        }
        System.out.println("\n" + pedido);
    }
}
