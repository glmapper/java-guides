package com.glmapper.bridge.boot.metaspace;

import com.itranswarp.compiler.JavaStringCompiler;
import javassist.ClassPool;

import java.util.Map;

/**
 * @author guolei.sgl
 * @date 2021/3/25 4:09 下午
 * @since
 **/
public class MetaspaceTest {

    static JavaStringCompiler compiler = new JavaStringCompiler();

    static ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; ; i++) {
            userJavassist(i);
        }
    }

    /**
     * metaspace oom
     * @param i
     * @throws Throwable
     */
    public static void userJavassist(int i) throws Exception{
        Class c = classPool.makeClass("com.glmapper.bridge.boot.metaspace.DynamicClass" + i).toClass();
    }


    /**
     * 持续 full gc
     * @param i
     * @throws Exception
     */
    public static void useCompiler(int i) throws Exception {
        Map<String, byte[]> results = compiler.compile("DynamicClass"+i+".java", String.format(JAVA_SOURCE_CODE,i));
        Class<?> clazz = compiler.loadClass("com.glmapper.bridge.boot.metaspace.DynamicClass" + i, results);
    }

    static final String JAVA_SOURCE_CODE = "package com.glmapper.bridge.boot.metaspace;\n" +
            "\n" +
            "/**\n" +
            " * @author guolei.sgl\n" +
            " * @date 2021/3/25 4:25 下午\n" +
            " * @since\n" +
            " **/\n" +
            "public class DynamicClass%d {\n" +
            "    private static byte[] arr = new byte[10000000];\n" +
            "}\n";

}
