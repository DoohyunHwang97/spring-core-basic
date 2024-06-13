package hello.core.scope;

import hello.core.scope.SingletonScopeTest.Singleton;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeScopeTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Prototype.class);

    @Test
    void singleton() {
        Prototype bean1 = ac.getBean(Prototype.class);
        Prototype bean2 = ac.getBean(Prototype.class);

        ac.close();

        Assertions.assertThat(bean1).isNotSameAs(bean2);
    }

    @Scope("prototype")
    static class Prototype {
        public Prototype() {
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
