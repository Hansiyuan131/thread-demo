package com.tt.threaddemo.socket;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author hansiyuan
 * @date 2021年07月07日 10:48
 */
public class FileChannelExample {
    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = new RandomAccessFile("D:\\MyCode\\tt\\thread-demo\\src\\main\\java\\com\\tt\\threaddemo\\socket\\ChatServer.java",
                "rw").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        while ((fileChannel.read(buffer)) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                int remain = buffer.remaining();
                byte[] bytes = new byte[remain];
                buffer.get(bytes);
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
            }
            buffer.clear();
        }
    }
}
