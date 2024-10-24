package ma.yc;

import ma.yc.config.PersistenceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main ( String[] args ) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class)) {
            String[] beanNames = context.getBeanDefinitionNames();
            System.out.println("Registered Beans:");
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        }
    }
}
