/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.thread.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoAioServer {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(EchoAioServer.class);

    private final int           port;

    public static void main(String args[]) {
        int port = 8001;
        new EchoAioServer(port);
    }

    public EchoAioServer(int port) {
        this.port = port;
        listen();
    }

    private void listen() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(
                executorService, 1);

            try (AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel
                .open(threadGroup)) {

                server.bind(new InetSocketAddress(port));

                logger.info("Echo listen on " + port);

                server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

                    public void completed(AsynchronousSocketChannel result, Object attachment) {
                        // accept the next connection
                        server.accept(null, this);

                        // handle this connection
                        final ByteBuffer echoBuffer = ByteBuffer.allocateDirect(1024);

                        logger.info("waiting ....");
                        try {
                            echoBuffer.clear();
                            int size = result.read(echoBuffer).get();
                            logger.info("size = {}", size);

                            echoBuffer.flip();
                            byte[] bs = new byte[size];
                            echoBuffer.get(bs);

                            String s = new String(bs, "utf-8");
                            logger.info("rec: {}", s);

                            echoBuffer.clear();

                            result.write(ByteBuffer.wrap("hello from server".getBytes()));

                            /*
                            echoBuffer.flip();
                            // echo data
                            result.write(echoBuffer);
                            echoBuffer.flip();
                            //System.out.println("Echoed '" + new String(echoBuffer.array()) + "' to " + result);
                            
                            */
                        } catch (InterruptedException | ExecutionException e) {
                            logger.error(e.getMessage(), e);
                        } catch (UnsupportedEncodingException e) {
                            logger.error("", e);
                        } finally {
                            try {
                                logger.info("finally");
                                result.close();
                            } catch (Exception e) {
                                logger.info(e.toString());
                            }
                        }

                        logger.info("done...");
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        logger.error("", exc);
                    }
                });

                try {
                    // Wait for ever
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException ex) {
                    logger.error(ex.getMessage(), ex);
                }
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
