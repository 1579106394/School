package com.school.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 时间在表中使用字符串形式，因此生成当前时间需要使用该类
 * 有需要新增时间操作工具方法全部写在这里
 *
 * @author 杨德石
 * @date 2018/11/02
 */
public class DateUtils {

    /**
     * 返回当前时间
     * @return
     */
    public static String newDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = sdf.format(new Date());
        return time;
    }

}
