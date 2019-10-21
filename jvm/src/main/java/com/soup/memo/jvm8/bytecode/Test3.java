package com.soup.memo.jvm8.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * <p>
 * Description:
 * 对于Java类中每一个实例方法（非static方法），编译后所生成的字节码中，方法参数的数量总是比源代码中方法参数的数量多一个，这个多出的就是this,
 * 它位于方法的第一个参数
 * 这样就可以在Java的实例方法中使用this来访问当前对象的属性以及其他方法
 *
 * 这个操作是在编译期间完成的，即由javac编译的时候对this的访问转化为对一个普通方法参数的访问，接下来在运行期间，由jvm在调用实例方法时，
 * 自动向实例方法传入该this参数
 * 所以在实例方法的局部变量表中，至少会有一个指向当前对象的局部变量
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-26 23:14
 * @since 1.0
 */
public class Test3 {
    public void test() {
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(999);
            serverSocket.accept();
        }  catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
