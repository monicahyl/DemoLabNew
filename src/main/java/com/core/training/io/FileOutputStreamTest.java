package com.core.training.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author huangyulu
 * @Date 2026/1/14 11:48
 * @Description 字节输出流
 *
 *
 * 我们必须明确一点的是，一切文件数据(文本、图片、视频等)在存储时，
 * 都是以二进制数字的形式保存，都一个一个的字节，那么传输时一样如此。
 * 所以，字节流可以传输任意文件数据。
 * 在操作流的时候，我们要时刻明确，无论使用什么样的流对象，底层传输的始终为二进制数据。
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src/main/resources/files/file.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, true);) {

            /*
            * 就以上面这句代码来讲，类似这样创建字节输出流对象都做了三件事情：
                1、调用系统功能去创建文件【输出流对象才会自动创建】
                2、创建outputStream对象
                3、把foutputStream对象指向这个文件
            *
            * */


//            fileOutputStream.write(65); A
//            fileOutputStream.write(97); a


//            byte[] bytes = new byte[]{65, 66, 67, 68, 69}; ABCDE
//            fileOutputStream.write(bytes);

            byte[] bytes = "\r\nhello,world".getBytes();
            fileOutputStream.write(bytes);


            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /*
    *
    * 方式一：try-with-resources（✅ 最推荐）
    * try (FileInputStream fis = new FileInputStream("a.txt")) {
            // 读文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 自动 close
    *
    *
    *
    *
    *
    *
    *
    *
    * */
}
