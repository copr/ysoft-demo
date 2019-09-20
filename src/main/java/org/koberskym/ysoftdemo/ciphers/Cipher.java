package org.koberskym.ysoftdemo.ciphers;

/**
 * Interface that all ciphers should implement.
 */
public interface Cipher {
  /**
   * Method that returns cipher's name, all the different implementations of the
   * Cipher interface should return unique name.
   * @return name of the cipher
   */
  String getName();

  /**
   * Method that encrypts string.
   * @param toEncrypt string to encrypt
   * @throws IllegalArgumentException when a character in the string can't be ecnrypted
   * @return encrypted string
   */
  String encrypt(String toEncrypt);

  /**
   * Method that decrypts given string.
   * @param toDecrypt string to be decrypted
   * @throws IllegalArgumentException when a character in the string can't be decrypted
   * @return decrypted string
   */
  String decrypt(String toDecrypt);
}
