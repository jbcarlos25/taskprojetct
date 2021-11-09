package com.example.cursoMc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.*"})
@SpringBootApplication
public class CursoMcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursoMcApplication.class, args);
    }

}
