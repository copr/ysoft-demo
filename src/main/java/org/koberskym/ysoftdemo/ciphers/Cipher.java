package org.koberskym.ysoftdemo.ciphers;

public interface Cipher {
  String encrypt(String toEncrypt);
  String decrypt(String toDecrypt);
}
