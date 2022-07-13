package com.rns.test.webTests;


import static org.assertj.core.api.Assertions.assertThat;

import com.rns.test.controller.FileController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileControllerTest {

    @Autowired
  private FileController controller;

    @Test
    public void contextLoads()  {
        assertThat(controller).isNotNull();
    }
}

