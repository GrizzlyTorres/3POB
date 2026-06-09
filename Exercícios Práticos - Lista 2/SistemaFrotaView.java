import java.util.List;
import java.util.Scanner;

public class SistemaFrotaView {
    private final FrotaController controller;
    private final Scanner scanner;

    public SistemaFrotaView(FrotaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);
        
        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n--- Gestão de Frota Corporativa ---");
        System.out.println("1. Cadastrar Carro");
        System.out.println("2. Cadastrar Caminhão");
        System.out.println("3. Listar Frota");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processarOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1 -> fluxoCadastroCarro();
                case 2 -> fluxoCadastroCaminhao();
                case 3 -> fluxoListagemFrota();
                case 0 -> {} // Saída
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (DomainException e) {
            System.err.println("Erro de Validação: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

    private void fluxoCadastroCarro() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Número de portas: ");
        int portas = Integer.parseInt(scanner.nextLine());

        controller.cadastrarCarro(placa, marca, modelo, portas);
        System.out.println("Carro cadastrado com sucesso!");
    }

    private void fluxoCadastroCaminhao() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Capacidade de carga (Ton): ");
        double carga = Double.parseDouble(scanner.nextLine());

        controller.cadastrarCaminhao(placa, marca, modelo, carga);
        System.out.println("Caminhão cadastrado com sucesso!");
    }

    private void fluxoListagemFrota() {
        List<Veiculo> frota = controller.listarFrota();
        if (frota.isEmpty()) {
            System.out.println("A frota está vazia.");
            return;
        }

        System.out.println("\n--- Lista de Veículos ---");
        for (Veiculo v : frota) {
            String detalhes = String.format("[%s] %s %s - Placa: %s", 
                v.getClass().getSimpleName(), v.getMarca(), v.getModelo(), v.getPlaca());
            
            if (v instanceof Tributavel t) {
                detalhes += String.format(" | Imposto: R$ %.2f", t.calcularImposto());
            }
            
            System.out.println(detalhes);
        }
    }
}
