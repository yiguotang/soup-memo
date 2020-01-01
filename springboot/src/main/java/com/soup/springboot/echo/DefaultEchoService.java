package com.soup.springboot.echo;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-01-01 17:26
 * @since 1.0
 */
public class DefaultEchoService implements EchoService {

    private final String echoFormat;

    public DefaultEchoService(String echoFormat) {
        this.echoFormat = null != echoFormat ? echoFormat : "%s";
    }

    @Override
    public String getMessage(String message) {
        return String.format(this.echoFormat, message);
    }
}
