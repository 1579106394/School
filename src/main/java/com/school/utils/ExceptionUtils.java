package com.school.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 获取异常堆栈信息的工具类
 *
 * @author
 * @date
 */
public class ExceptionUtils {

    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
