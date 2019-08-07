package com.siszerosix.allstorage.svc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlInfo;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.siszerosix.allstorage.svc.controller.OkController;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author canyu
 * @data 2019/8/4 14:25
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.siszerosix.allstorage.svc.mapper"},
        sqlSessionFactoryRef = DataSourceConfig.SQL_SESSION_FACTORY,
        sqlSessionTemplateRef = DataSourceConfig.SQL_SESSION_TEMPLATE)
public class DataSourceConfig {

    public final static String SQL_SESSION_FACTORY = "sqlSessionFactory";
    public final static String SQL_SESSION_TEMPLATE = "sqlSessionTemplate";
    public static final String TX_MANAGER = "transactionManager";

    private static final String DATA_SOURCE_NAME = "szs_storage";

    private static final String VALIDATION_QUERY = "SELECT 1 FROM DUAL";
    private final static List<String> XML_PATHS = Arrays.asList("classpath:com/siszerosix/allstorage/svc/mapper/*.xml");


    @Value("${database.storage.url}")
    private String url;
    @Value("${database.storage.username}")
    private String username;
    @Value("${database.storage.password}")
    private String password;

    @Value("${mybatis.config.path}")
    private String mybatisConfigPath;

    @Bean(name = DATA_SOURCE_NAME)
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMinIdle(3);
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(30000L);
        dataSource.setInitialSize(3);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(280);
        dataSource.setTimeBetweenEvictionRunsMillis(60000L);
        dataSource.setMinEvictableIdleTimeMillis(300000L);
        dataSource.setValidationQuery(VALIDATION_QUERY);
        dataSource.setTestOnBorrow(true);
        dataSource.setTimeBetweenLogStatsMillis(60000L);
//        dataSource.setStatLoggerClassName(DruidDataSourceStatLoggerImpl.class.getCanonicalName());
        return dataSource;
    }

    @Bean(name = TX_MANAGER)
    public DataSourceTransactionManager getTransactionManager(@Qualifier(DATA_SOURCE_NAME) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory getSqlSessionFactoryData(@Qualifier(DATA_SOURCE_NAME) DataSource dataSource) {
        try {
            MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
            List<Resource> resources = new ArrayList();
            Iterator i$ = XML_PATHS.iterator();
            while (i$.hasNext()) {
                String xmlPath = (String) i$.next();
                Resource[] t = (new PathMatchingResourcePatternResolver()).getResources(xmlPath);
                resources.addAll(Arrays.asList(t));
            }
            if (!resources.isEmpty()) {
                bean.setMapperLocations((Resource[]) resources.toArray(new Resource[resources.size()]));
            }
            if (!StringUtils.isEmpty(mybatisConfigPath)) {
                bean.setConfigLocation((new PathMatchingResourcePatternResolver()).getResource(mybatisConfigPath));
            }
            bean.setDataSource(dataSource);
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException("failed to create data sql session", e);
        }
    }

    @Bean(name = SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier(SQL_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
        paginationInterceptor.setDialectClazz("com.baomidou.mybatisplus.extension.plugins.pagination.dialects.MySqlDialect");
        paginationInterceptor.setLimit(100);
        return paginationInterceptor;
    }

}
