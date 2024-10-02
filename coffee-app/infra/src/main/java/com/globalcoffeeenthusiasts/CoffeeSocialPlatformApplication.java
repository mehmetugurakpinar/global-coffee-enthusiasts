package com.globalcoffeeenthusiasts;

import com.globalcoffeeenthusiasts.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@SpringBootApplication
@ComponentScan(
        includeFilters = {@Filter(
                type = FilterType.ANNOTATION,
                value = {DomainComponent.class}
        )}
)
public class CoffeeSocialPlatformApplication {
    public CoffeeSocialPlatformApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeSocialPlatformApplication.class, args);
    }
}