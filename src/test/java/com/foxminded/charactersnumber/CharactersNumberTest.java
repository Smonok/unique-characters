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

        assertThrows(IllegalArgumentException.class, () -> charactersNumber.countUniqueCharacters(null));
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

    @Test
    void countUniqueCharactersShouldReturnCacheWhenSameStringSeveralTimes() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> expectedResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("hello");

        assertSame(actualResult, expectedResult);
    }

    @Test
    void countUniqueCharactersShouldThreeTimesFromCacheWhenSameStringFourTimes() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> firstCacheResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> secondCachelResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> thirdCacheResult = charactersNumber.countUniqueCharacters("hello");

        assertSame(actualResult, firstCacheResult);
        assertSame(firstCacheResult, secondCachelResult);
        assertSame(secondCachelResult, thirdCacheResult);
    }

    @Test
    void countUniqueCharactersShouldRecountForEachStringWhenDifferentStrings() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> firstActualResult = charactersNumber.countUniqueCharacters("hi");
        Map<String, Integer> secondActualResult = charactersNumber.countUniqueCharacters("welcome");
        Map<String, Integer> thirdActualResult = charactersNumber.countUniqueCharacters("hello");

        assertNotSame(firstActualResult, secondActualResult);
        assertNotSame(secondActualResult, thirdActualResult);
    }

    @Test
    void countUniqueCharactersShouldCountNewStringsAndCacheRepetitiveWhenDifferentAndSameStrings() {
        CharactersNumber charactersNumber = new CharactersNumber();
        Map<String, Integer> firstActualResult = charactersNumber.countUniqueCharacters("hi");
        Map<String, Integer> secondActualResult = charactersNumber.countUniqueCharacters("welcome");
        Map<String, Integer> firstCacheResult = charactersNumber.countUniqueCharacters("hi");
        Map<String, Integer> secondCachelResult = charactersNumber.countUniqueCharacters("welcome");

        assertNotSame(firstActualResult, secondActualResult);
        assertSame(firstActualResult, firstCacheResult);
        assertSame(secondActualResult, secondCachelResult);
    }
}
