package com.hardik.shah;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.hardik.shah")
@EnableAspectJAutoProxy
public class BeanConfig {
}
