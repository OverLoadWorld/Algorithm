import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 18-12-23 下午10:23
 */
public class Reflect {
    public static void main(String... args) {

        /*Class c1 = "foo".getClass();
        System.out.println(c1.getName());
        System.out.println(c1.getTypeName());
//        Class c2 = System.console().getClass();
//        System.out.println(c2.getName());
//        System.out.println(c2.getTypeName());
        Class c3 = E.A.getClass();
        System.out.println(c3.getName());
        System.out.println(c3.getTypeName());
        byte[] bytes = new byte[1024];
        Class c4 = bytes.getClass();
        System.out.println(c4.getName());
        System.out.println(c4.getTypeName());
        Set<String> s = new HashSet<String>();
        Class c5 = s.getClass();
        System.out.println(c5.getName());
        System.out.println(c5.getTypeName());
        boolean b;
        //Class c6 = b.getClass();   // compile-time error
        Class c7 = boolean.class;  // correct
        System.out.println(c7.getName());
        System.out.println(c7.getTypeName());
        Class c8 = java.io.PrintStream.class;
        System.out.println(c8.getName());
        System.out.println(c8.getTypeName());
        Class c9 = int[][][].class;
        System.out.println(c9.getName());
        System.out.println(c9.getTypeName());
//        Class c10 = Class.forName("com.duke.MyLocaleServiceProvider");
//        System.out.println(c10.getName());
//        System.out.println(c10.getTypeName());
        Class cDoubleArray = Class.forName("[D");
        Class cButyArray = Class.forName("[B");
        Class cIntArray = Class.forName("[[[I");

        Class cStringArray = Class.forName("[[Ljava.lang.String;");

        System.out.println(cDoubleArray.getName());
        System.out.println(cDoubleArray.getTypeName());
        System.out.println(cButyArray.getName());
        System.out.println(cButyArray.getTypeName());
        System.out.println(cIntArray.getName());
        System.out.println(cIntArray.getTypeName());
        System.out.println(cStringArray.getName());
        System.out.println(cStringArray.getTypeName());

        Double de = 2D;
        Class cde = de.getClass();
        System.out.println(cde.getName());
        System.out.println(cde.getTypeName());

        Class cdde = Double.TYPE;
        System.out.println(cdde.getName());
        System.out.println(cdde.getTypeName());

        Class cVoid = Void.TYPE;
        System.out.println(cVoid.getName());
        System.out.println(cVoid.getTypeName());

        Class csuper = java.util.AbstractList.class.getSuperclass();
        System.out.println(csuper.getName());
        System.out.println(csuper.getTypeName());

        System.out.println("++++++++++++++");

        Class<?>[] cs = Character.class.getClasses();
        for (int i = 0; i < cs.length; i++) {
            Class<?> c = cs[i];
            System.out.println(c.getTypeName());
        }

        System.out.println("++++++++++++++");

        Class<?>[] cd = Character.class.getDeclaredClasses();

        for (int i = 0; i < cd.length; i++) {
            Class<?> c = cd[i];
            System.out.println(c.getTypeName());
        }

        System.out.println("++++++++++++++");
        Field f = System.class.getField("out");
        Class cf = f.getDeclaringClass();
        System.out.println(cf.getTypeName());

        Class c = Thread.State.class.getEnclosingClass();
        System.out.println(c.getTypeName());*/
        try {
            Class<?> c = Class.forName(args[0]);
            out.format("Class:%n  %s%n%n", c.getCanonicalName());
            out.format("Modifiers:%n  %s%n%n",
                    Modifier.toString(c.getModifiers()));

            out.format("Type Parameters:%n");
            TypeVariable[] tv = c.getTypeParameters();
            if (tv.length != 0) {
                out.format("  ");
                for (TypeVariable t : tv)
                    out.format("%s ", t.getName());
                out.format("%n%n");
            } else {
                out.format("  -- No Type Parameters --%n%n");
            }

            out.format("Implemented Interfaces:%n");
            Type[] intfs = c.getGenericInterfaces();
            if (intfs.length != 0) {
                for (Type intf : intfs)
                    out.format("  %s%n", intf.toString());
                out.format("%n");
            } else {
                out.format("  -- No Implemented Interfaces --%n%n");
            }

            out.format("Inheritance Path:%n");
            List<Class> l = new ArrayList<Class>();
            printAncestor(c, l);
            if (l.size() != 0) {
                for (Class<?> cl : l)
                    out.format("  %s%n", cl.getCanonicalName());
                out.format("%n");
            } else {
                out.format("  -- No Super Classes --%n%n");
            }

            out.format("Annotations:%n");
            Annotation[] ann = c.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    out.format("  %s%n", a.toString());
                out.format("%n");
            } else {
                out.format("  -- No Annotations --%n%n");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }
}
