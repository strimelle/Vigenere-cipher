package org.example;

import javax.swing.*;
import java.awt.*;

public class VigenereUI extends JFrame {
    private final JTextField wordField = new JTextField(15);
    private final JTextField keyField = new JTextField(15);
    private final JButton encryptBtn = new JButton("ENCRYPT");
    private final JButton decryptBtn = new JButton("DECRYPT");
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();




    public VigenereUI(){

        createLayout();

    }
    void createLayout(){
        setTitle("Vigenere Cipher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,500);
        setLocationRelativeTo(null);

        createTitleSection();
        createInputSection();
        createButtonSection();

        setContentPane(panel);
        setVisible(true);

    }

    void createTitleSection(){

        c.insets = new Insets(6, 6, 6, 6);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0;
        c.gridy = 0;
        JLabel titleLabel = new JLabel("VIGENERE CIPHER");
        Font font = new Font("Monospaced", Font.BOLD, 20);
        titleLabel.setFont(font);
        panel.add(titleLabel, c);

    }
void createInputSection(){

    c.insets = new Insets(6, 6, 6, 6);
    c.anchor = GridBagConstraints.WEST;

    c.gridx = 0;
    c.gridy = 1;
    JLabel word = new JLabel("WORD");
    Font font = new Font("Monospaced", Font.PLAIN, 18);
    word.setFont(font);
    panel.add(word, c);

    c.gridx = 1; c.gridy = 1;
    panel.add(wordField, c);


    c.gridx = 0;
    c.gridy = 2;
    JLabel key = new JLabel("KEY");

    word.setFont(font);
    panel.add(key, c);

    c.gridx = 1;
    c.gridy = 2;
    panel.add(keyField, c);

}
void createButtonSection(){

    c.insets = new Insets(6, 6, 6, 6);
    c.anchor = GridBagConstraints.WEST;

    c.gridx = 0;
    c.gridy = 3;
    panel.add(encryptBtn, c);
    c.gridx = 1;
    c.gridy = 3;
    panel.add(decryptBtn, c);

}
/*
void createResultSection(){}
void clear(){}*/

}



