package edu.utoronto.group0162.core.service;

import edu.utoronto.group0162.core.dao.TripDao;
import edu.utoronto.group0162.core.entity.Station;
import edu.utoronto.group0162.core.entity.Trip;
import edu.utoronto.group0162.core.entity.User;

public interface TripService extends ServiceBase<TripDao> {

  /**
   * User tap in at a station.
   *
   * @param user  user
   * @param start start station
   *
   * @return the start trip
   */
  Trip tapIn(User user, Station start);

  /**
   * User tap in a station for a continuous trip.
   *
   * @param trip  continuous trip
   * @param start start station
   *
   * @return the original trip object
   */
  Trip tapIn(Trip trip, Station start);
}
