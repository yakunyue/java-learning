package com.yue.learning.io.javanio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//FileChannel写测试
public class FileChannelWriteTest {

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile("d:\\javaio\\01.txt", "rw");) {

            FileChannel fileChannel = file.getChannel();

            System.out.println("position:"+fileChannel.position());
            System.out.println("size:"+fileChannel.size());

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("test FileChannelWrite!".getBytes());

            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {

                int num = fileChannel.write(byteBuffer);
                System.out.println("num:"+num);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
