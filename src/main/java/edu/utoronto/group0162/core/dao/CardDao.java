package edu.utoronto.group0162.core.dao;

import java.util.List;

import edu.utoronto.group0162.core.entity.Card;
import edu.utoronto.group0162.core.entity.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Card Dao.
 *
 * @author Rugal Bernstein
 */
public interface CardDao extends CrudRepository<Card, Integer> {

  List<Card> findByUser(User user);
}
