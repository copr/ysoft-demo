package org.koberskym.ysoftdemo.ciphers;

import org.jboss.logging.Param;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MorseTest {

  private Morse morse = new Morse();

  @ParameterizedTest
  @CsvSource({
      "a, .-",
      "e, .",
      "Morse Code, -- --- .-. ... . / -.-. --- -.. .",
      "I am so smart, .. / .- -- / ... --- / ... -- .- .-. -"
  })
  void encrypt_correctResults(String in, String expected) {
    assertEquals(expected, morse.encrypt(in));
  }

  @ParameterizedTest
  @ValueSource(strings = {"š", "ě", "ř", "ž", "ý", "á"})
  void encrypt_exceptionThrown_unsupportedCharacters(String in) {
    assertThrows(IllegalArgumentException.class, () -> morse.encrypt(in));
  }

  @ParameterizedTest
  @ValueSource(strings = {"a"})
  void encrypt_sameResults_differentCases(String in) {}

  @Test
  void decrypt() {}
}
