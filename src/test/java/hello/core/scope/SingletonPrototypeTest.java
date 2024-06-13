package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonPrototypeTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

    @Test
    void singletonPrototypeTest() {
        ClientBean bean1 = ac.getBean(ClientBean.class);
        ClientBean bean2 = ac.getBean(ClientBean.class);

        Assertions.assertThat(bean1.logic()).isEqualTo(bean2.logic());
    }

    static class ClientBean {
        private final ObjectProvider<PrototypeBean> objectProvider;

        @Autowired
        public ClientBean(ObjectProvider<PrototypeBean> objectProvider) {
            this.objectProvider = objectProvider;
        }

        public int logic() {
            PrototypeBean prototypeBean = objectProvider.getObject();
            System.out.println("prototypeBean = " + prototypeBean);
            return prototypeBean.addCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public int addCount() {
            count++;
            return count;
        }

        public int getCount() {
            return count;
        }
    }
}
