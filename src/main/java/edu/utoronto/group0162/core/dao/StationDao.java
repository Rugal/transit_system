package edu.utoronto.group0162.core.dao;

import java.util.List;

import edu.utoronto.group0162.core.entity.Station;

import org.springframework.data.repository.CrudRepository;

/**
 * Station Dao.
 *
 * @author Rugal Bernstein
 */
public interface StationDao extends CrudRepository<Station, Integer> {

  @Override
  List<Station> findAll();
}
