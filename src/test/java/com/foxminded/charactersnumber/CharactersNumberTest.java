package com.foxminded.charactersnumber;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.foxminded.charactersnumber.CharactersNumber;

class CharactersNumberTest {

    @Test
    void countUniqueCharactersShouldThrowIllegalArgumentExceptionWhenNull() {
        CharactersNumber charactersNumber = new CharactersNumber();

        assertThrows(IllegalArgumentException.class, () -> {
            charactersNumber.countUniqueCharacters(null);
        });
    }

    @Test
    void countUniqueCharactersShouldReturnEmptyMapWhenEmptyString() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("");

        assertEquals(actualResult, expectedResult);
    }

    @Test
    void countUniqueCharactersShouldReturnSpaceAndOneWhenSpace() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters(" ");

        expectedResult.put(" ", 1);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void countUniqueCharactersShouldCharacterAndOccurrencesNumberWhenSameCharacterSeveralTimes() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("aaaaa");

        expectedResult.put("a", 5);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void countUniqueCharactersShouldReturnNumberOfUniqueCharactersWhenSeveralWords() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("hello world!");

        expectedResult.put("h", 1);
        expectedResult.put("e", 1);
        expectedResult.put("l", 3);
        expectedResult.put("o", 2);
        expectedResult.put(" ", 1);
        expectedResult.put("w", 1);
        expectedResult.put("r", 1);
        expectedResult.put("d", 1);
        expectedResult.put("!", 1);
        assertEquals(actualResult, expectedResult);
    }
}
