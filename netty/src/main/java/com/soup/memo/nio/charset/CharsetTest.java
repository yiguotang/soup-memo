package com.soup.memo.nio.charset;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author zhaoyi
 * @description 测试Java字符集编码
 * @date 2019-04-06 23:56
 **/
public class CharsetTest {

    public static void main(String[] args) throws Exception {
        String inputFile = "charset_in.txt";
        String outputFile = "charset_out.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputFileChannal = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannal = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputFileChannal.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);


        System.out.println("===========查看本系统的支持编码============");

        Charset.availableCharsets().forEach((k, v) -> System.out.println(k + ", " + v));

        System.out.println("=======================");

        // 这里使用iso-8859-1编码，还是可以正常
        Charset charset = Charset.forName("iso-8859-1");
        // 构建解码器
        CharsetDecoder decoder = charset.newDecoder();
        // 构建编码器
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);
        System.out.println(charBuffer.get(12));
        //ByteBuffer outputData = encoder.encode(charBuffer);
        ByteBuffer outputData = Charset.forName("utf-8").encode(charBuffer);

        outputFileChannal.write(outputData);

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();
    }
}
