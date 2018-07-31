package edu.utoronto.group0162.core.service.impl;

import edu.utoronto.group0162.core.dao.UserDao;
import edu.utoronto.group0162.core.service.UserService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  @Getter
  private UserDao dao;
}
