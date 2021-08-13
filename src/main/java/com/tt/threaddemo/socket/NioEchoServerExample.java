package com.tt.threaddemo.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hansiyuan
 * @date 2021年07月06日 17:25
 */
@Slf4j
public class NioEchoServerExample {
    public static void main(String[] args) throws IOException {
        /*
         * 实现原理： Java 中的 NIO 使用的是 IO 多路复用技术实现的
         *      IO 多路复用的概念： 多个 IO 操作共同使用一个 selector（选择器）去询问哪些 IO 准备好了，
         *                         selector 负责通知那些数据准备好了的 IO，它们再自己去请求内核数据。
         * 流程：
         *       1. 创建IO多路复用器
         *       2. 启动 服务端 ServerSocketChannel
         *          2.1 配置是否阻塞
         *          2.2 绑定端口
         *          2.3 注册到多路复用器上
         *       3. Selector 循环（相当于服务员收集需求）
         *          3.1 获取 selectedKeys
         *          3.2 遍历执行（事件类型）
         * 弊端/优点：
         *      1. 始终只有一个线程，并没有启动额外的线程来处理每个连接的事务，解决了 BIO线程无限增加的问题，所以，NIO 是非常高效的。
         *      2. 连接非常多的情况下，有可能一次 Select 拿到的 SelectionKey 非常多，而且取数据本身还要把数据从内核空间拷贝到用户空间，
         *         这是一个阻塞操作，这时候都放在主线程中来遍历所有的SelectionKey 就会变得非常慢了（线程池可解决）
         *
         */

        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8999));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        log.info("Socket 服务开启.....");
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel)
                            selectionKey.channel();
                    SocketChannel socketChannel = ssc.accept();
                    System.out.println("accept new conn: " +
                            socketChannel.getRemoteAddress());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel)
                            selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int length = socketChannel.read(buffer);
                    if (length > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String content = new String(bytes, StandardCharsets.UTF_8).replace("\r\n", "");
                        System.out.println("receive msg: " + content);
                    }
                }
                iterator.remove();
            }
        }
    }
}
