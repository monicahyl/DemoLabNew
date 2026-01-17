package com.core.training.io;

import java.io.*;

/**
 * @Author huangyulu
 * @Date 2026/1/14 14:01
 * @Description
 * 字符流的由来：
 * 因为数据编码的不同，因而有了对字符进行高效操作的流对象，
 * 字符流本质其实就是基于字节流读取时，
 * 去查了指定的码表，而字节流直接读取数据会有乱码的问题（读中文会乱码）
 */
public class ReaderTest {

    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + File.separator + "src/main/resources/files/reader.txt";

        try(FileInputStream fis = new FileInputStream(path)) {
            int read = fis.read();
            while (read != -1) {
                System.out.print((char) read);
                read = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileReader fileReader = new FileReader(path)) {
            int read = fileReader.read();
            while (read != -1) {
                System.out.println((char) read);
                read = fileReader.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
