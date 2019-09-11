package org.koberskym.ysoftdemo.ciphers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MorseTest {

  @ParameterizedTest
  @ValueSource(strings = {"a", "A"})
  void encrypt(String in) {
    System.out.println(in);
  }

  @Test
  void decrypt() {}
}