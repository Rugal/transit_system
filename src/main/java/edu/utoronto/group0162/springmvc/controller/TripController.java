package edu.utoronto.group0162.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
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

  @GetMapping("/trip-plan")
  public ModelAndView trip() {
    return new ModelAndView("trip");
  }
}
