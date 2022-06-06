package com.yue.learning.io.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class ChartServer {

    public static void main(String[] args) {
        try {
            startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startServer() throws Exception{
        //1 创建Selector
        Selector selector = Selector.open();
        //2 创建 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //4 设置非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //5 绑定Selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端已启动");

        //6 循环遍历 Selector 状态
        for (;;){
            int select = selector.select();
            if (select==0) continue;
            //6.1 取出SelectionKey集合,进行迭代
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                //6.2 移除集合中当前SelectionKey
                iterator.remove();

                if (selectionKey.isAcceptable()){
                    //6.3 如果是acceptable状态
                    acceptOperator(serverSocketChannel,selector);
                }
                if (selectionKey.isReadable()){
                    //6.4 如果是readable状态
                    readOperator(selector,selectionKey);
                }
            }
        }
    }

    //处理可读状态
    private static void readOperator(Selector selector, SelectionKey selectionKey) throws Exception{
        //1 从 SelectionKey 中取出 channel
        SocketChannel channel = (SocketChannel)selectionKey.channel();
        //2 创建 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3 读取消息
        String msg = "";
        int read = channel.read(buffer);
        if (read>0){
            buffer.flip();
            msg+= StandardCharsets.UTF_8.decode(buffer);
        }

        //4 将新 channel 注册到 Selector,监听其后续可读状态
        channel.register(selector,SelectionKey.OP_READ);

        //5 广播到其他客户端
        if (msg.length()>0){
            System.out.println(msg);
            cast2OtherClient(msg,selector,channel);
        }
    }

    //广播消息
    private static void cast2OtherClient(String msg, Selector selector, SocketChannel originChannel) throws IOException {
        //1 取出所有已经接入的 channel
        Set<SelectionKey> keys = selector.keys();
        //2 遍历 广播
        for(SelectionKey key:keys){
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel && channel!= originChannel){
                ((SocketChannel) channel).write(StandardCharsets.UTF_8.encode(msg));
            }
        }

    }

    //处理接入状态
    private static void acceptOperator(ServerSocketChannel serverSocketChannel, Selector selector) throws Exception{
        //1 接入SocketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        //2 设置非阻塞
        socketChannel.configureBlocking(false);
        //3 注册
        socketChannel.register(selector,SelectionKey.OP_READ);
        //4 接入成功提示信息
        socketChannel.write(StandardCharsets.UTF_8.encode("欢迎来到聊天室.请注意隐私安全"));
    }
}
