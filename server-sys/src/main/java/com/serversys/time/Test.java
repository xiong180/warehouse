package com.serversys.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        //取时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date now = new Date();
//        System.out.println("当前时间：" + sdf.format(now));
//        Calendar nowTime = Calendar.getInstance();
//        nowTime.add(Calendar.HOUR, 0);
//        System.out.println(nowTime.getTime());
//        String s = "1.0";
//        double f = Double.parseDouble(s);
//
//        int a = (int)Math.ceil(f);
//        System.out.println( a);

//        Calendar nowTime = Calendar.getInstance();
//        String format = "yyyy-MM-dd HH:mm:ss";
//        Date sendDate = new SimpleDateFormat(format).parse("2020-09-15 11:05:12");
//        System.out.println("发送时间：" + sdf.format(sendDate));
//
//        Date startTime = nowTime.getTime();
//        nowTime.add(Calendar.MINUTE,2);
//        System.out.println("开始时间：" + sdf.format(startTime));
//        System.out.println("结束时间：" + sdf.format(nowTime.getTime()));
//        System.out.println(isEffectiveDate(sendDate, startTime, nowTime.getTime()));

//        JSONObject jsonObject = JSONObject.fromObject(planJson);

        StringBuilder str = new StringBuilder("81");
        StringBuilder str2 = new StringBuilder();
        int l = str.length();
        for(int i=0;i<4-l;i++){
            str2.append("0");
        }
        str2.append(str);
        System.out.println(str2);
        int i = Integer.parseInt(str2.toString());
        System.out.println(i);
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }
}
