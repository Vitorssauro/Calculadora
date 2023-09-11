import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTemperatura {
    private JTextField text;
    private JLabel resultadoLabel;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    public CalculadoraTemperatura() {
        // Cria uma janela Swing
        JFrame frame = new JFrame("Conversor de Temperaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel para organizar os componentes usando GridLayout
        JPanel panel = new JPanel(new GridLayout(0, 1)); // Uma coluna, várias linhas

        text = new JTextField(10);
        resultadoLabel = new JLabel("Resultado: ");

        // ComboBox 1 para escolher a escala de temperatura de origem
        String[] escalas1 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox1 = new JComboBox<>(escalas1);

        // ComboBox 2 para escolher a escala de temperatura de destino
        String[] escalas2 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox2 = new JComboBox<>(escalas2);

        // Botão de conversão
        JButton converterButton = new JButton("Converter");
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
            }
        });

        // Botão "Apagar"
        JButton apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(""); // Limpa o campo de texto
                resultadoLabel.setText("Resultado: "); // Redefine o rótulo de resultado
            }
        });

        // Painel para botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(converterButton);
        buttonPanel.add(apagarButton);

        // Adiciona componentes ao painel principal
        panel.add(new JLabel("Valor: "));
        panel.add(text);
        panel.add(comboBox1);
        panel.add(comboBox2);
        panel.add(buttonPanel); // Adiciona o painel de botões
        panel.add(resultadoLabel);

        // Adiciona o painel à janela
        frame.add(panel, BorderLayout.CENTER);

        // Configurações finais da janela
        frame.pack();
        frame.setVisible(true);
    }

    private void converterTemperatura() {
        try {
            double valorInserido = Double.parseDouble(text.getText());
            double resultado = 0.0;
            String escalaSelecionada1 = (String) comboBox1.getSelectedItem();
            String escalaSelecionada2 = (String) comboBox2.getSelectedItem();

            if (escalaSelecionada1.equals(escalaSelecionada2)) {
                resultadoLabel.setText("Resultado: " + valorInserido);
                return;
            }

            // Converte a temperatura da escala de origem para a escala de destino
            if (escalaSelecionada1.equals("Celsius")) {
                resultado = converterCelsius(valorInserido, escalaSelecionada2);
            } else if (escalaSelecionada1.equals("Fahrenheit")) {
                resultado = converterFahrenheit(valorInserido, escalaSelecionada2);
            } else if (escalaSelecionada1.equals("Kelvin")) {
                resultado = converterKelvin(valorInserido, escalaSelecionada2);
            }

            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(resultadoLabel, "Insira um valor válido.");
        }
    }

    // Funções de conversão de temperatura
    private double converterCelsius(double valor, String escalaDestino) {
        if (escalaDestino.equals("Fahrenheit")) {
            return (valor * 9 / 5) + 32;
        } else if (escalaDestino.equals("Kelvin")) {
            return valor + 273.15;
        }
        return valor;
    }

    private double converterFahrenheit(double valor, String escalaDestino) {
        if (escalaDestino.equals("Celsius")) {
            return (valor - 32) * 5 / 9;
        } else if (escalaDestino.equals("Kelvin")) {
            return (valor - 32) * 5 / 9 + 273.15;
        }
        return valor;
    }

    private double converterKelvin(double valor, String escalaDestino) {
        if (escalaDestino.equals("Celsius")) {
            return valor - 273.15;
        } else if (escalaDestino.equals("Fahrenheit")) {
            return (valor - 273.15) * 9 / 5 + 32;
        }
        return valor;
    }

    
}
