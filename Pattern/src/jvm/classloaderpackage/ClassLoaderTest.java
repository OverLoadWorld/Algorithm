package jvm.classloaderpackage;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/17 14:56
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@1b6d3586

        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println(bootClassLoader);//null

        ClassLoader classLoaderTestClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoaderTestClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        System.out.println(String.class.getClassLoader());//null
    }
}
