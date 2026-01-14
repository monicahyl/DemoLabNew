package com.core.training.io;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author huangyulu
 * @Date 2026/1/14 11:00
 * @Description
 *
 * File：
 * 专门对文件进行操作的类，只能对文件本身进行操作，不能对文件内容进行操作
 * 文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作
 */
public class FileTest {

    public static void main(String[] args) {
        // user.dir = JVM 启动时的“工作目录（Working Directory）”
        // 你从哪里启动这个 Java 程序
//        String property = System.getProperty("user.dir");
//        System.out.println(property);

        // /Users/huangyulu/IdeaProjects/github-project/DemoLabNew


        String path = System.getProperty("user.dir") + File.separator + "src/main/resources/files/file.txt";

        // File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建
//        File file = new File(path);
//        System.out.println(file.exists());


        // 父子路径，构建file对象
//        String parentDir = System.getProperty("user.dir");
//        String childPath = "/src/main/resources/files/file.txt";
//        File file1 = new File(parentDir, childPath);
//        System.out.println(file1.exists());


        //
//        File parentDir = new File(System.getProperty("user.dir"));
//        String child = "file.txt";
//        File file = new File(parentDir, child);
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());


//        File file = new File(path);
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath()); // File的绝对路径名字符串
//        System.out.println(file.getPath()); // File转换为路径名字符串
//        System.out.println(file.getName()); // File表示的文件或目录的名称
//        System.out.println(file.length()); // File表示的文件的长度
        // 文件不存在，也不影响代码执行，因为构造函数不对文件是否存在进行校验


        String filePath  = System.getProperty("user.dir") + File.separator + "src/main/resources/files/file20260114.txt";
        File file1 = new File(filePath);
//        boolean newFile = false;
//        try {
//            newFile = file1.createNewFile(); // 文件不存在，创建一个新的空文件并返回true，文件存在，不创建文件并返回false
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(newFile);

//        boolean delete = file1.delete();
//        System.out.println(delete);

//        String fileDir = System.getProperty("user.dir") + File.separator + "src/main/resources/files/2026/01/14";
//        File file = new File(fileDir);
//        boolean mkdir = file.mkdir();
//        System.out.println(mkdir);
//        file.delete();
//        boolean mkdirs = file.mkdirs();
//        System.out.println(mkdirs);
//        file.delete();
//        file.deleteOnExit();


        String basePath = System.getProperty("user.dir") + File.separator + "src/main/resources/";
        File file = new File(basePath);
        // 获取当前目录下的文件以及文件夹的名称
//        System.out.println(file.exists());
//        String[] list = file.list();
//        if (list != null && list.length > 0) {
//            for (int i = 0; i < list.length; i++) {
//                System.out.println(list[i]);
//            }
//        }


        //获取当前目录下的文件以及文件夹对象，只要拿到了文件对象，那么就可以获取更多信息
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].isFile());
        }


    }


}
