package com.myblog.domain.service;

import com.myblog.domain.User;
import com.myblog.domain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.myblog.Constant.userRole;

@Service
public class UserService implements UserDetailsService {

  @Autowired private UserMapper userMapper;

  public String insert(String username, String password) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setRole(userRole);
    userMapper.insert(user);
    return "User " + user.getUsername() + " register success!";
  }

  public String update(int id, String username, String password) {
    User user = new User();
    user.setId(id);
    user.setUsername(username);
    user.setPassword(password);
    return userMapper.update(user) + " records updated!";
  }

  public String delete(int id) {
    return userMapper.delete(id) + " records deleted!";
  }

  public List<User> selectAll() {
    return userMapper.selectAll();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userMapper.selectByName(username);
    if (user != null) {
      return user;
    } else {
      throw new UsernameNotFoundException("Not valid username");
    }
  }

  public User selectById(int id) {
    return userMapper.selectById(id);
  }

  public String getRoleById(int id) {
    return userMapper.getRoleById(id);
  }
}
