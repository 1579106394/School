package com.school.utils;

import com.school.constant.BaseConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驼峰和下划线转换
 *
 * @author 杨德石
 * @date 2018/11/28
 */
public class ParamUtils {

    private static Pattern p = Pattern.compile("[A-Z]");

    /**
     * 方法说明 :将首字母和带 _ 后第一个字母 转换成大写
     */
    public static String upperTable(String str) {
        // 字符串缓冲区
        // 如果字符串包含 下划线
        if (str.contains(BaseConstant.UNDER_LINE)) {
            StringBuffer sbf = new StringBuffer();
            // 按下划线来切割字符串为数组
            String[] split = str.split("_");
            // 循环数组操作其中的字符串
            for (int i = 0, index = split.length; i < index; i++) {
                // 递归调用本方法
                String upperTable = upperTable(split[i]);
                // 添加到字符串缓冲区
                sbf.append(upperTable);
            }
            return sbf.toString();
        }
        // 返回
        return str;
    }

    /**
     * 小写转大写
     */
    public static String upperCharToUnderLine(String param) {

        if (param == null || "".equals(param)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if (BaseConstant.UNDER_LINE.equals(builder.charAt(0))) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}
