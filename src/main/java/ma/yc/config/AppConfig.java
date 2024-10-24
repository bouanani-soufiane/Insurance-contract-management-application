package ma.yc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("ma.yc")
@Import({PersistenceConfig.class, WebMvcConfig.class})
public class AppConfig {
}
