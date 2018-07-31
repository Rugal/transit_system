package edu.utoronto.group0162.core.dao;

import edu.utoronto.group0162.core.entity.User;

import org.springframework.data.repository.CrudRepository;

/**
 * User Dao.
 *
 * @author Rugal Bernstein
 */
public interface UserDao extends CrudRepository<User, Integer> {

  User findByEmailAndPassword(String email, String password);
}
