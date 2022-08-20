package com.nttdata.bootcamp.active.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.nttdata.bootcamp.active.model.Active;
import com.nttdata.bootcamp.active.service.ActiveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class ActiveControllerTest {
  
  @Mock
  ActiveService activeService;
  
  @InjectMocks
  ActiveController activeController;
  
  private Active active;
  
  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(getClass());
    
  }

  @Test
  void test() {
    fail("Not yet implemented");
  }

}
