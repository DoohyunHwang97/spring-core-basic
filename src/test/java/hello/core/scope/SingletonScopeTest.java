package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonScopeTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Singleton.class);

    @Test
    void singleton() {
        Singleton bean1 = ac.getBean(Singleton.class);
        Singleton bean2 = ac.getBean(Singleton.class);

        ac.close();

        Assertions.assertThat(bean1).isSameAs(bean2);
    }

    @Scope("singleton")
    static class Singleton {
        public Singleton() {
            System.out.println("create");
        }

        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        @PreDestroy
        public void close() {
            System.out.println("close");
        }
    }
}
