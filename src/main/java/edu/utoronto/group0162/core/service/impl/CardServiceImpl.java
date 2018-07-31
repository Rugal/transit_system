package edu.utoronto.group0162.core.service.impl;

import edu.utoronto.group0162.core.dao.CardDao;
import edu.utoronto.group0162.core.service.CardService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

  @Autowired
  @Getter
  private CardDao dao;
}
