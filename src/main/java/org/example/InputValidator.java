package org.example;



public class InputValidator {
    //basic word validation
    boolean validateWord(String word){
        if (word != null && !word.trim().isEmpty()) {
            return true;
        }

        return false;
    }


// ascii word validation
    boolean validateAsciiWord(String word){
        int asciiStart = 32;
        int asciiEnd = 126;
        if (word != null && !word.trim().isEmpty()) {
        for (int i = 0; i < word.length(); i++) {
            char currentWordChar = word.charAt(i);
            if (currentWordChar < asciiStart || currentWordChar > asciiEnd) {return false;}

        }
            return true;
        }

        return false;
    }



//basic key validation
    boolean validateKey (String key){
        if (key != null && !key.trim().isEmpty()) {
            for (int i = 0; i < key.length(); i++) {
                char currentKeyChar = key.charAt(i);
                if (currentKeyChar < 'a' || currentKeyChar > 'z') {return false;}

            }
            return true;
        }        return false;

    }
//ascii key validation
    boolean validateAsciiKey (String key){

        int asciiStart = 32;
        int asciiEnd = 126;
        if (key != null && !key.trim().isEmpty()) {
            for (int i = 0; i < key.length(); i++) {
                char currentKeyChar = key.charAt(i);
                if (currentKeyChar < asciiStart || currentKeyChar > asciiEnd) {return false;}

            }
            return true;
        }

        return false;

    }



}

