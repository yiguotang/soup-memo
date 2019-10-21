package com.soup.memo.jvm8.classloader.context;

import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-06 22:41
 * @since 1.0
 */
public class ContextTest3 {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        for (Driver driver : loader) {
            System.out.println("driver: " + driver.getClass() + ", classLoader: " + driver.getClass().getClassLoader());
        }

        System.out.println("currentThreadContextClassLoader: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader's classLoader: " + ServiceLoader.class.getClassLoader());
    }
}
