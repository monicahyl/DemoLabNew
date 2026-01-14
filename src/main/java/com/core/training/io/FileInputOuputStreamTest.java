package com.core.training.io;

import java.io.*;

/**
 * @Author huangyulu
 * @Date 2026/1/14 13:54
 * @Description
 */
public class FileInputOuputStreamTest {

    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + File.separator + "src/main/resources/files/file.txt";
        String pathOut = System.getProperty("user.dir") + File.separator + "src/main/resources/files/fileOut.txt";

        try(FileInputStream fis = new FileInputStream(path)) {
            byte[] bytes = new byte[1024];
            int len = fis.read(bytes); // 有效字节
            while (len != -1) {
                try(FileOutputStream fos = new FileOutputStream(pathOut)) {
                    fos.write(bytes, 0, len);

                    len = fis.read(bytes);
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
