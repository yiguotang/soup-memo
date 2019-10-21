package com.soup.memo.jvm8.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * <p>
 * Description: 自定义类加载器
 * * </p>
 *
 * @author zhaoyi
 * @date 2019-02-02 15:30
 * @since 1.0
 */
public class MyClassLoader extends ClassLoader {

    private String classLoaderName;

    private String path;

    public MyClassLoader(String classLoaderName) {
        // 将系统类加载器当作该类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName) {
        // 显示指定类的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("finde class invoked: " + className);
        System.out.println("class load name: " + this.classLoaderName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            className = className.replace(".", "\\");

            is = new FileInputStream(new File(this.path + className + ".class"));
            baos = new ByteArrayOutputStream();

            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader1 = new MyClassLoader("loader1");
        //classLoader.setPath("D:/VCS/Git/dev/dev-jvm/out/production/classes");
        // 删除默认classpath下的ClassLoad1.class文件，让从指定的path中加载class
        classLoader1.setPath("D:\\Documents\\Desktop\\");
        Class<?> clazz = classLoader1.loadClass("com.dev.jvm.classloader.ClassLoad1");
        System.out.println("clazz: " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        /*System.out.println("---类的加载：命名空间---");

        // MyClassLoader loader = new MyClassLoader("loader2");
        MyClassLoader classLoader2 = new MyClassLoader(classLoader1, "loader2");
        classLoader2.setPath("D:\\Documents\\Desktop\\");
        Class<?> clazz2 = classLoader2.loadClass("com.dev.jvm.classloader.ClassLoad1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);
        System.out.println(object2.getClass().getClassLoader());

        System.out.println();

        MyClassLoader classLoader3 = new MyClassLoader("loader3");
        classLoader3.setPath("D:\\Documents\\Desktop\\");
        Class<?> clazz3 = classLoader3.loadClass("com.dev.jvm.classloader.ClassLoad1");
        System.out.println("class: " + clazz2.hashCode());
        Object object3 = clazz3.newInstance();
        System.out.println(object3);
        System.out.println(object3.getClass().getClassLoader());*/

        System.out.println("---类的卸载---");

        // 模拟类的卸载
        classLoader1 = null;
        clazz = null;
        obj = null;
        System.gc();
        Thread.sleep(2000);


        classLoader1 = new MyClassLoader("loader4");
        classLoader1.setPath("D:\\Documents\\Desktop\\");
        clazz = classLoader1.loadClass("com.dev.jvm.classloader.ClassLoad1");
        System.out.println("clazz: " + clazz.hashCode());
        obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}
