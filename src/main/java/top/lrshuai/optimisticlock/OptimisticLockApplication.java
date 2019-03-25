package top.lrshuai.optimisticlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.lrshuai.optimisticlock.*.mapper")
public class OptimisticLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(OptimisticLockApplication.class, args);
    }

}
