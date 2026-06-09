import java.util.List;

public class FrotaController {
    private List<Veiculo> memoriaFrota;
    private final VeiculoRepository repository;

    public FrotaController(VeiculoRepository repository) {
        this.repository = repository;
        this.memoriaFrota = repository.carregarTodos();
    }

    public void cadastrarCarro(String placa, String marca, String modelo, int portas) {
        Carro carro = new Carro(placa, marca, modelo, portas);
        memoriaFrota.add(carro);
        sincronizarRepositorio();
    }

    public void cadastrarCaminhao(String placa, String marca, String modelo, double carga) {
        Caminhao caminhao = new Caminhao(placa, marca, modelo, carga);
        memoriaFrota.add(caminhao);
        sincronizarRepositorio();
    }

    public List<Veiculo> listarFrota() {
        return List.copyOf(memoriaFrota); 
    }

    private void sincronizarRepositorio() {
        repository.salvarTodos(memoriaFrota);
    }
}
