package com.yue.learning.io.javanio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ChartClient {

    public static void main(String[] args) {
        try {
            startClient("XHH");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startClient(String name) throws Exception{
        //1 新建 SocketChannel 连接到服务器
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        socketChannel.configureBlocking(false);

        //2 把 SocketChannel 注册到 selector 中
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ);

        //3 开启新线程,监听Selector中channel的就绪状态
        new Thread(new ClientHandler(selector)).start();

        //4 获取控制台输入,发送到服务端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String msg = scanner.nextLine();
            if (msg.length()>0)
            socketChannel.write(StandardCharsets.UTF_8.encode(name+":"+msg));
        }

    }

    static class ClientHandler implements Runnable {

        private Selector selector;

        public ClientHandler(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int select = selector.select();
                    if (select==0)  continue;
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if (selectionKey.isReadable()){
                            readOperator(selector,selectionKey);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private void readOperator(Selector selector, SelectionKey selectionKey) throws Exception{
            //1 从SelectionKey 中获取就绪的channel
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

            //2 创建buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(byteBuffer);
            String msg = "";
            if (read>0) {
                byteBuffer.flip();
                msg+= StandardCharsets.UTF_8.decode(byteBuffer);
            }
            if (msg.length()>0){
                System.out.println(msg);
            }
        }
    }
}
