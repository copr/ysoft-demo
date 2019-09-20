package org.koberskym.ysoftdemo.forms;

import org.koberskym.ysoftdemo.ciphers.Cipher;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CipherForm {

  @NotNull
  private String cipherName;
  private String text;
  private String errorMessage;
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
