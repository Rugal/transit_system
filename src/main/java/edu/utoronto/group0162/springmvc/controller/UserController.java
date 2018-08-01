package edu.utoronto.group0162.springmvc.controller;

import java.util.Optional;
import javax.validation.Valid;

import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.UserService;
import edu.utoronto.group0162.springmvc.dto.user.request.SignIn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for user resources.
 *
 * @author Rugal Bernstein
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
  @GetMapping
  public String index(final Model model) {
    model.addAttribute("signInUser", new SignIn());
    return "signin";
  }

  /**
   * Controller for login.
   *
   * @param signInUser    user
   * @param bindingResult result
   *
   * @return
   */
  @PostMapping(value = "/signin")
  public ModelAndView signin(final @Valid @ModelAttribute SignIn signInUser,
                             final BindingResult bindingResult) {

    final Optional<User> user = this.userService.getDao()
      .findByEmailAndPassword(signInUser.getEmail(), signInUser.getPassword());

    final ModelAndView mav;
    if (!user.isPresent()) {
      mav = new ModelAndView("error");
      mav.addObject("error", "Credential not match");
    } else {
      mav = new ModelAndView("profile");
      mav.addObject("user", user.get());
    }
    return mav;
  }
}
