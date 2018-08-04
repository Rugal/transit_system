package edu.utoronto.group0162.springmvc.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import config.SystemDefaultProperty;

import edu.utoronto.group0162.core.entity.Card;
import edu.utoronto.group0162.core.entity.Station;
import edu.utoronto.group0162.core.entity.Trip;
import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.CardService;
import edu.utoronto.group0162.core.service.StationService;
import edu.utoronto.group0162.core.service.TripSegmentService;
import edu.utoronto.group0162.core.service.TripService;
import edu.utoronto.group0162.core.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for card resources.
 *
 * @author Rugal Bernstein
 */
@Controller
@Slf4j
public class TripController {

  @Autowired
  private CardService cardService;

  @Autowired
  private UserService userService;

  @Autowired
  private TripService tripService;

  @Autowired
  private TripSegmentService tripSegmentService;

  @Autowired
  private StationService stationService;

  /**
   * To trip plan page.
   *
   * @param session HTTP session
   *
   * @return
   */
  @GetMapping("/trip-plan")
  public ModelAndView trip(final HttpSession session) {
    final Integer uid = (Integer) session.getAttribute(SystemDefaultProperty.UID);
    final User user = this.userService.getDao().findById(uid).get();
    final Optional<Trip> optionalTrip = this.tripService.getDao()
      .findByUserAndFinish(user, false);
    final List<Card> cards = this.cardService.getDao().findByUser(user);
    final List<Station> stations = this.stationService.getDao().findAll();

    final ModelAndView mav = new ModelAndView("trip");
    mav.addObject("hasUnfinishTrip", optionalTrip.isPresent());
    mav.addObject("stations", stations);
    mav.addObject("cards", cards);
    if (optionalTrip.isPresent()) {
      mav.addObject("tripSegments",
                    this.tripSegmentService.getDao().findByTrip(optionalTrip.get()));
    }
    return mav;
  }
}
