package org.koberskym.ysoftdemo.controllers;

import org.koberskym.ysoftdemo.ciphers.Cipher;
import org.koberskym.ysoftdemo.ciphers.CipherFactory;
import org.koberskym.ysoftdemo.forms.CipherForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

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

    Cipher cipher = CipherFactory.getCipherById(cipherForm.getCipherName());

    if (cipher == null) {
      // log(cipher couldn't be found)
      throw new IllegalStateException("Cipher " + cipherForm.getCipherName() + " couldn't be found");
    }

    String newText;
    try {
      if (Objects.equals(action, "encrypt")) {
        newText = cipher.encrypt(cipherForm.getText());
      } else {
        newText = cipher.decrypt(cipherForm.getText());
      }
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
