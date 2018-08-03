package edu.utoronto.group0162.core.service.impl;

import edu.utoronto.group0162.core.dao.StationDao;
import edu.utoronto.group0162.core.service.StationService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService {

  @Autowired
  @Getter
  private StationDao dao;
}
