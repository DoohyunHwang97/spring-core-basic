package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

    @Test
    void test() {
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "dd", Grade.VIP);
        System.out.println(discountService.discount(member, 10000, "rateDiscountPolicy"));
        System.out.println(discountService.discount(member, 10000, "fixDiscountPolicy"));
    }

    public static class DiscountService {
        private final Map<String, DiscountPolicy> discountPolicyMap;
        private final List<DiscountPolicy> discountPolicyList;
        
        public DiscountService(Map<String, DiscountPolicy> discountPolicyMap, List<DiscountPolicy> discountPolicyList) {
            this.discountPolicyMap = discountPolicyMap;
            this.discountPolicyList = discountPolicyList;
        }

        public int discount(Member member, int price, String policyCode) {
            return discountPolicyMap.get(policyCode).discount(member, price);
        }
    }
}
