import javax.swing.JFrame;

public class Jframe extends JFrame {
    
   
public Jframe() {
        
       
super("Calculadoras");
        this.add(new JTabbedpane());
        // Defina as propriedades do frame
        this.setBounds(500, 250, 500, 500);
        
       
this.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        
       
this.setVisible(true);
    }
}