package org.example;

public class InputValidator {
    boolean validateWord(String word){
        if (word != null && !word.trim().isEmpty()) {
            return true;
        }
        return false;
    }
    boolean validateKey(String key){
        if (key != null && !key.trim().isEmpty()){return true;}
        return false;
    }

}

