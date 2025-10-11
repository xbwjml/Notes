package com.nio.buffer;

import com.utils.LogUtils;

import java.nio.ByteBuffer;

public class BufferTest1 {

    public static void main(String[] args) {
        ByteBuffer buf1 = ByteBuffer.allocate(1024);
        LogUtils.log(buf1.isDirect());

        ByteBuffer buf2 = ByteBuffer.allocateDirect(1024);
        LogUtils.log(buf2.isDirect());
    }
}
