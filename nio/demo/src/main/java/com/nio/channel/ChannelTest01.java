package com.nio.channel;

import com.utils.LogUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelTest01 {
    public static void main(String[] args) {
        try (FileInputStream fos = new FileInputStream("resources/data1.txt")) {
            FileChannel channel = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello! 必胜".getBytes(StandardCharsets.UTF_8));

            buffer.flip();
            channel.write(buffer);
            channel.close();
            LogUtils.log("写数据到文件中");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
