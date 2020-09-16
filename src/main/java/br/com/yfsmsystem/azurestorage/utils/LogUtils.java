package br.com.yfsmsystem.azurestorage.utils;

public class LogUtils {

    public static void logInfo(String log, Object... params) {
        System.out.println(String.format(log, params));
    }

    public static void logError(String log, Object... params) {
        System.err.println(String.format(log, params));
    }

}
