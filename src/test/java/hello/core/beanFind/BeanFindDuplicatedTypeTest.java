package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanFindDuplicatedTypeTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DuplicatedBeanConfig.class);

    @Test
    void findDuplicatedBeanThrowsException() {
        Assertions.assertThatThrownBy(() -> ac.getBean(MemberService.class)).isInstanceOf(
                NoUniqueBeanDefinitionException.class);
    }

    @Test
    void findAllBeanSameType() {
        Map<String, MemberService> beansOfType = ac.getBeansOfType(MemberService.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value" + beansOfType.get(key));
        }
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    public static class DuplicatedBeanConfig {
        @Bean
        public MemberService memberService1() {
            return new MemberServiceImpl(new MemoryMemberRepository());
        }

        @Bean
        public MemberService memberService2() {
            return new MemberServiceImpl(new MemoryMemberRepository());
        }
    }
}
