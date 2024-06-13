package hello.core.option;

import hello.core.AppConfig;
import hello.core.scan.BeanA;
import hello.core.scan.BeanB;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Option.class);

    @Test
    void option() {

    }

    public static class Option {

        @Autowired(required = false)
        public void setNoBean(BeanA beanA) {
            System.out.println(beanA);
        }

        @Autowired
        public void setNoBean2(@Nullable BeanA beanA) {
            System.out.println(beanA);
        }

        @Autowired
        public void setNoBean2(Optional<BeanA> beanA) {
            System.out.println(beanA);
        }
    }
}
