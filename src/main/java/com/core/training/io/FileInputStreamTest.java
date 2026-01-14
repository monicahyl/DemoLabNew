package com.core.training.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author huangyulu
 * @Date 2026/1/14 12:06
 * @Description
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src/main/resources/files/file.txt";

        try(FileInputStream fis = new FileInputStream(path)) {
            int read = fis.read();
            System.out.println(read);
            System.out.println((char)read);


            // -1: 代表读到文件末尾
            while(read != -1) {
                System.out.print((char)read);
                read = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
