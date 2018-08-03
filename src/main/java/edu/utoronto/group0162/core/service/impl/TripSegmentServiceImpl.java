package edu.utoronto.group0162.core.service.impl;

import edu.utoronto.group0162.core.dao.TripSegmentDao;
import edu.utoronto.group0162.core.service.TripSegmentService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripSegmentServiceImpl implements TripSegmentService {

  @Autowired
  @Getter
  private TripSegmentDao dao;
}
