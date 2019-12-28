package com.jinkun.cloud_monitor.utils;

/***
 * @ClassName: AssertUtil
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/3 11:57
 * @version : V1.0
 */
public class AssertUtil {

    public static void  isTrue(boolean flag,String message){
        if (flag){
         throw new RuntimeException(message);
        }
    }
}
