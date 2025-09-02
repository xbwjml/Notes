package com.bio.day1;

import com.utils.LogUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动了===");
            ServerSocket ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String msg;
            while ((msg = br.readLine()) != null) {
                LogUtils.log("服务端接收到 : " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
