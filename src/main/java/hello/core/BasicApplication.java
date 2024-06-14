package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BasicApplication {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicApplication.class);
//        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
//        OrderService orderService = applicationContext.getBean(OrderService.class);
//
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Order order = orderService.createOrder(1L, "itemA", 10000);
//        System.out.println("order = " + order);
        SpringApplication.run(BasicApplication.class, args);
    }
}
