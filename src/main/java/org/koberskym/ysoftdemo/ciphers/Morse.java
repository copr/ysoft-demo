package org.koberskym.ysoftdemo.ciphers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** */
public class Morse {

  private Map<String, String> dictionary = new HashMap<String, String>();

  public Morse() {
    initDictionary();
  }

  /**
   * @param toEncrypt
   * @return
   */
  public String encrypt(String toEncrypt) {
    return toEncrypt.codePoints()
        .mapToObj(c -> String.valueOf((char) c))
        .map(s -> s.toUpperCase())
        .map(s -> encryptCharacter(s))
        .collect(Collectors.joining(" "));
  }

  public String decrypt(String toDecrypt) {
    return toDecrypt;
  }

  private String encryptCharacter(String s) {
    assert(s.length() == 1);

    String encrypted = dictionary.get(s);
    if (encrypted == null) {
      throw new IllegalArgumentException("No encryption for: " + s);
    }
    return encrypted;

  }

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
