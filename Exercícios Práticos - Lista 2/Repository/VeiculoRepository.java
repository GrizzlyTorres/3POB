import java.util.List;

public interface VeiculoRepository {
    void salvarTodos(List<Veiculo> veiculos);
    List<Veiculo> carregarTodos();
}
