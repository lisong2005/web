/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.thread.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoAioClient {
    /**
    * Logger for this class
    */
    private static final Logger             logger = LoggerFactory.getLogger(EchoAioClient.class);

    private final AsynchronousSocketChannel client;

    public EchoAioClient() throws Exception {
        client = AsynchronousSocketChannel.open();
    }

    public void start() throws Exception {
        logger.info("start");
        try {
            client.connect(new InetSocketAddress("localhost", 8001), null,
                new CompletionHandler<Void, Void>() {
                    @Override
                    public void completed(Void result, Void attachment) {
                        try {
                            logger.info("send data to server start");
                            int size = client.write(ByteBuffer.wrap("this is a test".getBytes()))
                                .get();

                            logger.info("send data to server s={}", size);

                            {

                                final ByteBuffer bb = ByteBuffer.allocate(1024);

                                client.read(bb, null, new CompletionHandler<Integer, Object>() {

                                    @Override
                                    public void completed(Integer result, Object attachment) {
                                        logger.info("{}", result);
                                        logger.info(new String(bb.array()));

                                        System.exit(0);
                                    }

                                    @Override
                                    public void failed(Throwable exc, Object attachment) {
                                        logger.error(exc.getMessage(), exc);
                                    }
                                });
                            }
                        } catch (Exception ex) {
                            logger.error(ex.getMessage(), ex);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        logger.error(exc.getMessage(), exc);
                    }
                });

            try {
                // Wait for ever
                logger.info("sleep");
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException ex) {
                logger.error(ex.getMessage(), ex);
            }
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    public static void main(String args[]) throws Exception {
        new EchoAioClient().start();
    }
}