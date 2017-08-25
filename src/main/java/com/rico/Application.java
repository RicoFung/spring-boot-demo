package com.rico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//可代替下面3个注解
@SpringBootApplication 
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class Application
{
    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }
}
