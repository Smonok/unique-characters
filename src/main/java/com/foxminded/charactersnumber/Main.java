package com.foxminded.charactersnumber;

public class Main {

    public static void main(String[] args) {
        CharactersNumber charactersNumber = new CharactersNumber();
        String input = "hello world!";

        System.out.println("Input string: " + input + "\n" + charactersNumber.countUniqueCharacters(input));
        System.out.println("Input string: " + input + "\n" + charactersNumber.countUniqueCharacters(input));
    }
}
