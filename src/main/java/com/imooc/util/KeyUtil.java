package com.imooc.util;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间毫秒数+六位随机数
     * @return
     */
    public synchronized static String genUniqueKey(){
        Random random = new Random();
        int num  = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
