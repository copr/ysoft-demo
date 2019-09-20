package org.koberskym.ysoftdemo.ciphers;

public interface Cipher {
  String getName();
  String encrypt(String toEncrypt);
  String decrypt(String toDecrypt);
}
