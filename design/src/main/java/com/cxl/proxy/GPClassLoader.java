package com.cxl.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//代码生成、编译、重新动态load到JVM
public class GPClassLoader extends ClassLoader{

    private File baseDir;

    public GPClassLoader(){
        String basePath = GPClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);   //保存路径
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;   //找到这个class文件
        if(baseDir != null){
            File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];   //缓冲区
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }  //全部读完
                    return defineClass(className, out.toByteArray(), 0,out.size());  //搞到jvm中去

                }catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    if(null != in){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null != out){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    classFile.delete();
                }

            }
        }

        return null;
    }

}