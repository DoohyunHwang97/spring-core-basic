package hello.core.singleton;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SingletonServiceTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonConfig.class);

    @Test
    @DisplayName("클라이언트는 싱글톤 클래스에 의존하게 된다")
    void singleton() {
        Service notSingletonService = ac.getBean("notSingletonService", Service.class);
        Service singletonService = ac.getBean("singletonService", Service.class);

        notSingletonService.serve();
        singletonService.serve();
    }

    @Configuration
    public static class SingletonConfig {
        @Bean
        public Service notSingletonService() {
            return new NotSingletonService();
        }
        @Bean
        public Service singletonService() {
            return SingletonService.getInstance();
        }
    }
}
