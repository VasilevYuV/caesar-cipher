package com.VasilevYuV.caesar_cipher.Services;

import org.springframework.stereotype.Service;

@Service
public class CaesarCipher {
    private static final int EN_ALPHABET_SIZE = 26;
    private static final int RU_ALPHABET_SIZE = 32;

    public String encrypt(String text, int key, String language) throws Exception {
        return processText(text, key, language, true);
    }

    public String decrypt(String text, int key, String language) throws Exception {
        return processText(text, key, language, false);
    }

    private String processText(String text, int key, String language, boolean encrypt) throws Exception {
        StringBuilder result = new StringBuilder();
        int actualKey = encrypt ? key : -key;
        int alphabetSize = "english".equals(language) ? EN_ALPHABET_SIZE : RU_ALPHABET_SIZE;

        if (actualKey < 0) {
            actualKey = alphabetSize + (actualKey % alphabetSize);
        }

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("english".equals(language)) {
                    if (isRussianLetter(c)) {
                        result.append(c);
                        continue;
                    }
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char processedChar = (char) (((c - base + actualKey) % EN_ALPHABET_SIZE + EN_ALPHABET_SIZE) % EN_ALPHABET_SIZE + base);
                    result.append(processedChar);
                } else {
                    if (isEnglishLetter(c)) {
                        result.append(c);
                        continue;
                    }
                    switch (c){
                        case 'Ё' -> c = 'Е';
                        case 'ё' -> c = 'е';
                    }
                    char base = Character.isUpperCase(c) ? 'А' : 'а';
                    char processedChar = (char) (((c - base + actualKey) % RU_ALPHABET_SIZE + RU_ALPHABET_SIZE) % RU_ALPHABET_SIZE + base);
                    result.append(processedChar);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private boolean isEnglishLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private boolean isRussianLetter(char c) {
        return (c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') || c == 'Ё' || c == 'ё';
    }
}
