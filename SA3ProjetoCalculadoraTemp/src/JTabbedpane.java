import javax.swing.JTabbedPane;

public class JTabbedpane extends JTabbedPane {
    public JTabbedpane() {
        super();
        this.add("Conversor de Temperaturas", new CalculadoraTemperatura());
    }
}
