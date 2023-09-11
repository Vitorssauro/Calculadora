import javax.swing.*;
import java.awt.*;

public class Calc extends JPanel{

    public Calc() {
        // Criando JFrame
        this.setBounds(800, 450, 350, 150);

        // panel primeira linha
        JPanel a = new JPanel();
        this.add(a);

        // JPanel segunda linha
        JPanel b = new JPanel();
        this.add(b);

        // JPanel só pro botão
        JPanel but = new JPanel();
        this.add(but);


        // setando o Layout
        GridLayout grid = new GridLayout(3, 3);
        this.setLayout(grid);// atribui o layout

        // Criar a label temperatura
        JLabel texto = new JLabel("Moeda : ");
        a.add(texto);

        // criar alguns componentes 1
        String[] temp1 = { "Real", "Dolar", "Euro", "Libra" };
        JComboBox<String> comboBox = new JComboBox<>(temp1);
        a.add(comboBox);

        // Criar a label ceonverter
        JLabel texto1 = new JLabel("Converter para : ");
        a.add(texto1);

        // criar componetntes para seleção de moeda
        String[] temp2 = { "Dolar", "Real", "Euro", "Libra" };
        JComboBox<String> comboBox1 = new JComboBox<>(temp2);
        a.add(comboBox1);

        // separador simples
        JLabel barra = new JLabel("  //  ");

        // Cria um botão JButton
        JButton button = new JButton("  Converter");

        // texto para digitar as temperaturasValor
        JTextField tempTexto1 = new JTextField(" Valor ", 10);
        JTextField tempTexto2 = new JTextField(" Valor ", 10);

        b.add(tempTexto1);
        b.add(barra);
        b.add(tempTexto2);

        but.add(button);

        // Configura a janela para ser visível
        this.setVisible(true);
    }
}
