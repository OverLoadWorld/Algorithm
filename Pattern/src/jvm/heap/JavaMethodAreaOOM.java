package jvm.heap;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class JavaMethodAreaOOM extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;

        try {
            JavaMethodAreaOOM test = new JavaMethodAreaOOM();
            for (int i = 0; i < 10000; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = classWriter.toByteArray();
                test.defineClass("Class" + i, code, 0, code.length);
                j++;
            }
        } finally {
            System.out.println(j);
        }
    }
}
