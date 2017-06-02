package com.mycompany.interviews;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This class is a JUnit class which you can run to check if AnagramGame is working correctly.
 * Running it is not part of the code test and if you are not familiar with JUnit,
 * please make sure you complete the test before trying to set it up.
 */
class AnagramGameTest {

    private IWordDictionary dictionary;
    private IAnagramGame game;

	@BeforeEach
    public void setUp() {
        //dictionary = new WordDictionary();
        dictionary = mock(WordDictionary.class);
        game = new AnagramGame("areallylongword", dictionary);
    }

	@Test
    public void afterDictionaryIsLoaded_wordsAreEvaluatedCorrectly() {
        verify(dictionary, timeout(4500)).load(this::checkIfWordsAreEvaluatedCorrectly);
        dictionary.load(this::checkIfWordsAreEvaluatedCorrectly);
    }

    private void checkIfWordsAreEvaluatedCorrectly(List wordList) {
        assertEquals(2, game.evaluateWord("no"));
        assertEquals(4, game.evaluateWord("grow"));
        assertEquals(0, game.evaluateWord("bold"));
        assertEquals(0, game.evaluateWord("glly"));
        assertEquals(6, game.evaluateWord("woolly"));
        assertEquals(0, game.evaluateWord("adder"));
    }
/*
	@Test(timeout=2000)
    public void wordsSubmittedBeforeDictionaryIsLoaded_areNotDiscarded() {
        game.submitWord("no");
        game.submitWord("grow");
        game.submitWord("bold");
        game.submitWord("glly");
        game.submitWord("woolly");
        game.submitWord("adder");
        Async.handleEvent(this, dictionary, "loaded", checkIfWordsWereSubmittedCorrectly, 15000);
        dictionary.load();

    }

    private void checkIfWordsWereSubmittedCorrectly(event : Event, passThroughObject : Object) {
        assertHighscoreEntry(0, "woolly", 6);
        assertHighscoreEntry(1, "grow", 4);
        assertHighscoreEntry(2, "no", 2);
    }

    private void assertHighscoreEntry (int index, String expectedWord, int expectedScore) {
        assertEquals(expectedWord, game.getWordAtPosition(index));
        assertEquals(expectedScore, game.getScoreAtPosition(index));
    }
*/
}