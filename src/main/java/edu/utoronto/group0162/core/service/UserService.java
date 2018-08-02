package edu.utoronto.group0162.core.service;

import edu.utoronto.group0162.core.dao.UserDao;
import edu.utoronto.group0162.core.entity.User;

import org.springframework.web.servlet.ModelAndView;

public interface UserService extends ServiceBase<UserDao> {

  /**
   * Go to profile page with all necessary data.
   *
   * @param uid user id
   *
   * @return MAV object
   */
  ModelAndView toProfile(Integer uid);

  /**
   * Go to profile page with all necessary data.
   *
   * @param user user
   *
   * @return MAV object
   */
  ModelAndView toProfile(User user);
}
