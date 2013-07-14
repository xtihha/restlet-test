package com.xtihha.study.restlet.db.conf;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangxiaohu
 * @created 2013-7-14
 */

public class SqlFactoryBuilder {
    private SqlSessionFactory factory;

    private static final Logger logger = LoggerFactory.getLogger(SqlFactoryBuilder.class);

    public SqlFactoryBuilder(String batisCfgPath) throws Exception {
        logger.info("MyBatis config path : {}", batisCfgPath);
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources
                    .getResourceAsReader(batisCfgPath));
        } catch (IOException e) {
            logger.error("can NOT build SqlSessionFactory", e);
            throw e;
        }
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }

}
