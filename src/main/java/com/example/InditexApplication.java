package com.example;

import com.example.core.infrastructure.SpringDependencies;
import com.example.core.main.Provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InditexApplication {
    private final SpringDependencies dependencies;

    public InditexApplication(SpringDependencies dependencies) {
        this.dependencies = dependencies;
    }

    public static void main(String[] args) {
        SpringApplication.run(InditexApplication.class, args);
    }

    @Bean
    public Provider provider() {
        return new Provider(dependencies);
    }

}
