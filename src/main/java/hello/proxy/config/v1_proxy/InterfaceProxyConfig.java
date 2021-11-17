package hello.proxy.config.v1_proxy;

import hello.proxy.app.v1.*;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace trace) {
        return new OrderRepositoryInterfaceProxy(new OrderRepositoryV1Impl(), trace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace trace) {
        return new OrderServiceInterfaceProxy(new OrderServiceV1Impl(orderRepository(trace)), trace);
    }

    @Bean
    OrderControllerV1 orderController(LogTrace trace) {
        return new OrderControllerInterfaceProxy(new OrderControllerV1Impl(orderService(trace)), trace);
    }

}
