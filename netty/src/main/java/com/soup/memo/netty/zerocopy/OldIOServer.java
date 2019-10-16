package com.soup.memo.netty.zerocopy;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaoyi
 * @description 传统方式，非零拷贝的方式
 * @date 2019-04-07 22:34
 **/
@Slf4j
public class OldIOServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket =serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] byteArray = new byte[4096];
            // 源源不断读取客户端的数据
            while (true) {
                int readCount = dataInputStream.read(byteArray, 0, byteArray.length);
                if (-1 == readCount) {
                    break;
                }
            }
        }
    }
}
