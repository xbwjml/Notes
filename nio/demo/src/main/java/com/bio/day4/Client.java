package com.bio.day4;

import com.utils.LogUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);

        Scanner sc = new Scanner(System.in);
        while (true) {
            LogUtils.log("请输入");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
}
