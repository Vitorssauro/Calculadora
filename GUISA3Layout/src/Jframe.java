import javax.swing.JFrame;

public class Jframe extends JFrame{
    public Jframe() {
        super("Calculadoras");
        this.add(new Jtabbedpane());
        // set frame
        this.setBounds(400, 250, 400, 400);
        this.setVisible(true);
    }
    
}
