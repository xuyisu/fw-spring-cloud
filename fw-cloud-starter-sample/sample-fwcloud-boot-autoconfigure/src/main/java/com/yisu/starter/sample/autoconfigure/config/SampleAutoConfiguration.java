package com.yisu.starter.sample.autoconfigure.config;

import com.yisu.starter.sample.autoconfigure.properties.SampleProperties;
import com.yisu.starter.sample.autoconfigure.service.SampleService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "fwcloud.sample.enable", havingValue = "true")
public class SampleAutoConfiguration {

    @Bean
    public SampleService greetingService(SampleProperties sampleProperties){
        return new SampleService(sampleProperties.getUser());
    }
}
