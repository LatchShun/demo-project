package indi.latch.demo.multidatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Title: MultiDataSourceApplication
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2022/12/28
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@SpringBootApplication
public class MultiDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApplication.class, args);
    }
}
