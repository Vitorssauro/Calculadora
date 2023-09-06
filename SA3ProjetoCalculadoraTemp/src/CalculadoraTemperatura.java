import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTemperatura {
    private JTextField text;
    private JLabel resultadoLabel;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    public CalculadoraTemperatura() {
        // Cria uma janela Swing com FlowLayout
        JFrame frame = new JFrame("Conversor de Temperaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

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

        // Adiciona componentes à janela
        frame.add(new JLabel("Valor: "));
        frame.add(text);
        frame.add(comboBox1);
        frame.add(comboBox2);
        frame.add(converterButton);
        frame.add(resultadoLabel);

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
