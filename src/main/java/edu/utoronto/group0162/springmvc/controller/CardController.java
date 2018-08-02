package edu.utoronto.group0162.springmvc.controller;

import javax.servlet.http.HttpSession;

import config.SystemDefaultProperty;

import edu.utoronto.group0162.core.service.CardService;
import edu.utoronto.group0162.core.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    return this.userService.toProfile((Integer) session.getAttribute(SystemDefaultProperty.UID));
  }
}
