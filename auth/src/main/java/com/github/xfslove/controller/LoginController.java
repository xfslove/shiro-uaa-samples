package com.github.xfslove.controller;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;

/**
 * Created by hanwen on 2018/8/8.
 */
@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(
      @ModelAttribute(OAuth.OAUTH_CLIENT_ID) String clientId,
      @ModelAttribute(OAuth.OAUTH_REDIRECT_URI) String redirectURL,
      @ModelAttribute(OAuth.OAUTH_RESPONSE_TYPE) String responseType
  ) {
    return "login";
  }

  @RequestMapping(value = "/do-login", method = RequestMethod.GET)
  public String doLogin(
      RedirectAttributes redirectAttributes,
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam(OAuth.OAUTH_CLIENT_ID) String clientId,
      @RequestParam(OAuth.OAUTH_REDIRECT_URI) String redirectURL,
      @RequestParam(OAuth.OAUTH_RESPONSE_TYPE) String responseType
  ) {
    try {
      Subject subject = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken();
      token.setUsername(username);
      token.setPassword(password.toCharArray());
      subject.login(token);
      return "forward:/uaa-auth/authorize/approve";
    } catch (Exception e) {
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("error", "登录失败");
      String authParameters = "redirect_uri=" + URLEncoder.encode(redirectURL);
      authParameters += "&response_type=" + responseType;
      authParameters += "&client_id=" + clientId;
      return "redirect:/uaa-auth/authorize?" + authParameters;
    }
  }

}
