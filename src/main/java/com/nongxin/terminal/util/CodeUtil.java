package com.nongxin.terminal.util;

import com.nongxin.terminal.util.enumUtil.common.CodeEnum;

import java.util.Calendar;

/**
 * 编号生成
 */
public class CodeUtil {

    public static String getCode(CodeEnum codeEnum){
        Calendar cale = Calendar.getInstance();
        String code = cale.get(Calendar.YEAR)+""+String.format("%02d", (cale.get(Calendar.MONTH)+1))
                +""+String.format("%02d", cale.get(Calendar.DATE))+(int)((Math.random()*9+1)*10000);
        return codeEnum+code;
    }

}
