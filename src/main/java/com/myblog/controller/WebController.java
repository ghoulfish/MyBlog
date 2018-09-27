package com.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @RequestMapping(value = "/user")
  public String user() {
    return "user";
  }

  @RequestMapping(value = "/admin")
  public String admin() {
    return "admin";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }
}
