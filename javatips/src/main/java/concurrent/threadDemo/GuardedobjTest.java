package concurrent.threadDemo;

import utils.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class GuardedObj {
    private Object response;
    public Object get() {
        synchronized (this) {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return response;
        }
    }

    public void complete(Object obj) {
        synchronized (this) {
            this.response = obj;
            this.notifyAll();
        }
    }
}

public class GuardedobjTest {
    public static void main(String[] args) {
        GuardedObj guardedObj = new GuardedObj();
        new Thread(() -> {
            LogUtils.log("等待结果");
            Object o = guardedObj.get();
            LogUtils.log("结果大小 : " + ((List) o).size());
        }, "t1").start();

        new Thread(() -> {
            LogUtils.log("开始下载");
            try {
                List<String> list = download();
                LogUtils.log("下载完毕");
                guardedObj.complete(list);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
    }
    public static List<String> download() throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL("https://www.google.com/").openConnection();
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
