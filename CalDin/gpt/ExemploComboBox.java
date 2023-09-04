import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploComboBox {

    public ExemploComboBox() {
        // Cria uma janela JFrame
        JFrame frame = new JFrame("Exemplo JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Cria um painel JPanel
        JPanel panel = new JPanel();
        frame.add(panel);

        // Cria um rótulo JLabel
        JLabel label = new JLabel("Selecione uma cor:");
        panel.add(label);

        // Cria um JComboBox com algumas cores
        String[] cores = {"Vermelho", "Verde", "Azul", "Amarelo"};
        JComboBox<String> comboBox = new JComboBox<>(cores);
        panel.add(comboBox);

        // Cria um botão JButton
        JButton button = new JButton("Selecionar");
        panel.add(button);

        // Cria um rótulo para exibir a cor selecionada
        JLabel corSelecionada = new JLabel("");
        panel.add(corSelecionada);

        // Adiciona um ouvinte de ação ao botão
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cor = (String) comboBox.getSelectedItem();
                corSelecionada.setText("Cor selecionada: " + cor);
            }
        });

        // Configura a janela para ser visível
        frame.setVisible(true);
    }
}