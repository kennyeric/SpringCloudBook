package com.didispace.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by xuchuan on 2017/5/27.
 */

@Configuration
@MapperScan("com.didispace.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment env;


//    @Bean
//    public DataSource getDataSource() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
//        props.put("url", env.getProperty("jdbc.uri"));
//        props.put("username", env.getProperty("jdbc.username"));
//        props.put("password", env.getProperty("jdbc.password"));
//
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(ds);
//
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
//        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
//        return fb.getObject();
//    }

    @Bean
    //@Primary
    public DataSource getDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//指定xml文件位置

        return fb.getObject();
    }
}
