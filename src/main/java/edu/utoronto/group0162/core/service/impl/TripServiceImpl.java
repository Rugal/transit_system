package edu.utoronto.group0162.core.service.impl;

import edu.utoronto.group0162.core.dao.TripDao;
import edu.utoronto.group0162.core.entity.Station;
import edu.utoronto.group0162.core.entity.Trip;
import edu.utoronto.group0162.core.entity.TripSegment;
import edu.utoronto.group0162.core.entity.User;
import edu.utoronto.group0162.core.service.TripSegmentService;
import edu.utoronto.group0162.core.service.TripService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

  @Autowired
  @Getter
  private TripDao dao;

  @Autowired
  private TripSegmentService tripSegmentService;

  /**
   * {@inheritDoc}
   */
  @Override
  public Trip tapIn(final User user, final Station start) {
    Trip trip = new Trip();
    trip.setFinish(false);
    trip.setUser(user);
    trip = this.dao.save(trip);

    final TripSegment tripSegment = new TripSegment();
    tripSegment.setStart(start);
    tripSegment.setUser(user);
    tripSegment.setTrip(trip);
    this.tripSegmentService.getDao().save(tripSegment);
    return trip;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Trip tapIn(final Trip trip, final Station start) {
    final TripSegment tripSegment = new TripSegment();
    tripSegment.setStart(start);
    tripSegment.setUser(trip.getUser());
    tripSegment.setTrip(trip);
    this.tripSegmentService.getDao().save(tripSegment);
    return trip;
  }
}
