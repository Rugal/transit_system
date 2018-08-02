package edu.utoronto.group0162.core.service.impl;

import java.util.Optional;

import edu.utoronto.group0162.core.dao.UserDao;
import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.CardService;
import edu.utoronto.group0162.core.service.UserService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private CardService cardService;

  @Autowired
  @Getter
  private UserDao dao;

  /**
   * {@inheritDoc}
   */
  @Override
  public ModelAndView toProfile(final Integer uid) {
    final Optional<User> optionalUser = this.dao.findById(uid);
    return optionalUser.isPresent()
           ? this.toProfile(optionalUser.get())
           : new ModelAndView("error", "error", "User not found");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ModelAndView toProfile(final User user) {
    final ModelAndView mav = new ModelAndView("profile");
    mav.addObject("user", user);
    mav.addObject("cards", this.cardService.getDao().findByUser(user));
    return mav;
  }
}
