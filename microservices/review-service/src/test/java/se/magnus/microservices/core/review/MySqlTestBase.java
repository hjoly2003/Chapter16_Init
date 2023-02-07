package se.magnus.microservices.core.review;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public abstract class MySqlTestBase {
  // [N]:arm64]:mysql8 - Author's version is 8.0.30, mine was 8.0.31
  private static MySQLContainer database = new MySQLContainer("mysql:8.0.30");

  static {
    database.start();
  }

  @DynamicPropertySource
  static void databaseProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", database::getJdbcUrl);
    registry.add("spring.datasource.username", database::getUsername);
    registry.add("spring.datasource.password", database::getPassword);
  }

}
