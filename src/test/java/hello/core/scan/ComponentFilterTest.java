package hello.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(FilterConfig.class);

    @Test
    void filter() {
        BeanA bean = ac.getBean(BeanA.class);
        Assertions.assertThat(bean).isNotNull();

        Assertions.assertThatThrownBy(() -> ac.getBean(BeanB.class)).isInstanceOf(NoSuchBeanDefinitionException.class);
    }
    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = IncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = ExcludeComponent.class)
    )
    public static class FilterConfig {
    }
}
