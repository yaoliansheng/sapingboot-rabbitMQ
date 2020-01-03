package com.rabbit.mq.rabbit.provide;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.rabbit.mq.rabbit.provide.rabbit.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.rabbit.mq.rabbit.provide.mapper")
public class RabbitProvideApplication {

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(RabbitProvideApplication.class, args);
    }

    @Bean
    public IdGenerator getIdGenerator() {
        return new CommonSelfIdGenerator();
    }
}
