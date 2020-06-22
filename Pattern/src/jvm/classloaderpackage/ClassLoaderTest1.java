package jvm.classloaderpackage;

import com.sun.net.ssl.internal.ssl.Provider;
import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/17 15:26
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("=============启动类加载器=======");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        System.out.println(Provider.class.getClassLoader());

        System.out.println("============扩展类加载器=======");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String s : extDirs.split(";")) {
            System.out.println(s);
        }

        System.out.println(CurveDB.class.getClassLoader());
    }
}
