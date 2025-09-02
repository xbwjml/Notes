package com.bio.day4;

import com.utils.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        LogUtils.log("server 启动");
        ServerSocket ss = new ServerSocket(9999);
        HandlerSockerServerPool pool = new HandlerSockerServerPool(3, 10);

        while (true) {
            Socket socket = ss.accept();
            ServerRunnable runnable = new ServerRunnable(socket);
            pool.execute(runnable);
        }
    }
}

class ServerRunnable implements Runnable {
    private Socket socket;
    public ServerRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            LogUtils.log("run ...");
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
