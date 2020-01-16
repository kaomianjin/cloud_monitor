package com.jinkun.cloud_monitor.utils;

import java.util.regex.Pattern;

/***
 * @ClassName: StringUtils
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/11/12 16:41
 * @version : V1.0
 */
public class StringUtils {

    /**
     * 合法E-mail地址：     
     * 1. 必须包含一个并且只有一个符号“@”    
     * 2. 第一个字符不得是“@”或者“.”
     * 3. 不允许出现“@.”或者.@   
     * 4. 结尾不得是字符“@”或者“.”    
     * 5. 允许“@”前的字符中出现“＋” 
     * 6. 不允许“＋”在最前面，或者“＋@” 
     */
    public static boolean validEmail(String email){

        String regex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return Pattern.compile(regex).matcher(email).find();
    }
    /**
     * 验证是否合法的手机号
     * @param phone
     * @return
     */
    public static boolean validPhone(String phone) {

        String regex="^1[3578]{1}\\d{9}$";
        return Pattern.compile(regex).matcher(phone).find();
    }

    /**
     @Author juzhic
     @Date 16:44 2019/11/12
     @version : V1.0
     @Description 是否为null或空串
    */
    public static boolean isNullOrEmpty(String str){
        if(str==null||str.trim().isEmpty()){
            return true;
        }
        return false;
    }

}
