package com.memo.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.util.ClassUtils;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class WebApplicationTypeDeduceTest {

    private static final String[] SERVLET_INDICATOR_CLASSES = { "javax.servlet.Servlet",
            "org.springframework.web.context.ConfigurableWebApplicationContext" };

    private static final String WEBMVC_INDICATOR_CLASS = "org.springframework.web.servlet.DispatcherServlet";

    private static final String WEBFLUX_INDICATOR_CLASS = "org.springframework.web.reactive.DispatcherHandler";

    private static final String JERSEY_INDICATOR_CLASS = "org.glassfish.jersey.servlet.ServletContainer";

    private static final String SERVLET_APPLICATION_CONTEXT_CLASS = "org.springframework.web.context.WebApplicationContext";

    private static final String REACTIVE_APPLICATION_CONTEXT_CLASS = "org.springframework.boot.web.reactive.context.ReactiveWebApplicationContext";

    @Test
    public void deduceFromClasspathTest() {
        log.info("WEBFLUX_INDICATOR_CLASS: {}", ClassUtils.isPresent(WEBFLUX_INDICATOR_CLASS, null));
        log.info("WEBMVC_INDICATOR_CLASS: {}", ClassUtils.isPresent(WEBMVC_INDICATOR_CLASS, null));

        for (String className : SERVLET_INDICATOR_CLASSES) {
            log.info("{} isPresent: {}", className, ClassUtils.isPresent(className, null));
        }
    }
}
