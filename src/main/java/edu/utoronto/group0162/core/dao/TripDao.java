package edu.utoronto.group0162.core.dao;

import edu.utoronto.group0162.core.entity.Trip;

import org.springframework.data.repository.CrudRepository;

/**
 * Trip Dao.
 *
 * @author Rugal Bernstein
 */
public interface TripDao extends CrudRepository<Trip, Integer> {

}
