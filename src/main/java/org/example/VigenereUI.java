package org.example;

import javax.swing.*;
import java.awt.*;



public class VigenereUI extends JFrame {
    private final JTextField wordField = new JTextField(15);
    private final JTextField keyField = new JTextField(15);
    private final JButton encryptBtn = new JButton("ENCRYPT");
    private final JButton decryptBtn = new JButton("DECRYPT");
    private final JLabel messageLabel = new JLabel("");
    private final ButtonGroup modeGroup = new ButtonGroup();
    private final JRadioButton basic = new JRadioButton("BASIC");
    private final JRadioButton ascii = new JRadioButton("ASCII");
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
        createModeSection();
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
void createModeSection(){
    JPanel modePanel = new JPanel(new GridBagLayout());
    GridBagConstraints m = new GridBagConstraints();


    c.gridy = 6;
    c.gridx = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;

    m.insets = new Insets(12, 6, 6, 6);
    m.gridy = 1;
    m.gridx = 1;
    m.anchor = GridBagConstraints.EAST;
    Font font = new Font("Monospaced", Font.PLAIN, 14);
    basic.setFont(font);

    modeGroup.add(basic);
    modePanel.add(basic, m);

    m.insets = new Insets(12, 6, 6, 6);
    m.gridy = 1;
    m.gridx = 2;
    m.anchor = GridBagConstraints.WEST;
    ascii.setFont(font);

    modeGroup.add(ascii);
    modePanel.add(ascii, m);

    basic.setSelected(true);

    panel.add(modePanel, c);



}
void createButtonSection(){


    JPanel buttonPanel = new JPanel(new GridBagLayout());
    GridBagConstraints d = new GridBagConstraints();


    c.gridy = 8;
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

void createResultSection(){
    JPanel messagePanel = new JPanel(new GridBagLayout());
    GridBagConstraints d = new GridBagConstraints();
    preferredSize(350);
    d.gridy = 10;
    d.gridx = 0;
    d.gridwidth = 2;
    d.anchor = GridBagConstraints.CENTER;
    clearMessage();


    Font font = new Font("Monospaced", Font.PLAIN, 14);
    messageLabel.setFont(font);
    messagePanel.add(messageLabel, d);

    panel.add(messagePanel, d);

}

void setupButtonActions(){
    encryptBtn.addActionListener(e -> handleEncrypt());
    decryptBtn.addActionListener(e -> handleDecrypt());
}
void getSelectedMode(){

}


void handleEncrypt() {
    clearMessage();
    String word = getWord();
    String key = getKey();

    InputValidator valid = new InputValidator();
    boolean wordValid = valid.validateWord(word);
    boolean keyValid = valid.validateKey(key);

    if(!wordValid && !keyValid){
        showMessage("Word and key are empty or invalid!");    return;}
    else if(!wordValid){
        showMessage("Word is empty or invalid!");    return;}
    else if(!keyValid){
        showMessage("Key is empty or invalid!");    return;}
    else{VigenereCipher cipher = new VigenereCipher();
        showMessage(cipher.encryptBasic(word, key));}


}
void handleDecrypt() {
    clearMessage();
    String word = getWord();
    String key = getKey();

    InputValidator valid = new InputValidator();
    boolean wordValid = valid.validateWord(word);
    boolean keyValid = valid.validateKey(key);

    if(!wordValid && !keyValid){
        showMessage("Word and key are empty or invalid!"); return;}
    else if(!wordValid){
        showMessage("Word is empty or invalid!");    return;}
    else if(!keyValid){
        showMessage("Key is empty or invalid!");    return;}
    else {
        VigenereCipher cipher = new VigenereCipher();
        showMessage(cipher.decryptBasic(word, key));

    }



}
void showMessage(String text){
        messageLabel.setText(text);
}

void clearMessage(){
    showMessage(" ");
}

}





