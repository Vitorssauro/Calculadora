import javax.swing.JTabbedPane;

public class Jtabbedpane extends JTabbedPane{
    public Jtabbedpane() {
        super();
        this.add("Moeda",new CalcMoeda());
        this.add("Tempo",new Calculadora2());
        this.add("Temperatura",new CalculadoraTemperatura());
    }

}
