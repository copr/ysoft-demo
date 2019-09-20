package org.koberskym.ysoftdemo.ciphers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherFactory {
  private static Map<String, Cipher> cipherMap = new HashMap<>();

  static {
    Cipher morse = new Morse();
    cipherMap.put(morse.getName(), morse);
  }

  private CipherFactory() {}

  public static List<Cipher> getCiphers() {
    return new ArrayList<>(cipherMap.values());
  }

  public static Cipher getCipherById(String id) {
    return cipherMap.get(id);
  }
}
