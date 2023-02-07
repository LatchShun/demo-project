package indi.latch.demo.multidatasource.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Title: MySqlDataSourceConfig
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@Configuration
@MapperScan(basePackages = "indi.latch.demo.multidatasource.repo.mysql.mapper",
        sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MySqlDataSourceConfig {

    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    @Value("${spring.datasource.mysql.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.mysql.username}")
    private String userName;

    @Value("${spring.datasource.mysql.password}")
    private String passwd;

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource buildDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(MYSQL_DRIVER);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(passwd);
        return druidDataSource;
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory buildSqlSessionFactory(DataSource mysqlDataSource) throws Exception {
        SqlSessionFactoryBean s = new SqlSessionFactoryBean();
        s.setDataSource(mysqlDataSource);
        s.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
                "classpath:indi/latch/demo/multidatasource/repo/mysql/mapper/*.xml"));
        return s.getObject();
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager buildDataSourceTransactionManager(DataSource mysqlDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(mysqlDataSource);
        return dataSourceTransactionManager;
    }

    @Bean(name = "mysqlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate buildSqlSessionTemplate(SqlSessionFactory mysqlSqlSessionFactory) {
        return new SqlSessionTemplate(mysqlSqlSessionFactory);
    }
}
