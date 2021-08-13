package com.tt.threaddemo.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞IO Socket demo
 *
 * @author hansiyuan
 * @date 2021年07月06日 16:49
 */
@Slf4j
public class BioEchoServerExample {

    public static void main(String[] args) throws IOException {
        /*
         * 流程：
         *      1. 启动了一个服务端 ServerSocket
         *      2. 开启循环接收客户端
         *      3. 接收客户端Socket，存储并进行后续读写
         *      4. 启动新线程，处理Socket（保证可以同时处理多个客户端）
         * 弊端：
         *      每来一个客户端连接都要分配一个线程，如果客户端一直增加，服务端线程会无限增加，直到服务器资源耗尽
         */
        // 1. 启动了一个服务端 ServerSocket
        ServerSocket serverSocket = new ServerSocket(8999);
        log.info("ServerSocket 服务开启......");
        // 2. 开启循环接收客户端
        while (true) {
            // 3. 接收客户端Socket，存储并进行后续读写
            Socket socket = serverSocket.accept();
            log.info("新的客户端 {} 连接上", socket);
            // 4. 启动新线程，处理Socket（保证可以同时处理多个客户端）
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(socket.getInputStream()));
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println("receive msg: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
