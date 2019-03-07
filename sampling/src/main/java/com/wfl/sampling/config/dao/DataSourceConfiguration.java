package com.wfl.sampling.config.dao;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 15:36 2018/12/18
 * @ Description：
 * @ Modified By：
 */
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
//告诉spring容器 来到这个类下面去检索相关的bean
@Configuration
//配置mybatis mapper的扫描路径
/**
 * 作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
 * */
@MapperScan("com.wfl.sampling.dao")
public class DataSourceConfiguration {
    //数据库连接池
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        //连接池关闭连接之后不自动commit 这样才能对事务进行控制
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}

