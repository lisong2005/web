/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.thread.aio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: EchoBioClient.java, v 0.1 2016年2月24日 下午2:21:40 song.li@witontek.com Exp $
 */
public class EchoBioClient {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(EchoBioClient.class);

    public static void main(String[] args) {
        ExecutorService taskService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            taskService.execute(new Runnable() {

                @Override
                public void run() {
                    invoke();
                }
            });
        }
    }

    /**
     * 
     */
    protected static void invoke() {
        try (Socket s = new Socket("localhost", 8001);
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream()) {

            String[] ss = new String[] { "hello", "abc", "exit", "ddd" };

            for (String str : ss) {
                os.write(str.getBytes());
                os.flush();

                byte[] bf = new byte[1024];

                int size = is.read(bf);
                String arg = new String(bf, 0, size);

                logger.info("read = {}", arg);
                if (StringUtils.equals("bye", arg)) {
                    logger.info("exit");
                    break;
                }
            }

        } catch (IOException e) {
            logger.error("", e);
        }
    }

}
