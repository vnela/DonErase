package ohjelmistoprojekti.kyselysovellus.domain;


import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

  @Value("${postgres://pevvluafcwtffg:43452a33031b56adc7296954bfd0317c0fb7aaafc707bc4b1e506e39f74e2dae@ec2-54-217-234-157.eu-west-1.compute.amazonaws.com:5432/d4o3dmfcvl5fid}")
  private String dbUrl;

  @Bean
  public DataSource dataSource() {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl);
      return new HikariDataSource(config);
  }
}
