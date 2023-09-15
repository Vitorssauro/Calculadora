import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTemperatura extends JPanel {
    private JTextField valorTextField;
    private JComboBox<String> escalaOrigemComboBox;
    private JComboBox<String> escalaDestinoComboBox;

    public CalculadoraTemperatura() {
        // Configurar o layout do painel principal
        setBackground(Color.WHITE); // Define o fundo como branco
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno

        // Título em Arial com cor de fundo
        JLabel tituloLabel = new JLabel("Conversor de Temperaturas");
        Font tituloFonte = new Font("Arial", Font.BOLD, 16);
        tituloLabel.setFont(tituloFonte);
        tituloLabel.setOpaque(true); // Permite definir a cor de fundo
        tituloLabel.setBackground(Color.BLUE); // Define a cor de fundo
        tituloLabel.setForeground(Color.WHITE); // Define a cor do texto
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        gbc.anchor = GridBagConstraints.CENTER; // Alinhamento central
        add(tituloLabel, gbc);

        // Criação dos componentes
        JLabel temperaturaLabel = new JLabel("Valor:");
        escalaOrigemComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        JLabel converterLabel = new JLabel("Converter para:");
        escalaDestinoComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        // Botão "Converter" com cores de fundo e texto personalizados
        JButton converterButton = new JButton("Converter");
        converterButton.setBackground(Color.BLACK); // Define a cor de fundo do botão
        converterButton.setForeground(Color.WHITE); // Define a cor do texto do botão
        converterButton.setPreferredSize(new Dimension(150, 30)); // Define o tamanho do botão

        // Botão "Limpar" com cores de fundo e texto personalizados
        JButton limparButton = new JButton("Limpar");
        limparButton.setBackground(Color.RED); // Define a cor de fundo do botão
        limparButton.setForeground(Color.WHITE); // Define a cor do texto do botão
        limparButton.setPreferredSize(new Dimension(150, 30)); // Define o tamanho do botão

        valorTextField = new JTextField("0.0", 10);

        // Configuração das posições dos componentes usando GridBagConstraints
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(temperaturaLabel, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        add(valorTextField, gbc);

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(converterLabel, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        add(escalaOrigemComboBox, gbc);

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 3; // Linha 3
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(converterLabel, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        add(escalaDestinoComboBox, gbc);

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 4; // Linha 4
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(converterButton, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 4; // Linha 4
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(limparButton, gbc);

        // Configuração da ação do botão "Converter"
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
            }
        });

        // Configuração da ação do botão "Limpar"
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    // Método para converter temperatura
    private void converterTemperatura() {
        try {
            double valorInserido = Double.parseDouble(valorTextField.getText());
            String escalaOrigem = (String) escalaOrigemComboBox.getSelectedItem();
            String escalaDestino = (String) escalaDestinoComboBox.getSelectedItem();
            double resultado = calcularConversao(valorInserido, escalaOrigem, escalaDestino);

            // Exibir o resultado em uma janela de diálogo
            JOptionPane.showMessageDialog(this, "Resultado: " + resultado, "Conversão de Temperatura", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para calcular a conversão de temperatura
    private double calcularConversao(double valor, String escalaOrigem, String escalaDestino) {
        double resultado = 0.0;

        if (escalaOrigem.equals(escalaDestino)) {
            resultado = valor;
        } else if (escalaOrigem.equals("Celsius")) {
            if (escalaDestino.equals("Fahrenheit")) {
                resultado = (valor * 9 / 5) + 32;
            } else if (escalaDestino.equals("Kelvin")) {
                resultado = valor + 273.15;
            }
        } else if (escalaOrigem.equals("Fahrenheit")) {
            if (escalaDestino.equals("Celsius")) {
                resultado = (valor - 32) * 5 / 9;
            } else if (escalaDestino.equals("Kelvin")) {
                resultado = (valor - 32) * 5 / 9 + 273.15;
            }
        } else if (escalaOrigem.equals("Kelvin")) {
            if (escalaDestino.equals("Celsius")) {
                resultado = valor - 273.15;
            } else if (escalaDestino.equals("Fahrenheit")) {
                resultado = (valor - 273.15) * 9 / 5 + 32;
            }
        }

        return resultado;
    }

    // Método para limpar campos
    private void limparCampos() {
        valorTextField.setText("0.0");
        escalaOrigemComboBox.setSelectedIndex(0);
        escalaDestinoComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora de Temperatura");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CalculadoraTemperatura());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
