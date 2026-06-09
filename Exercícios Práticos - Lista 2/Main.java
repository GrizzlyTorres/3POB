public class Main {
    public static void main(String[] args) {       
        VeiculoRepository repository = new ArquivoVeiculoRepository();    
        FrotaController controller = new FrotaController(repository);     
        SistemaFrotaView view = new SistemaFrotaView(controller);
        
        view.iniciar();
    }
}
