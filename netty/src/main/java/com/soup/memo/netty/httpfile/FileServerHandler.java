package com.soup.memo.netty.httpfile;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 文件服务处理端
 *
 * @author zhaoyi
 */
@Slf4j
public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    private static final String CR = System.getProperty("line.separator");

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String filePath) throws Exception {
        File file = new File(filePath);
        if (file.exists()) {
            if (!file.isFile()) {
                ctx.writeAndFlush("Not a file: " + file + CR);
                return;
            }

            ctx.write(file + " " + file.length() + CR);
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
            // 传输文件使用了 DefaultFileRegion 进行写入到 NioSocketChannel 中
            // 不使用ByteBuffer是因为使用FileChannel的transferTo方法可以减少2次IO拷贝：
            // 第一次 IO拷贝：读取文件的时间从系统内存中拷贝到 jvm 内存中。
            // 第二次 IO拷贝：从 jvm 内存中写入 Socket 时，再 Copy 到系统内存中。
            FileRegion fileRegion = new DefaultFileRegion(randomAccessFile.getChannel(), 0, randomAccessFile.length());
            ctx.write(fileRegion);
            ctx.writeAndFlush(CR);
        } else {
            ctx.writeAndFlush("File not found: " + filePath + CR);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("{}", cause);
        ctx.close();
    }
}
