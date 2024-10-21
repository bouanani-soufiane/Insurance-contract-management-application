package ma.yc;

import ma.yc.common.infrastructure.config.DataSourceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main ( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        DataSource dataSource = context.getBean(DataSource.class);
        logger.info("Attempting to connect to the database...");

        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                logger.info("Connected to the database!");
            } else {
                logger.warn("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            logger.error("Database connection error: {}", e.getMessage());
        }
        context.close();

    }
}