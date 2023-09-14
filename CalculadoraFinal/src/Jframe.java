import javax.swing.JFrame;

public class Jframe extends JFrame{
    public Jframe() {
        super("Calculadoras");
        this.add(new Jtabbedpane());
        //set frame
        this.setBounds(500, 250, 500, 500);
        this.setVisible(true);
    }
}
