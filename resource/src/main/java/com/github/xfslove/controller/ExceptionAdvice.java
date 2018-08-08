package com.github.xfslove.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by hanwen on 2018/8/8.
 */
@ControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(AuthorizationException.class)
  public String handle(
      Model model,
      AuthorizationException e
  ) {
    String message = e.getMessage();
    model.addAttribute("message", message);
    return "error";
  }
}
