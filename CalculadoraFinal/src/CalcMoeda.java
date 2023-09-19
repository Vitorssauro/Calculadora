import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcMoeda extends JPanel {

    public CalcMoeda() {
        // Criando JFrame
        this.setBounds(600, 100, 350, 150);

        JLabel title = new JLabel("CALCULADORA DE MOEDA");
        Font tituloFonte = new Font("Arial", Font.BOLD, 16);
        title.setFont(tituloFonte);
        this.add(title);

        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o plano de fundo do painel principal como branco
        this.setBackground(Color.WHITE);

        // panel primeira linha
        JPanel a = new JPanel();
        a.setBackground(Color.WHITE); // Define o plano de fundo deste painel como branco
        this.add(a);

        // JPanel segunda linha
        JPanel b = new JPanel();
        b.setBackground(Color.WHITE); // Define o plano de fundo deste painel como branco
        this.add(b);

        // JPanel só pro botão
        JPanel but = new JPanel();
        but.setBackground(Color.WHITE); // Define o plano de fundo deste painel como branco
        this.add(but);

        // setando o Layout
        GridLayout grid = new GridLayout(5, 1);
        this.setLayout(grid); // atribui o layout

        // Criar a label temperatura
        JLabel texto = new JLabel("Moeda : ");
        a.add(texto);

        // criar alguns componentes 1
        String[] temp1 = { "Real", "Dolar", "Euro", "Libra" };
        JComboBox<String> comboBox = new JComboBox<>(temp1);
        a.add(comboBox);

        // Criar a label converter
        JLabel texto1 = new JLabel("Converter para : ");
        a.add(texto1);

        // criar componetntes para seleção de moeda
        String[] temp2 = { "Dolar", "Real", "Euro", "Libra" };
        JComboBox<String> comboBox1 = new JComboBox<>(temp2);
        a.add(comboBox1);

        // separador simples
        JLabel barra = new JLabel("  ==>  ");

        // Cria um botão JButton "Converter" com fundo branco e letras Arial
        JButton converterButton = new JButton(" Converter ");
        converterButton.setBackground(Color.BLUE); // Cor de fundo azul (como mencionado anteriormente)
        converterButton.setForeground(Color.WHITE); // Cor das letras branca (como mencionado anteriormente)
        converterButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Defina a fonte como Arial e o tamanho da fonte

        converterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para conversão
            }
        });

        // Cria um botão JButton "Limpar" com fundo branco e letras Arial
        JButton limparButton = new JButton(" Limpar ");
        limparButton.setBackground(Color.RED); // Cor de fundo vermelha (como mencionado anteriormente)
        limparButton.setForeground(Color.WHITE); // Cor das letras branca (como mencionado anteriormente)
        limparButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Defina a fonte como Arial e o tamanho da fonte

        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para limpar campos
            }
        });

        // texto para digitar as temperaturasValor
        JTextField tempTexto1 = new JTextField(" 0,00 ", 10);
        JTextField tempTexto2 = new JTextField(" 0,00 ", 10);

        b.add(tempTexto1);
        b.add(barra);
        b.add(tempTexto2);

        // Adicione os botões "Converter" e "Limpar" ao painel de botões
        but.add(converterButton);
        but.add(limparButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Calculadora de Moeda");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CalcMoeda());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
