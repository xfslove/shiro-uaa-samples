package com.github.xfslove.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanwen on 2018/8/8.
 */
@Controller
public class ResourceController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
  public String welcome(
      Model model,
      HttpServletRequest request
  ) {
    model.addAttribute("redirect_uri", request.getRequestURL().toString());
    return "welcome";
  }

  @RequiresPermissions("perm1")
  @RequestMapping(value = "/view1", method = RequestMethod.GET)
  public String view1(
      Model model
  ) {
    model.addAttribute("username", SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
    return "view1";
  }

  @RequiresPermissions("perm2")
  @RequestMapping(value = "/view2", method = RequestMethod.GET)
  public String view2(
      Model model
  ) {
    model.addAttribute("username", SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
    return "view2";
  }

  @RequiresPermissions("perm3")
  @RequestMapping(value = "/view3", method = RequestMethod.GET)
  public String view3(
      Model model
  ) {
    model.addAttribute("username", SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
    return "view3";
  }

  @RequiresPermissions("perm4")
  @RequestMapping(value = "/view4", method = RequestMethod.GET)
  public String view4(
      Model model
  ) {
    model.addAttribute("username", SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
    return "view4";
  }
}
