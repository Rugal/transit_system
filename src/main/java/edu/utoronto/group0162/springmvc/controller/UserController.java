package edu.utoronto.group0162.springmvc.controller;

import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for index resources.
 *
 * @author Runzhuo Li
 */
@Controller
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Index.
   *
   * @param model
   *
   * @return
   */
  @RequestMapping("/")
  public String index(final Model model) {
    model.addAttribute("user", new User());
    return "index";
  }

  /**
   * Controller for login.
   *
   * @param input   user
   *
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(final @ModelAttribute User input) {
    final User user = this.userService.getDao()
      .findByEmailAndPassword(input.getEmail(), input.getPassword());
    final ModelAndView mav = new ModelAndView("profile");
    mav.addObject("user", user);
    return mav;
  }
}
