package com.soup.memo.netty.privateprotocol;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * MarshallingCodec 工厂方法
 *
 * @author zhaoyi
 */
public class MarshallingCodecFactory {

    /**
     * 通过 Marshalling 工具类的 getProvidedMarshallerFactory
     * 静态方法获取MarshallerFactory 实例, 参数 serial 表示创建的是 Java 序列化工厂对象.它是由
     * jboss-marshalling-serial 包提供
     */
    private static final MarshallerFactory MARSHALLER_FACTORY;
    private static final MarshallingConfiguration CONFIGURATION;

    static {
        MARSHALLER_FACTORY = Marshalling.getProvidedMarshallerFactory("serial");
        CONFIGURATION = new MarshallingConfiguration();
        CONFIGURATION.setVersion(5);
    }


    public static NettyMarshallingDecoder buildMarshallingDecoder() {
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(MARSHALLER_FACTORY, CONFIGURATION);
        return new NettyMarshallingDecoder(provider, 1024 << 2);
    }

    public static NettyMarshallingEncoder buildMarshallingEncoder() {
        MarshallerProvider provider = new DefaultMarshallerProvider(MARSHALLER_FACTORY, CONFIGURATION);
        return new NettyMarshallingEncoder(provider);
    }
}
