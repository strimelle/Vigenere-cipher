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

        Image icon = new ImageIcon(getClass().getResource("/icon.png")).getImage();
        setIconImage(icon);

        createTitleSection();

        createInputSection();
        createButtonSection();
        createResultSection();
        setupButtonActions();

        setContentPane(panel);
        setVisible(true);

    }

    void createTitleSection(){

        c.insets = new Insets(6, 6, 6, 6);


        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        JLabel titleLabel = new JLabel("VIGENERE CIPHER");
        Font font = new Font("Monospaced", Font.BOLD, 20);
        titleLabel.setFont(font);
        panel.add(titleLabel, c);
        c.gridwidth = 1;


    }
void createInputSection(){

    c.insets = new Insets(6, 6, 6, 6);
    c.anchor = GridBagConstraints.EAST;

    c.gridx = 1;
    c.gridy = 1;
    JLabel word = new JLabel("WORD");
    Font font = new Font("Monospaced", Font.PLAIN, 18);
    word.setFont(font);
    panel.add(word, c);

    c.anchor = GridBagConstraints.WEST;
    c.gridx = 2; c.gridy = 1;
    panel.add(wordField, c);


    c.anchor = GridBagConstraints.EAST;
    c.gridx = 1;
    c.gridy = 2;
    JLabel key = new JLabel("KEY");


    key.setFont(font);
    panel.add(key, c);

    c.anchor = GridBagConstraints.WEST;
    c.gridx = 2;
    c.gridy = 2;
    panel.add(keyField, c);

}
void createButtonSection(){


    JPanel buttonPanel = new JPanel(new GridBagLayout());
    GridBagConstraints d = new GridBagConstraints();


    c.gridy = 6;
    c.gridx = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;


    d.insets = new Insets(12, 6, 6, 6);
    d.gridy = 1;
    d.gridx = 1;
    d.anchor = GridBagConstraints.EAST;
    buttonPanel.add(encryptBtn, d);



    d.insets = new Insets(12, 6, 6, 6);
    d.gridy = 1;
    d.gridx = 2;
    d.anchor = GridBagConstraints.WEST;
    buttonPanel.add(decryptBtn, d);

    panel.add(buttonPanel, c);


    c.gridwidth = 1;

}

String getWord(){
    String word = wordField.getText().trim();
    return word;

}
String getKey(){
    String key = keyField.getText().trim();
    return key;
}
//createResultSection() gale panel.add(messagePanel, d);
// naudoja tuos pačius d, kurie buvo skirti vidiniam messagePanel
// išdėstymui — reikia atskirti vidinius ir išorinius constraints.
void createResultSection(){
    JPanel messagePanel = new JPanel(new GridBagLayout());
    GridBagConstraints d = new GridBagConstraints();

    d.gridy = 10;
    d.gridx = 1;
    d.gridwidth = 2;
    d.anchor = GridBagConstraints.CENTER;

    //message labelis yra lokalus, todėl negali
    // jo vėliau atnaujinti klaidomis ar rezultatu.

    JLabel message = new JLabel("message");
    Font font = new Font("Monospaced", Font.PLAIN, 14);
    message.setFont(font);
    messagePanel.add(message, d);

    panel.add(messagePanel, d);

}

void setupButtonActions(){
    encryptBtn.addActionListener(e -> handleEncrypt());
    decryptBtn.addActionListener(e -> handleDecrypt());
}

//handleEncrypt() ir handleDecrypt()
// dabar tik iškviečia metodus, bet nieko neišsaugo į kintamuosius.
void handleEncrypt() {
    getWord();
    getKey();
    //new InputValidator(); ir new VigenereCipher(); vien sukuria
    // objektus, bet nekviečia jokių jų metodų.
    new InputValidator();
    new VigenereCipher();

    //handleEncrypt() turi:
    //
    //pasiimti word
    //pasiimti key
    //paleisti validaciją
    //jei blogai → rodyti message
    //jei gerai → kviesti šifravimą


}
void handleDecrypt() {
    getWord();
    getKey();
    //new InputValidator(); ir new VigenereCipher(); vien sukuria
    // objektus, bet nekviečia jokių jų metodų.
    new InputValidator();
    new VigenereCipher();

}
//Trūksta metodo, kuris parodytų žinutę lange, pvz. klaidą ar rezultatą.
//Trūksta metodo, kuris išvalytų seną žinutę prieš naują veiksmą.
}




