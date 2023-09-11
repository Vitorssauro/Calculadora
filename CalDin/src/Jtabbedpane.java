import javax.swing.JTabbedPane;

public class Jtabbedpane extends JTabbedPane{
    public Jtabbedpane() {
        super();
        this.add("Calculadora 1",new Calc());
        this.add("Calculadora 2",new Calculadora2());
    }

}
