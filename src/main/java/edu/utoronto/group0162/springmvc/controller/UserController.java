package edu.utoronto.group0162.springmvc.controller;

import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import config.SystemDefaultProperty;

import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.CardService;
import edu.utoronto.group0162.core.service.UserService;
import edu.utoronto.group0162.springmvc.dto.user.UserMapper;
import edu.utoronto.group0162.springmvc.dto.user.request.SignIn;
import edu.utoronto.group0162.springmvc.dto.user.request.SignUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private CardService cardService;

  private ModelAndView toProfile(final Integer uid) {
    final Optional<User> optionalUser = this.userService.getDao().findById(uid);
    return optionalUser.isPresent()
           ? this.toProfile(optionalUser.get())
           : new ModelAndView("error", "error", "User not found");
  }

  private ModelAndView toProfile(final User user) {
    final ModelAndView mav = new ModelAndView("profile");
    mav.addObject("user", user);
    mav.addObject("cards", this.cardService.getDao().findByUser(user));
    return mav;
  }

  /**
   * Index.
   *
   * @param session HTTP session
   *
   * @return
   */
  @GetMapping(path = {"/", "/signin", "/**"})
  public ModelAndView signIn(final HttpSession session) {
    final Integer uid = (Integer) session.getAttribute(SystemDefaultProperty.UID);
    if (Objects.isNull(uid)) {
      return new ModelAndView("signin", "user", new SignIn());
    }
    return new ModelAndView(String.format("redirect:/user/%d", uid));
  }

  /**
   * Controller for sign in.
   *
   * @param signInUser user
   * @param session    HTTP session
   *
   * @return
   */
  @PostMapping(value = "/signin")
  public ModelAndView signIn(final @Valid @ModelAttribute SignIn signInUser,
                             final HttpSession session) {
    final Optional<User> optionalUser = this.userService.getDao()
      .findByEmailAndPassword(signInUser.getEmail(), signInUser.getPassword());

    final ModelAndView mav;
    if (!optionalUser.isPresent()) {
      mav = new ModelAndView("error");
      mav.addObject("error", "Credential not match");
    } else {
      final User user = optionalUser.get();
      session.setAttribute(SystemDefaultProperty.UID, user.getUid());
      mav = new ModelAndView(String.format("redirect:/user/%d", user.getUid()));
    }
    return mav;
  }

  /**
   * Controller for sign up.
   *
   * @return
   */
  @GetMapping(value = "/signup")
  public ModelAndView signUp() {
    return new ModelAndView("signup", "user", new SignUp());
  }

  /**
   * Controller for sign in.
   *
   * @param signUpUser sign up user
   * @param session    HTTP session
   *
   * @return
   */
  @PostMapping(value = "/signup")
  public ModelAndView signUp(final @Valid @ModelAttribute SignUp signUpUser,
                             final HttpSession session) {
    final Optional<User> optionalUser = this.userService.getDao()
      .findByEmail(signUpUser.getEmail());

    final ModelAndView mav;
    if (optionalUser.isPresent()) {
      //conflicted
      mav = new ModelAndView("error");
      mav.addObject("error", "Email not available");
    } else {
      final User user = this.userService.getDao().save(UserMapper.INSTANCE.fromSignUp(signUpUser));
      session.setAttribute(SystemDefaultProperty.UID, user.getUid());
      mav = new ModelAndView(String.format("redirect:/user/%d", user.getUid()));
    }
    return mav;
  }

  /**
   * Controller for user profile.
   *
   * @param uid user id
   *
   * @return
   */
  @GetMapping(value = "/user/{uid}")
  public ModelAndView profile(final @PathVariable Integer uid) {
    return this.toProfile(uid);
  }
}
