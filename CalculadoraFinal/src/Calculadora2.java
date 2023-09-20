import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculadora2 extends JPanel {
    public Calculadora2() {
        super();
        this.setLayout(new GridBagLayout()); /* Usei um grid layout porquê ele foi o que se 
        enquandrou melhor no meu layout e nos codígos*/
        GridBagConstraints gbc = new GridBagConstraints(); // define configurações de posicionamento
        gbc.insets = new Insets(3, 3, 3, 3); // usei esse codigo para ajudar com o espaçamento  entre os campos
        

        JLabel titleLabel = new JLabel("Calculadora de Tempo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; // Aqui ele específica em qual coluna o componente será colocado
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        this.add(titleLabel, gbc);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JTextField textFieldHora = new JTextField();
        JTextField textFieldMinuto = new JTextField();
        JTextField textFieldSegundo = new JTextField();
        textFieldSegundo.setEditable(false);

        //adicionando os campos 
        panel.add(new JLabel("Horas:")); // Aqui adicionei a Coluna de Horas
        panel.add(textFieldHora);
        panel.add(new JLabel("Minutos:")); // Aqui adicionei a Coluna de Minutos
        panel.add(textFieldMinuto);
        panel.add(new JLabel("Segundos:")); // Aqui adicionei a Coluna de Segundos
        panel.add(textFieldSegundo);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        this.add(panel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton converterButton = new JButton("Converter"); // Aqui adicionei um botão de converter
        converterButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Usei uma fonte de palavra "Arial", e usei um tamanho 16
        converterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*  Adicionei um try cat para pegar erros entre a operação quando for
                 calculada, EX: Ao colocar um texto ou colocar numeros na coluna minuto ele dará ERRO*/
                try {
                    int horas = Integer.parseInt(textFieldHora.getText());
                    int minutos = 0;
                    if (!textFieldMinuto.getText().isEmpty()) {
                        minutos = Integer.parseInt(textFieldMinuto.getText());
                    }
                    int totalMinutos = horas * 60 ;
                    int segundos = totalMinutos * 60;
                    textFieldMinuto.setText(String.valueOf(totalMinutos));
                    textFieldSegundo.setText(String.valueOf(segundos));
                } catch (NumberFormatException ex) {
                    textFieldMinuto.setText("Erro");
                    textFieldSegundo.setText("Erro");
                }
            }
        });

        JButton limparButton = new JButton("Limpar"); // Aqui adicionei um Botão de Limpar
        limparButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Usei  uma fonte "Arial", e de um tamanho 16
    
        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldHora.setText(""); // Aqui são as colunas de texto para digitar
                textFieldMinuto.setText(""); // Aqui são as colunas de texto para digitar
                textFieldSegundo.setText(""); // Aqui são as colunas de texto para digitar
            }
        });
        
        //set do panel 
        buttonPanel.add(converterButton);
        buttonPanel.add(limparButton);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(buttonPanel, gbc);
   
converterButton.setBackground(Color.BLUE); // Define a cor de fundo do botão "Converter" como amarelo
converterButton.setForeground(Color.WHITE); // Define a cor do texto do botão "Converter" como preto
limparButton.setBackground(Color.RED); // Define a cor de fundo do botão "Limpar" como laranja
limparButton.setForeground(Color.WHITE); // Define a cor do texto do botão "Limpar" como preto
 // Personalizar o fundo do painel principal
 this.setBackground(Color.white);
buttonPanel.setBackground(Color.WHITE);
panel.setBackground(Color.WHITE);
    }


}
