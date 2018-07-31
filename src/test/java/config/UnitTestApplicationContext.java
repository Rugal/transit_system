package config;

import java.util.Random;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Runzhuo Li
 */
@ComponentScan
@Configuration
public class UnitTestApplicationContext {

  @Bean
  public Random random() {
    return Mockito.mock(Random.class);
  }
}
