package edu.utoronto.group0162.springmvc.controller;

import java.util.Optional;
import javax.servlet.http.HttpSession;

import config.SystemDefaultProperty;

import edu.utoronto.group0162.core.entity.Card;
import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.CardService;
import edu.utoronto.group0162.core.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for card resources.
 *
 * @author Rugal Bernstein
 */
@Controller
@Slf4j
public class CardController {

  @Autowired
  private CardService cardService;

  @Autowired
  private UserService userService;

  /**
   * Delete card.
   *
   * @param cid     card id
   * @param session HTTP session
   *
   * @return
   */
  @DeleteMapping("/card/{cid}")
  public ModelAndView delete(final @PathVariable Integer cid,
                             final HttpSession session) {
    this.cardService.getDao().deleteById(cid);
    final Integer uid = (Integer) session.getAttribute(SystemDefaultProperty.UID);
    return new ModelAndView(String.format("redirect:/user/%d", uid));
  }

  /**
   * Add card.
   *
   * @param uid     user id
   * @param session HTTP session
   *
   * @return
   */
  @PostMapping("/user/{uid}/card")
  public ModelAndView save(final @PathVariable Integer uid,
                           final HttpSession session) {
    final Optional<User> optionalUser = this.userService.getDao().findById(uid);
    if (optionalUser.isPresent()) {
      final Card card = new Card();
      card.setBalance(20.0);
      card.setUser(optionalUser.get());
      this.cardService.getDao().save(card);
    }
    return new ModelAndView(String.format("redirect:/user/%d", uid));
  }
}
