package org.koberskym.ysoftdemo.ciphers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherFactory {
  private static Map<String, CipherWrapper> cipherMap = new HashMap<>();

  static {
    CipherWrapper morse = new CipherWrapper("morse", "Morse", new Morse());
    cipherMap.put(morse.getId(), morse);

    CipherWrapper kaisar = new CipherWrapper("kaisar", "Kaisar", null);
    cipherMap.put(kaisar.getId(), kaisar);
  }

  public static List<CipherWrapper> getCiphers() {
    return new ArrayList<CipherWrapper>(cipherMap.values());
  }

  public static CipherWrapper getCipherById(String id) {
    return cipherMap.get(id);
  }
}
