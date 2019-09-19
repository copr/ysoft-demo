package org.koberskym.ysoftdemo.ciphers;

public class CipherWrapper {
  private String id;
  private String name;
  private Cipher cipher;

  public CipherWrapper(String id, String name, Cipher cipher) {
    this.id = id;
    this.name = name;
    this.cipher = cipher;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Cipher getCipher() {
    return cipher;
  }

  public void setCipher(Cipher cipher) {
    this.cipher = cipher;
  }
}
