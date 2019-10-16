package com.soup.memo.nio.selector;

import com.google.common.collect.Maps;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author zhaoyi
 * @description nio网络编程服务端
 * @date 2019-04-06 17:18
 **/
public class NioServer {

    private static Map<String, SocketChannel> clientMap = Maps.newHashMap();

    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket Channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 配置channel为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 获取服务端的一个serverSocket对象
        ServerSocket serverSocket = serverSocketChannel.socket();

        // 将服务端的socket对象绑定端口
        serverSocket.bind(new InetSocketAddress(8899));

        // 创建selector对象
        Selector selector = Selector.open();
        // 将ServerSocketChannel对象注册到Selector上
        // 选择器Selecotor可以注册多个ServerSocketChannel，本例中只有一个ServerSocketChannel
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 注册完成后，开始进行事件处理，在服务端就是一个死循环
        while (true) {
            try {
                // 进行Selector方法的select()方法
                selector.select();

                // 获取selectionKey的集合
                // SelectionKey不仅可以获取到对应的事件的集合，而且反过来通过它获取事件的channel
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel clinet;
                    try {
                        if (selectionKey.isAcceptable()) {
                            // 表示客户端向服务端发起了连接请求，我们可以通过SelectionKey获取事件的ServerSocketChannel对象，调用accept()方法，将服务器端与客户端连接的channel对象注册到Selector对象上
                            // 这里一定是ServerSocketChannel对象，因为在上面的服务端的SelectionKey的OP_ACCEPT的类型是ServerSocketChannel
                            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                            clinet = server.accept();
                            clinet.configureBlocking(false);
                            // 此时Selector上注册了两个channel，一个是ServerSocketChannel，一个是SocketChannel
                            clinet.register(selector, SelectionKey.OP_READ);

                            // 将客户端信息注册到服务端，即让服务端记录客户端的信息，让信息进行分发
                            String key = "【" + UUID.randomUUID().toString() + "】";
                            clientMap.put(key, clinet);
                        } else if (selectionKey.isReadable()) {
                            // 客户端是否发送数据，进行可读数据的读取操作
                            // 这里强转成SocketChannel，是注册read的时候使用的是SocketChannel对象
                            clinet = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = clinet.read(readBuffer);
                            if (count > 0) {
                                // 有数据发送过来，开始写数据到buffer
                                readBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receivedMessage = String.valueOf(charset.decode(readBuffer).array());

                                System.out.println(clinet + ": " + receivedMessage);

                                String senderKey = null;
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (clinet == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }

                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put((senderKey + ": " + receivedMessage + "\n").getBytes());
                                    writeBuffer.flip();
                                    value.write(writeBuffer);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                selectionKeys.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
