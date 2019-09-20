package org.koberskym.ysoftdemo.forms;

import org.koberskym.ysoftdemo.ciphers.Cipher;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * CipherForm is a backing bean for the frontend application. It contains everything
 * that is shown in the form that allows the user to encrypt or decrypt provided text.
 */
public class CipherForm {

  /**
   * cipherName specifiec which cipher to use for encryption/decryption
   */
  @NotNull
  private String cipherName;

  /**
   * text to be encrypted/decrypted
   */
  private String text;

  /**
   * possible error messages to be shown
   */
  private String errorMessage;

  /**
   * list of ciphers that user can use
   */
  private List<Cipher> ciphers;

  public CipherForm() {}

  public CipherForm(String cipherName, String text, String errorMessage, List<Cipher> ciphers) {
    this.cipherName = cipherName;
    this.text = text;
    this.errorMessage = errorMessage;
    this.ciphers = ciphers;
  }

  public String getCipherName() {
    return cipherName;
  }

  public void setCipherName(String cipherName) {
    this.cipherName = cipherName;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public List<Cipher> getCiphers() {
    return ciphers;
  }

  public void setCiphers(List<Cipher> ciphers) {
    this.ciphers = ciphers;
  }
}
