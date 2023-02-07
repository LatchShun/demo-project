package indi.latch.demo.multidatasource.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Title: ClickHouseDataSourceConfig
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@Configuration
@MapperScan(basePackages = "indi.latch.demo.multidatasource.repo.clickhouse.mapper",
        sqlSessionFactoryRef = "clickhouseSqlSessionFactory")
public class ClickHouseDataSourceConfig {
    private static final String CLICKHOUSE_DRIVER = "ru.yandex.clickhouse.ClickHouseDriver";

    @Value("${spring.datasource.clickhouse.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.clickhouse.username}")
    private String userName;

    @Value("${spring.datasource.clickhouse.password}")
    private String passwd;

    @Bean(name = "clickhouseDataSource")
    public DataSource buildDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(CLICKHOUSE_DRIVER);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(passwd);
        return druidDataSource;
    }

    @Bean(name = "clickhouseSqlSessionFactory")
    public SqlSessionFactory buildSqlSessionFactory(@Qualifier("clickhouseDataSource") DataSource clickhouseDataSource) throws Exception {
        SqlSessionFactoryBean s = new SqlSessionFactoryBean();
        s.setDataSource(clickhouseDataSource);
        s.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
                "classpath:indi/latch/demo/multidatasource/repo/clickhouse/mapper/*.xml"));
        return s.getObject();
    }

    @Bean(name = "clickhouseSqlSessionTemplate")
    public SqlSessionTemplate buildSqlSessionTemplate(@Qualifier("clickhouseSqlSessionFactory") SqlSessionFactory clickhouseSqlSessionFactory) {
        return new SqlSessionTemplate(clickhouseSqlSessionFactory);
    }
}