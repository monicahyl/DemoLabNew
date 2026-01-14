package com.core.web.dao.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author huangyulu
 * @Date 2026/1/10 17:27
 * @Description
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    /*
    * ThreadLocal 用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其他线程里的变量
    * 即每个线程都有一个单独副本
    * */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 决定使用哪个数据源之前
     * 需要把多个数据源的信息以及默认数据源信息配置好
     * @param defaultTargetDataSource
     * @param targetDataSources
     */
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }



    /**
     * determineCurrentLookupKey方法决定使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }


}
