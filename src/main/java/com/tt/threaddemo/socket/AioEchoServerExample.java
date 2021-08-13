package com.tt.threaddemo.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

/**
 * 异步IO socket 实现
 *
 * @author hansiyuan
 * @date 2021年07月07日 10:17
 */
public class AioEchoServerExample {

    public static void main(String[] args) throws IOException {

        /*
         * 流程：
         *     1. 启动服务端进程 AsynchronousServerSocketChannel
         *        1.1 绑定端口
         *     2. accept () 方法监听客户端连接
         *             注：（BIO 中的 accept () 是完全阻塞当前线程的
         *                  NIO 中的 accept () 是通过 Accept 事件来实现的
         *                  而 AIO 中的 accept () 是完全异步的）
         *     3. accept () 方法的回调方法 complete () 中处理数据
         *
         */
        AsynchronousServerSocketChannel serverSocketChannel =
                AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8003));
        System.out.println("server start");
        serverSocketChannel.accept(null, new
                CompletionHandler<AsynchronousSocketChannel, Object>() {
                    @Override
                    public void completed(AsynchronousSocketChannel socketChannel, Object
                            attachment) {
                        try {
                            System.out.println("accept new conn: " +
                                    socketChannel.getRemoteAddress());
                            serverSocketChannel.accept(null, this);
                            while (true) {
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                Future<Integer> future = socketChannel.read(buffer);
                                if (future.get() > 0) {
                                    buffer.flip();
                                    byte[] bytes = new byte[buffer.remaining()];
                                    buffer.get(bytes);
                                    String content = new String(bytes, "UTF-8");
                                    if (content.equals("\r\n")) {
                                        continue;
                                    }
                                    System.out.println("receive msg: " + content);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("failed");
                    }
                });
        System.in.read();
    }
}
