package com.tistory.nuridan.restapi.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"com.tistory.nuridan.restapi.config.security.mapper", "com.tistory.nuridan.restapi.sample.mapper"}, sqlSessionFactoryRef = "commonSqlSessionFactory")
@EnableTransactionManagement
public class DatabaseConfig {
    
    @Bean(name="commonDataSource")
    @ConfigurationProperties(prefix = "COMMON")
    @Primary
    public DataSource commonDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "commonSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("commonDataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*query.xml"));
        sessionFactory.setTypeAliasesPackage("com.tistory.nuridan.restapi");
        return sessionFactory.getObject();
    }
    
    @Bean(name = "commonSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate =  new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
    
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("commonDataSource") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }
}