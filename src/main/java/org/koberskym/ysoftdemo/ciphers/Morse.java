package org.koberskym.ysoftdemo.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implementation of encryption and decryption algorithms from/to morse code.
 */
public class Morse implements Cipher {

  /**
   * dictionary that is used to translate string to/from morse code
   */
  private BiMap<String, String> dictionary = HashBiMap.create();

  public Morse() {
    initDictionary();
  }

  @Override
  public String getName() {
    return "Morse";
  }

  /**
   * Encrypts given string to morse code.
   * @param toEncrypt - string to be encrypted. Allowed characters are a-Z, 0-9, also ".',
   *                  ",", "?", "=" and space.
   * @Throws IllegalArgumentException when there is a character that can not be encoded.
   * @return given string as morse code.
   */
  @Override
  public String encrypt(String toEncrypt) {
    return toEncrypt.codePoints()
        .mapToObj(c -> String.valueOf((char) c))
        .map(String::toUpperCase)
        .map(this::encryptCharacter)
        .collect(Collectors.joining(" "));
  }

  /**
   * Decrypts given string. Resulting string is in uppercase as there's no way to know
   * what was the case of original string.
   * @param toDecrypt string to be decrypted can only contain dots and dashes for each
   *                  character. Individual characters are to be separated by spaces
   *                  and individual words are to be separated by "/".
   * @Throws IllegalArgumentException when there is a character that can not be decoded.
   * @return uppercase decryption from given morse code.
   */
  @Override
  public String decrypt(String toDecrypt) {
    return Arrays.stream(toDecrypt.split(" "))
        .filter(s -> !s.equals(" "))
        .map(this::decryptCharacter)
        .collect((Collectors.joining()));

  }

  /**
   * Decrypts one sequence of dots and dashes to uppercase letter or a symbol. E.g ".-" is decrypted to "E".
   * @param s string representing one sequence of dots and dashes.
   * @throws IllegalArgumentException if the string does not represent one morse alphabet character.
   * @return uppercase letter or symbol
   */
  private String decryptCharacter(String s) {
    String decrypted = dictionary.inverse().get(s);
    if (decrypted == null) {
      throw new IllegalArgumentException("No decryption for: " + s);
    }
    return decrypted;
  }

  /**
   * Encrypts one character to morse code.
   * @param s  must be of lenght one and represents character to be encrypted.
   * @throws IllegalArgumentException when character can not be encrypted.
   * @return character encrypted in morse code
   */
  private String encryptCharacter(String s) {
    assert(s.length() == 1);

    String encrypted = dictionary.get(s);
    if (encrypted == null) {
      throw new IllegalArgumentException("No encryption for: " + s);
    }
    return encrypted;

  }

  /**
   * Initializes morse code dictionary.
   */
  private void initDictionary() {
    dictionary.put("A", ".-");
    dictionary.put("B", "-...");
    dictionary.put("C", "-.-.");
    dictionary.put("D", "-..");
    dictionary.put("E", ".");
    dictionary.put("F", "..-.");
    dictionary.put("G", "--.");
    dictionary.put("H", "....");
    dictionary.put("I", "..");
    dictionary.put("J", ".---");
    dictionary.put("K", "-.-");
    dictionary.put("L", ".-..");
    dictionary.put("M", "--");
    dictionary.put("N", "-.");
    dictionary.put("O", "---");
    dictionary.put("P", ".--.");
    dictionary.put("Q", "--.-");
    dictionary.put("R", ".-.");
    dictionary.put("S", "...");
    dictionary.put("T", "-");
    dictionary.put("U", "..-");
    dictionary.put("V", "...-");
    dictionary.put("W", ".--");
    dictionary.put("X", "-..-");
    dictionary.put("Y", "-.--");
    dictionary.put("Z", "--..");
    dictionary.put("0", "-----");
    dictionary.put("1", ".----");
    dictionary.put("2", "..---");
    dictionary.put("3", "...--");
    dictionary.put("4", "....-");
    dictionary.put("5", ".....");
    dictionary.put("6", "-....");
    dictionary.put("7", "--...");
    dictionary.put("8", "---..");
    dictionary.put("9", "----.");
    dictionary.put(".", ".-.-.-");
    dictionary.put(",", "--..--");
    dictionary.put("?", "..--..");
    dictionary.put("=", "-...-");
    dictionary.put(" ", "/");
  }
}
