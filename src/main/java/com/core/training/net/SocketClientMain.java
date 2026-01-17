package com.core.training.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author huangyulu
 * @Date 2026/1/14 15:44
 * @Description client
 */
public class SocketClientMain {

    /*
    * Socket（套接字）是网络通信的基本构建块，它允许不同计算机之间通过网络进行数据交换。

    在 Java 中，java.net.Socket 类提供了实现网络通信的客户端功能。

    你可以把 Socket 想象成两个电话之间的连接：

    一端是客户端（打电话的人）
    另一端是服务器（接电话的人）
    连接建立后，双方就可以互相发送和接收信息

    *
    *
    * */

    public static void main(String[] args) {
        // 连接ip+端口
        try(ServerSocket socket = new ServerSocket(8080)) {


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
