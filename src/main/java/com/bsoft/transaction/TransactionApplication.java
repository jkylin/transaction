package com.bsoft.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

/**
 * Springboot入口类
 * @author wangruix
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com"})
public class TransactionApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(TransactionApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }

}
