package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class LifecycleBeanTest {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleBean.class, LifeCycleConfig.class);

    @Test
    void lifecycleTest() {
        ac.close();
    }

    @Configuration
    public static class LifeCycleConfig {
//        @Bean(initMethod = "init")
//        public LifecycleBean lifecycleBean() {
//            return new LifecycleBean(lifeCycleDependencyBean());
//        }

        @Bean
        public LifeCycleDependencyBean lifeCycleDependencyBean() {
            return new LifeCycleDependencyBean();
        }
    }
}
