    import javax.swing.JTabbedPane;

public class Jtabbedpane extends JTabbedPane{
    public Jtabbedpane() {
        super();
        this.add("Calculadora1",new Calculadora1());
        this.add("Calculadora 2",new Calculadora2());
        this.add("Calculadora 3",new Calculadora3());
        
    }
    
}
