package com.test.coffee.config;

import com.test.coffee.service.ProductServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GrpcConfig {
    @Bean
    public Server grpcServer(ProductServiceImpl productService) throws IOException {
        return ServerBuilder.forPort(9090)
                .addService(productService)
                .build()
                .start();
    }
}
