package org.koberskym.ysoftdemo.ciphers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherFactory {
  private static Map<String, Cipher> cipherMap = new HashMap<>();

  static {
    addCipher(new Morse());
  }

  private CipherFactory() {}

  public static List<Cipher> getCiphers() {
    return new ArrayList<>(cipherMap.values());
  }

  public static Cipher getCipherById(String id) {
    return cipherMap.get(id);
  }

  public static void addCipher(Cipher cipher) {
    if (cipher == null) {
      throw new IllegalArgumentException("Cipher object must not be null");
    }
    cipherMap.put(cipher.getName(), cipher);
  }
}
