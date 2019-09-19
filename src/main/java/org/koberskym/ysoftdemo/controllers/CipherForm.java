package org.koberskym.ysoftdemo.controllers;

import org.koberskym.ysoftdemo.ciphers.CipherWrapper;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CipherForm {

  @NotNull
  private String cipherId;
  private String text;
  private String errorMessage;
  private List<CipherWrapper> ciphers;

  public CipherForm() {}

  public CipherForm(String cipherId, String text, String errorMessage, List<CipherWrapper> ciphers) {
    this.cipherId = cipherId;
    this.text = text;
    this.errorMessage = errorMessage;
    this.ciphers = ciphers;
  }

  public String getCipherId() {
    return cipherId;
  }

  public void setCipherId(String cipherId) {
    this.cipherId = cipherId;
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

  public List<CipherWrapper> getCiphers() {
    return ciphers;
  }

  public void setCiphers(List<CipherWrapper> ciphers) {
    this.ciphers = ciphers;
  }
}
