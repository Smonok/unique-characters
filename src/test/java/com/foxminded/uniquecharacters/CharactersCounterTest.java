package com.foxminded.uniquecharacters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.foxminded.uniquecharacters.CharactersCounter;

class CharactersCounterTest {

    private final CharactersCounter charactersNumber = new CharactersCounter();

    @Test
    void countUniqueCharactersShouldThrowIllegalArgumentExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> charactersNumber.countUniqueCharacters(null));
    }

    @Test
    void countUniqueCharactersShouldReturnEmptyMapWhenEmptyString() {
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countUniqueCharactersShouldReturnSpaceAndOneWhenSpace() {
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters(" ");

        expectedResult.put(" ", 1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countUniqueCharactersShouldCharacterAndOccurrencesNumberWhenSameCharacterSeveralTimes() {
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("aaaaa");

        expectedResult.put("a", 5);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countUniqueCharactersShouldReturnNumberOfUniqueCharactersWhenSeveralWords() {
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
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countUniqueCharactersShouldReturnCacheWhenSameStringSeveralTimes() {
        Map<String, Integer> expectedResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("hello");

        assertSame(actualResult, expectedResult);
    }

    @Test
    void countUniqueCharactersShouldThreeTimesFromCacheWhenSameStringFourTimes() {
        Map<String, Integer> actualResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> firstCacheResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> secondCacheResult = charactersNumber.countUniqueCharacters("hello");
        Map<String, Integer> thirdCacheResult = charactersNumber.countUniqueCharacters("hello");

        assertSame(actualResult, firstCacheResult);
        assertSame(firstCacheResult, secondCacheResult);
        assertSame(secondCacheResult, thirdCacheResult);
    }

    @Test
    void countUniqueCharactersShouldRecountForEachStringWhenDifferentStrings() {
        Map<String, Integer> firstActualResult = charactersNumber.countUniqueCharacters("hi");
        Map<String, Integer> secondActualResult = charactersNumber.countUniqueCharacters("welcome");
        Map<String, Integer> thirdActualResult = charactersNumber.countUniqueCharacters("hello");

        assertNotSame(firstActualResult, secondActualResult);
        assertNotSame(secondActualResult, thirdActualResult);
    }

    @Test
    void countUniqueCharactersShouldCountNewStringsAndCacheRepetitiveWhenDifferentAndSameStrings() {
        Map<String, Integer> firstActualResult = charactersNumber.countUniqueCharacters("hi");
        Map<String, Integer> secondActualResult = charactersNumber.countUniqueCharacters("welcome");
        Map<String, Integer> firstCacheResult = charactersNumber.countUniqueCharacters("hi");
        Map<String, Integer> secondCacheResult = charactersNumber.countUniqueCharacters("welcome");

        assertNotSame(firstActualResult, secondActualResult);
        assertSame(firstActualResult, firstCacheResult);
        assertSame(secondActualResult, secondCacheResult);
    }
}
