import java.util.Scanner;
import java.util.ArrayList;


class Prato { 
    String nome;
    String descricao;
    boolean status;
    double preco;
   

    public Prato(String nome, String descricao, double preco,boolean status){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;

    }

    String getNome() {return nome;}
    String getDescricao() {return descricao;}
    double getPreco() {return preco;}
    boolean isStatus() {return status;}

    public void setStatus(boolean status) {
        this.status = status;
        
    }
    

    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$ " + preco + " (" + (status ? "Disponível" : "Indisponível") + ")";
    }


}



class Pedido {
    ArrayList<Prato> pratos = new ArrayList<>();
    Double valorTotal;

    public void adicionarPrato(Prato prato){
        pratos.add(prato);
        this.valorTotal += prato.getPreco();
    }

    public double getValorTotal(){
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


public class restaurante1 {
    public static ArrayList<Prato> cardapio = new ArrayList<>();
 


public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int op;


    do{
        System.out.println("\n=== Gerenciamento de Pedidos do restaurante ===");
        System.out.println("1. Cadastrar prato");
        System.out.println("2. Listar todos os pratos do cardápio");
        System.out.println("3. Consultar pratos disponíveis");
        System.out.println("4. Alterar status de um prato");
        System.out.println("5. Registrar pedido");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        op = scanner.nextInt();
        scanner.nextLine(); 

        switch (op) {
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

        


    } while(op != 6); 
    
    scanner.close();
}

public static void cadastrarPrato(Scanner scanner) {

    System.out.print("Digite o nome do prato: ");
    String nome = scanner.nextLine();

    System.out.print("Digite a descrição do prato: ");
    String descricao = scanner.nextLine();

    System.out.print("Digite o preço do prato: ");
    double preco = scanner.nextDouble();   
    scanner.nextLine();

    System.out.print("O prato está disponível? (true = sim /false = não): ");
        boolean status = scanner.nextBoolean();
        scanner.nextLine(); 

        Prato prato = new Prato(nome, descricao, preco, status);
        cardapio.add(prato);
        System.out.println("Prato cadastrado com sucesso!");
    
}

private static void consultarDisponiveis() {
    System.out.println("\n--- Pratos Disponíveis ---");
    for (Prato prato : cardapio) {
        if (prato.isStatus()) {
            System.out.println(prato);
        }
    }
}









public static void listarPratos() {
    System.out.println("\n--- Cardápio ---");
    for (Prato prato : cardapio) {
        System.out.println(prato);
    }
}

private static void alterarStatusPrato(Scanner scanner) {
    System.out.print("Digite o nome do prato para alterar o status: ");
    String nome = scanner.nextLine();
    for (Prato prato : cardapio) {
        if (prato.getNome().equalsIgnoreCase(nome)) {
            prato.setStatus(!prato.isStatus());
            System.out.println("Status do prato '" + prato.getNome() + "' alterado para " + 
                               (prato.isStatus() ? "Disponível" : "Indisponível"));
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
            if (prato.getNome().equalsIgnoreCase(nome) && prato.isStatus()) {
                pedido.adicionarPrato(prato);
                System.out.println("Prato '" + prato.getNome() + "' adicionado ao pedido!");
                break;
            }
        }
    }
    System.out.println("\n" + pedido);
}



   

}





















































































 /*menu:
       while (true) {
        System.out.println("1.Cadastrar prato  \n2.Verificar pratos disponiveis \n3.Fazer pedido \n5.Sair");


        switch (op) {
            case 1:
             System.out.println("Digite o nome do  prato que deseja cadatrar:");
             String nome = scan.nextLine();


             if (pratos.contains(nome)) {
                System.out.println("Esse prato já existe ");

                break;

             }
             else{

             System.out.println("Escreva uma descrição sobre o prato: ");
             String descricao = scan.nextLine();
             System.out.println("Insira o preço do prato: "); 
             double preco = scan.nextDouble();
             Prato prato = new Prato(nome, descricao, preco,"Disponível");

             System.out.println("Prato cadastrado com sucesso!");
             pratos.add(prato);
             
            
        }
        System.out.println("Lista de pratos: \n" + pratos);

    
     
                break;
             
             
                case 2:
               
       

                break menu;
    
            default:
                break;






                
    }
    

    }
}
 */