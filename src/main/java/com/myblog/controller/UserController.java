package com.myblog.controller;

import com.myblog.domain.User;
import com.myblog.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired private UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String insert(@RequestParam String username, @RequestParam String password) {
    return userService.insert(username, password);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public String update(
      @PathVariable int id, @RequestParam String username, @RequestParam String password) {
    return userService.update(id, username, password);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable int id) {
    return userService.delete(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<User> selectAll() {
    return userService.selectAll();
  }

  @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
  public User selectByName(@PathVariable String username) {
    return (User) userService.loadUserByUsername(username);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User selectByid(@PathVariable int id) {
    return userService.selectById(id);
  }

  @RequestMapping(value = "/{id}/role", method = RequestMethod.GET)
  public String getRoleById(@PathVariable int id) {
    return userService.getRoleById(id);
  }
}
