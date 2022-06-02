package com.yue.learning.io.javanio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//FileChannel读测试
public class FileChannelReadTest {

    public static void main(String[] args) throws Exception{
        try (RandomAccessFile file = new RandomAccessFile("d:\\javaio\\01.txt","rw");){

            FileChannel fileChannel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            int num = fileChannel.read(byteBuffer);

            while (num!=-1){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
                num = fileChannel.read(byteBuffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
