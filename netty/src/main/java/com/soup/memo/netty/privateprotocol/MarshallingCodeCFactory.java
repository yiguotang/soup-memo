package com.soup.memo.netty.privateprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * 消息编码工具
 *
 * @author zhaoyi
 */
public class MarshallingCodeCFactory {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    /**
     * 通过 Marshalling 工具类的 getProvidedMarshallerFactory
     * 静态方法获取MarshallerFactory 实例, 参数 serial 表示创建的是 Java 序列化工厂对象.它是由
     * jboss-marshalling-serial 包提供
     */
    private static final MarshallerFactory MARSHALLER_FACTORY;
    private static final MarshallingConfiguration CONFIGURATION;
    private static final UnmarshallerProvider PROVIDER;

    static {
        MARSHALLER_FACTORY = Marshalling.getProvidedMarshallerFactory("serial");
        CONFIGURATION = new MarshallingConfiguration();
        CONFIGURATION.setVersion(5);
        PROVIDER = new DefaultUnmarshallerProvider(MARSHALLER_FACTORY, CONFIGURATION);
    }

    private Marshaller marshaller;

    public MarshallingCodeCFactory() {

    }

    protected void encode(Object msg, ByteBuf out) throws Exception {
        try {
            int lengthPos = out.writerIndex();
            out.writeBytes(LENGTH_PLACEHOLDER);

        } finally {
            marshaller.close();
        }
    }

    public static MarshallingDecoder buildMarshallingDecoder() {

        /*
         * provider : 提供商
         * maxSize : 单个对象最大尺寸
         */
        MarshallingDecoder decoder = new MarshallingDecoder(PROVIDER, 1024 << 2);
        return decoder;
    }

    public static MarshallingEncoder buildMarshallingEncoder() {
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(MARSHALLER_FACTORY, configuration);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }
}
