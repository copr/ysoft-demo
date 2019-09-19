package org.koberskym.ysoftdemo.controllers;

import org.koberskym.ysoftdemo.ciphers.Cipher;
import org.koberskym.ysoftdemo.ciphers.CipherFactory;
import org.koberskym.ysoftdemo.ciphers.CipherWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class Index {
  @GetMapping("/")
  public String index(Model model) {
    initModel(model, "", "");
    return "index";
  }

  @PostMapping(value = "/")
  public String encrypt(@ModelAttribute @Valid CipherForm cipherForm,
                        BindingResult errors,
                        @RequestParam String action,
                        Model model) {

    if (errors.hasErrors()) {
      initModel(model, "", "Cipher not set");
      return "index";
    }

    CipherWrapper cipherWrapper = CipherFactory.getCipherById(cipherForm.getCipherId());

    if (cipherWrapper == null) {
      initModel(model, "", "");
      return "index";
    }

    Cipher cipher = cipherWrapper.getCipher();

    String newText;
    try {
      newText = cipher.encrypt(cipherForm.getText());
    } catch(IllegalArgumentException e) {
      newText = e.getMessage();
    }

    initModel(model, newText, "");

    return "index";
  }

  private void initModel(Model model, String newText, String errorMessage) {
    CipherForm cipherForm = new CipherForm("", newText, errorMessage, CipherFactory.getCiphers());
    model.addAttribute("cipherForm", cipherForm);
  }


}
