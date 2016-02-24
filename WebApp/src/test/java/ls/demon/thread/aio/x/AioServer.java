/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.thread.aio.x;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AioServer.java, v 0.1 2016年2月24日 下午4:00:40 song.li@witontek.com Exp $
 */
public class AioServer {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(AioServer.class);

    public static void main(String[] args) {
        try {
            ExecutorService taskService = Executors.newCachedThreadPool();
            ExecutorService executorService = Executors.newCachedThreadPool();

            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(
                executorService, 1);

            final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel
                .open(threadGroup);
            server.bind(new InetSocketAddress(8001));
            logger.info("server start on port 8001");

            for (;;) {
                Future<AsynchronousSocketChannel> f = server.accept();
                final AsynchronousSocketChannel socket = f.get();

                logger.info("new con {}", socket);

                taskService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                            buffer.clear();

                            final SocketAddress ra = socket.getRemoteAddress();

                            socket.read(buffer, null, new CompletionHandler<Integer, Object>() {
                                @Override
                                public void completed(Integer result, Object attachment) {
                                    logger.info("{} size = {}", ra, result);

                                    buffer.flip();
                                    byte[] bs = new byte[result];
                                    buffer.get(bs);
                                    String s = new String(bs);
                                    logger.info("{} rec = {}", ra, s);

                                    buffer.clear();

                                    if (StringUtils.equals("exit", s)) {
                                        socket.write(ByteBuffer.wrap("bye".getBytes()));
                                        try {
                                            socket.close();
                                            logger.info("{} socket closed.", ra);
                                        } catch (IOException e) {
                                            logger.error("", e);
                                        }
                                        logger.info("{} end", ra);
                                        return;
                                    } else {
                                        socket.write(ByteBuffer.wrap("hello".getBytes()));
                                        socket.read(buffer, null, this);
                                        logger.info("{} continue", ra);
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, Object attachment) {
                                    logger.error(exc.getMessage(), exc);
                                }
                            });
                        } catch (Exception e) {
                            logger.error("", e);
                        }
                    }
                });

            }

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
