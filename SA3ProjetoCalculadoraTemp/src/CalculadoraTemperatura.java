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
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno

        // Label e campo de valor
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Alinhamento à direita
        add(new JLabel("Valor:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        gbc.weightx = 1.0; // Peso horizontal (expansão)
        valorTextField = new JTextField("0.0", 10);
        add(valorTextField, gbc);

        // Label e combobox de escala de origem
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Escala de Origem:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        escalaOrigemComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        add(escalaOrigemComboBox, gbc);

        // Label e combobox de escala de destino
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Converter para:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        escalaDestinoComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        add(escalaDestinoComboBox, gbc);

        // Botão de conversão
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        gbc.anchor = GridBagConstraints.CENTER; // Alinhamento central
        JButton converterButton = new JButton("Converter");
        add(converterButton, gbc);

        // Configurando ação para o botão de conversão
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
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

            // Mostrar o resultado em uma nova janela de diálogo
            JOptionPane.showMessageDialog(this, "Resultado: " + resultado, "Resultado da Conversão", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Função para calcular a conversão de temperatura
    private double calcularConversao(double valor, String escalaOrigem, String escalaDestino) {
        // Adicione aqui suas fórmulas de conversão de temperatura
        // Por exemplo:
        if (escalaOrigem.equals("Celsius") && escalaDestino.equals("Fahrenheit")) {
            return (valor * 9 / 5) + 32;
        } else if (escalaOrigem.equals("Fahrenheit") && escalaDestino.equals("Celsius")) {
            return (valor - 32) * 5 / 9;
        } else if (escalaOrigem.equals("Celsius") && escalaDestino.equals("Kelvin")) {
            return valor + 273.15;
        }
        // Adicione mais casos conforme necessário
        return valor; // Retorna o mesmo valor se as escalas forem iguais
    }

    
}
