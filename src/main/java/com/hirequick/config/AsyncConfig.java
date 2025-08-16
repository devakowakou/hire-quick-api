package com.hirequick.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync  // Active le support pour @Async
public class AsyncConfig {
}
