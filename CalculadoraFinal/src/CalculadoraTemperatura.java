import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class CalculadoraTemperatura extends JPanel {
    private JTextField valorTextField;
    private JComboBox<String> escalaOrigemComboBox;
    private JComboBox<String> escalaDestinoComboBox;

    public CalculadoraTemperatura() {
        // Configurar o layout do painel principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // Define configurações de posicionamento
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno

               // Título em Arial
               JLabel tituloLabel = new JLabel("Calculadora de Temperaturas");
               Font tituloFonte = new Font("Arial", Font.BOLD, 16);
               tituloLabel.setFont(tituloFonte);
      
        // Configurações para o título
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        gbc.gridwidth = 3; // Ocupa 3 colunas (largura estendida)
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        gbc.anchor = GridBagConstraints.CENTER; // Alinhamento central
        add(tituloLabel, gbc);


        // Criação dos componentes
        JLabel temperaturaLabel = new JLabel("Valor:");
        JLabel origemLabel = new JLabel("De:");
        escalaOrigemComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        JLabel converterLabel = new JLabel("Para:");
        escalaDestinoComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        JButton converterButton = new JButton("Converter");
        JButton limparButton = new JButton("Limpar");
      


        // Aplicar estilo aos botões (mesmo estilo da Calculadora2)
        Font botaoFonte = new Font("Arial", Font.PLAIN, 16);
        converterButton.setFont(botaoFonte);
        limparButton.setFont(botaoFonte);

        // Definir largura preferencial para os botões (mesmo tamanho)
        Dimension botaoDimension = new Dimension(100, 30); // Largura: 100 pixels, Altura: 30 pixels
        converterButton.setPreferredSize(botaoDimension);
        limparButton.setPreferredSize(botaoDimension);

        // Adicionar borda aos botões
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        converterButton.setBorder(border);
        limparButton.setBorder(border);
            
        // Personalizar as cores dos botões
             converterButton.setBackground(Color.blue);
             converterButton.setForeground(Color.WHITE);
             limparButton.setBackground(Color.RED);
             limparButton.setForeground(Color.WHITE);
  // Personalizar o fundo do painel principal
  this.setBackground(Color.white);

        valorTextField = new JTextField("0.0", 10);

        // Configurações para os campos e rótulos
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(temperaturaLabel, gbc); // Rótulo "Valor"

        gbc.gridx = 1; // Coluna 1
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenchimento horizontal
        add(valorTextField, gbc); // Campo de texto

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(origemLabel, gbc); // Rótulo "De"

        gbc.gridx = 1; // Coluna 1
        gbc.gridwidth = 1; // Ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        escalaOrigemComboBox.setPreferredSize(new Dimension(100, 30)); // Defina o tamanho preferencial
        add(escalaOrigemComboBox, gbc); // JComboBox de origem

        gbc.gridx = 2; // Coluna 2
        add(converterLabel, gbc); // Rótulo "Para"

        gbc.gridx = 3; // Coluna 3
        escalaDestinoComboBox.setPreferredSize(new Dimension(100, 30)); // Defina o tamanho preferencial
        add(escalaDestinoComboBox, gbc); // JComboBox de destino

        // Painel para os botões Converter e Limpar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza os botões
        buttonPanel.setBackground(Color.WHITE);

        // Adicione os botões ao painel
        buttonPanel.add(converterButton);
        buttonPanel.add(limparButton);

        // Configurações para o painel de botões
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 3; // Linha 3
        gbc.gridwidth = 4; // Ocupa 4 colunas
        gbc.fill = GridBagConstraints.NONE; // Sem preenchimento
        add(buttonPanel, gbc);

        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
            }
        });

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

            // Concatene as unidades de temperatura ao resultado
            String unidadeOrigem = obterUnidade(escalaOrigem);
            String unidadeDestino = obterUnidade(escalaDestino);
            String mensagem = "Resultado: " + resultado + unidadeDestino;

            // Exibir o resultado em uma janela de diálogo
            JOptionPane.showMessageDialog(this, mensagem, "Conversão de Temperatura", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obter a unidade de temperatura com base na escala
    private String obterUnidade(String escala) {
        switch (escala) {
            case "Celsius":
                return "°C";
            case "Fahrenheit":
                return "°F";
            case "Kelvin":
                return "°K";
            default:
                return "";
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

   
}
