package com.foxminded.charactersnumber;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharactersNumber {

    private final Map<String, Map<String, Integer>> cache = new HashMap<>();

    public Map<String, Integer> countUniqueCharacters(String original) {
        if (original == null) {
            throw new IllegalArgumentException();
        }

        if (cache.containsKey(original)) {
            return cache.get(original);
        }

        Map<String, Integer> charactersNumber = new LinkedHashMap<>();

        for (int i = 0; i < original.length(); i++) {
            String character = Character.toString(original.charAt(i));
            Integer number = calculateCharacterOccurrencesNumber(original, original.charAt(i));
            charactersNumber.put(character, number);
        }

        cache.put(original, charactersNumber);

        return charactersNumber;
    }

    private int calculateCharacterOccurrencesNumber(String original, char character) {
        return (int) original.chars().filter(symbol -> symbol == character).count();
    }
}
