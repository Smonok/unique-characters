package com.foxminded.uniquecharacters;

public class Main {

    public static void main(String[] args) {
        CharactersCounter charactersNumber = new CharactersCounter();
        String input = "hello world!";

        System.out.println("Input string: " + input + "\n" + charactersNumber.countUniqueCharacters(input));
        System.out.println("Input string: " + input + "\n" + charactersNumber.countUniqueCharacters(input));
    }
}
