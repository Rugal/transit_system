package edu.utoronto.group0162.core.dao;

import java.util.List;

import edu.utoronto.group0162.core.entity.Trip;
import edu.utoronto.group0162.core.entity.TripSegment;

import org.springframework.data.repository.CrudRepository;

/**
 * Trip Segment Dao.
 *
 * @author Rugal Bernstein
 */
public interface TripSegmentDao extends CrudRepository<TripSegment, Integer> {

  List<TripSegment> findByTrip(Trip trip);
}
