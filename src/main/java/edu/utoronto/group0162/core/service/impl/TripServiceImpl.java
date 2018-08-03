package edu.utoronto.group0162.core.service.impl;

import edu.utoronto.group0162.core.dao.TripDao;
import edu.utoronto.group0162.core.service.TripService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

  @Autowired
  @Getter
  private TripDao dao;
}
