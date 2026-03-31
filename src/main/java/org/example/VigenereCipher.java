package org.example;

public class VigenereCipher {

    private final char[] basicAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final int asciiStart = 32;
    private final int asciiEnd = 126;
    private final int asciiRange = asciiEnd - asciiStart + 1;


    private int getAlphabetIndex (char ch){
        for(int i = 0; i < basicAlphabet.length; i++){
            if (basicAlphabet[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    //VigenereCipher klasėje dar turi atsirasti bent:
//
//šifravimo metodas
// basic
    String encryptBasic(String word, String key){
        word = word.toLowerCase();
        key = key.toLowerCase();
        int keyIndex = 0;
        StringBuilder encResult = new StringBuilder();
        int n = basicAlphabet.length;

        for(int i = 0; i < word.length(); i++){
            char currentWordChar = word.charAt(i);

            int keyPosition = keyIndex % key.length();
            char currentKeyChar = key.charAt(keyPosition);

            int mi = getAlphabetIndex(currentWordChar);
            int ki = getAlphabetIndex(currentKeyChar);

            if(mi == -1){
                encResult.append(currentWordChar);

            }else{
                int ci = (mi + ki) % n;
                char encryptedChar = basicAlphabet[ci];
                encResult.append(encryptedChar);
                keyIndex++;
            }
        }

        return encResult.toString();

    }
    //ASCII
    String encryptAscii(String word, String key){

        int keyIndex = 0;
        StringBuilder encResult = new StringBuilder();

        for(int i = 0; i < word.length(); i++){
            char currentWordChar = word.charAt(i);
            int keyPosition = keyIndex % key.length();
            char currentKeyChar = key.charAt(keyPosition);

            int mi = currentWordChar - asciiStart;
            int ki = currentKeyChar - asciiStart;

            if(currentWordChar >= asciiStart && currentWordChar <= asciiEnd) {

                int ci = (mi + ki) % asciiRange;
                char encryptedChar = (char) (ci + asciiStart);
                encResult.append(encryptedChar);
                keyIndex++;
            }else{encResult.append(currentWordChar);}

        }

        return encResult.toString();
    }


    //dešifravimo metodas
//basic
    String decryptBasic(String word, String key){
        word = word.toLowerCase();
        key = key.toLowerCase();
        int keyIndex = 0;
        StringBuilder decResult = new StringBuilder();

        int n = basicAlphabet.length;

        for(int i = 0; i < word.length(); i++){
            char currentWordChar = word.charAt(i);

            int keyPosition = keyIndex % key.length();
            char currentKeyChar = key.charAt(keyPosition);

            int ci = getAlphabetIndex(currentWordChar);
            int ki = getAlphabetIndex(currentKeyChar);

            if(ci == -1){
                decResult.append(currentWordChar);

            }else{
                int mi = (ci - ki + n) % n;
                char decryptedChar = basicAlphabet[mi];
                decResult.append(decryptedChar);
                keyIndex++;
            }
        }

        return decResult.toString();
    }

    //ASCII
    String decryptAscii(String word, String key){

        int keyIndex = 0;
        StringBuilder decResult = new StringBuilder();

        for(int i = 0; i < word.length(); i++){
            char currentWordChar = word.charAt(i);
            int keyPosition = keyIndex % key.length();
            char currentKeyChar = key.charAt(keyPosition);

            int ci = currentWordChar - asciiStart;
            int ki = currentKeyChar - asciiStart;

            if(currentWordChar >= asciiStart && currentWordChar <= asciiEnd) {

                int mi = (ci - ki + asciiRange) % asciiRange;
                char decryptedChar = (char) (mi + asciiStart);
                decResult.append(decryptedChar);
                keyIndex++;
            }else {decResult.append(currentWordChar);}

        }

        return decResult.toString();
    }


}
