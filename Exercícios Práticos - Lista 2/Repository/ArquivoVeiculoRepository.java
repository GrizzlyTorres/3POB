import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoVeiculoRepository implements VeiculoRepository {
    private static final String NOME_ARQUIVO = "frota.txt";

    @Override
    public void salvarTodos(List<Veiculo> veiculos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Veiculo veiculo : veiculos) {
                writer.write(veiculo.formatarParaArquivo());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar dados no disco: " + e.getMessage());
        }
    }

    @Override
    public List<Veiculo> carregarTodos() {
        List<Veiculo> veiculos = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO);
        
        if (!arquivo.exists()) return veiculos;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                veiculos.add(converterLinhaParaVeiculo(linha));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar dados do disco: " + e.getMessage());
        }
        return veiculos;
    }

    private Veiculo converterLinhaParaVeiculo(String linha) {
        String[] dados = linha.split(";");
        String tipo = dados[0];
        
        if (tipo.equals("CARRO")) {
            return new Carro(dados[1], dados[2], dados[3], Integer.parseInt(dados[4]));
        } else if (tipo.equals("CAMINHAO")) {
            return new Caminhao(dados[1], dados[2], dados[3], Double.parseDouble(dados[4].replace(",", ".")));
        }
        throw new IllegalArgumentException("Tipo de veículo desconhecido no arquivo.");
    }
}
