package ma.yc.common.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource(value = {"classpath:application.properties"})

public class DatabaseProperties {

    @Value("${app.database.hibernate.show-sql}")
    private Boolean showSql;
    @Value("${app.database.hibernate.format-sql}")
    private Boolean formatSql;
    @Value("${app.database.hibernate.ddl-auto}")
    private String hbm2ddlAuto;
    @Value("${app.database.driver}")
    private String driverClassName;
    @Value("${app.database.url}")
    private String url;
    @Value("${app.database.username}")
    private String username;
    @Value("${app.database.password}")
    private String password;

}
