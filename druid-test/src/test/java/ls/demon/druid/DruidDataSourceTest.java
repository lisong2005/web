/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.DataSource;

import ls.demon.test.BaseTest;

import org.junit.Test;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DruidDataSourceTest.java, v 0.1 2016年2月16日 上午11:05:01 song.li@witontek.com Exp $
 */
public class DruidDataSourceTest extends BaseTest {

    @Test
    public void test_query() {
        try {
            DataSource dSource = getContext().getBean("dataSource", DataSource.class);
            logger.info("{}", dSource);

            String sql = "select now(),now()";

            try (
            // 
            Connection con = dSource.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
            // 
            ) {
                logger.info("{}", con);
                logger.info("{}", ps);
                logger.info("{}", rs);

                ResultSetMetaData mrs = rs.getMetaData();
                int cols = mrs.getColumnCount();
                logger.info("cols = {}", cols);

                while (rs.next()) {
                    logger.info("row = {}", rs.getRow());
                    for (int i = 1; i <= cols; i++) {
                        logger.info("{}", rs.getTimestamp(i));

                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
