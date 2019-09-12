package org.koberskym.ysoftdemo.ciphers;

import org.jboss.logging.Param;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MorseTest {

  private Morse morse = new Morse();

  @ParameterizedTest
  @CsvFileSource(resources = {"/basic_morse.csv", "/complex_morse.csv"})
  void encrypt_correctResults(String in, String expected) {
    assertEquals(expected, morse.encrypt(in));
  }

  @ParameterizedTest
  @ValueSource(strings = {"š", "ě", "ř", "ž", "ý", "á"})
  void encrypt_exceptionThrown_unsupportedCharacters(String in) {
    assertThrows(IllegalArgumentException.class, () -> morse.encrypt(in));
  }


  @ParameterizedTest
  @CsvFileSource(resources = {"/basic_morse.csv", "/complex_morse.csv"})
  void decrypt(String expected, String in) {
    assertEquals(expected.toUpperCase(), morse.decrypt(in));
  }

  @ParameterizedTest
  @ValueSource(strings = {"........", "asdbcsd", "a", "b", "!!!", "???"})
  void descrypt_exceptionThrown_invalidCharacters(String in) {
    assertThrows(IllegalArgumentException.class, () -> morse.decrypt(in));
  }
}
