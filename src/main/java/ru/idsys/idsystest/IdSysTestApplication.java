package ru.idsys.idsystest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IdSysTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdSysTestApplication.class, args);
    }

}
