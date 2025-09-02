package com.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtils {

    public static void log(Object s) {
        LocalDateTime now = LocalDateTime.now();
        String datePrefix = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        Thread thread = Thread.currentThread();

        System.out.println("[" +datePrefix + "]:"
                + "[" + thread.getStackTrace()[2].getClassName()+ ":" + thread.getStackTrace()[2].getLineNumber() + "]"
                + "[线程:" + thread.getId() + " -> " + thread.getName() + "]:"
                + " " + String.valueOf(s));
    }
}
