package org.ditto.gift;

import org.ditto.gift.grpc.GiftGrpcService;
import org.ditto.gift.grpc.GreeterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationSpringBoot {

    @Bean
    public GreeterService greeterService() {
        return new GreeterService();
    }


    @Bean
    public GiftGrpcService giftService() {
        return new GiftGrpcService();
    }


    public static void main(String[] args) {
        SpringApplication.run(ApplicationSpringBoot.class, args);
    }
}
