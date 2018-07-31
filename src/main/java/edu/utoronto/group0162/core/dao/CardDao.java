package edu.utoronto.group0162.core.dao;

import edu.utoronto.group0162.core.entity.Card;

import org.springframework.data.repository.CrudRepository;

/**
 * Dao interface for Stclair service.
 *
 * @author Rugal Bernstein
 */
public interface CardDao extends CrudRepository<Card, Integer> {

}
