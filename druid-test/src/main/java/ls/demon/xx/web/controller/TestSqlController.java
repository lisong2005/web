/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.xx.web.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TestSqlController.java, v 0.1 2016年2月16日 下午2:53:20 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/test/dt.htm")
public class TestSqlController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestSqlController.class);

    @Autowired
    private DataSource          dataSource;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String doGet(ModelMap modelMap, String jsonStr, String appSecret) {
        // logger.info("ds = {}", dataSource);
        try {
            String sql = "select now(),now()";
            try (
            // 
            Connection con = dataSource.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
            // 
            ) {
                //                logger.info("{}", con);
                //                logger.info("{}", ps);
                //                logger.info("{}", rs);

                ResultSetMetaData mrs = rs.getMetaData();
                int cols = mrs.getColumnCount();
                // logger.info("cols = {}", cols);

                while (rs.next()) {
                    //logger.info("row = {}", rs.getRow());
                    for (int i = 1; i <= cols; i++) {
                        //logger.info("{}", rs.getTimestamp(i));
                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }

        return "hello";
    }
}
