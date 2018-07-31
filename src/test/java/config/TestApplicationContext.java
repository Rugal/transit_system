package config;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Runzhuo Li
 */
@Configuration
public class TestApplicationContext {

  @ConditionalOnMissingBean
  @Bean
  public Gson gson() {
    return new Gson();
  }

  @Bean
  public Faker faker() {
    return new Faker();
  }
}
