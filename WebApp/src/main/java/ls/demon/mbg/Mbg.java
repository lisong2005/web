/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.mbg;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Mbg.java, v 0.1 2016年3月17日 下午1:17:20 song.li@witontek.com Exp $
 */
public class Mbg {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(Mbg.class);

    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            URL resource = Thread.currentThread().getContextClassLoader()
                .getResource("META-INF/generatorConfig.xml");
            //            URL resource = Mbg.class.getResource("/");

            logger.info("{}", resource);
            File configFile = new File(resource.getFile());
            logger.info("{}", configFile);
            ConfigurationParser cp = new ConfigurationParser(warnings);

            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);

            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
