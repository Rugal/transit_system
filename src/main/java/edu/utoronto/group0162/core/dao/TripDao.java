package edu.utoronto.group0162.core.dao;

import java.util.List;
import java.util.Optional;

import edu.utoronto.group0162.core.entity.Trip;
import edu.utoronto.group0162.core.entity.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Trip Dao.
 *
 * @author Rugal Bernstein
 */
public interface TripDao extends CrudRepository<Trip, Integer> {

  Optional<Trip> findByUserAndFinish(User user, Boolean finish);

  List<Trip> findByUser(User user);
}
