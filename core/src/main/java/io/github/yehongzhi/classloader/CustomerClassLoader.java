package io.github.yehongzhi.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name CustomerClassLoader
 * @date 2020-09-03 22:54
 **/
public class CustomerClassLoader extends ClassLoader {

    private String path;

    public CustomerClassLoader(String path) {
        this.path = path;
    }

    /**
     * 加载类
     *
     * @param name 类的全路径
     * @return Class<?>
     * @author Ye hongzhi
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //获取class文件，转成字节码数组
        byte[] data = getData();
        if (data != null) {
            //将class的字节码数组转换成Class类的实例
            clazz = defineClass(name, data, 0, data.length);
        }
        //返回Class对象
        return clazz;
    }

    private byte[] getData() {
        File file = new File(path);
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(file);
                 ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                byte[] buffer = new byte[1024];
                int size;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }
                return out.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
