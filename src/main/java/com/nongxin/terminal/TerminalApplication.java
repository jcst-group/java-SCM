package com.nongxin.terminal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
// 支持异步线程,需要异步调用的service层方法上面加上@Async注解,二者联合,可起作用
@EnableAsync
//开启基于注解的定时任务
@EnableScheduling
@MapperScan("com.nongxin.terminal.dao")
public class TerminalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerminalApplication.class, args);
    }

}
