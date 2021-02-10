package com.serversys.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 熊志伟
 * 创建时间 2020/12/2 16:13
 * 描述
 */
public class JsonTest {
    public static void main(String[] args) {
        /*String obj = "{user_tel_:\"15071655305\",user_photo_:\"[{'id':'10001358110009','name':'p-9f0af6de.jpg','size':1695}]\"}";
        JSONArray jsonA = new JSONArray();
        jsonA.add(JSONObject.parse(obj));
        System.out.println(jsonA);
        String p = "[{\"id\":\"10001358110009\",\"name\":\"p-9f0af6de.jpg\",\"size\":1695}]";
        String a = p.replaceAll("\"","'");
        System.out.println(a);*/

        String str = "{\"STARTTIME\":\"2020-12-19\",\"HYZT\":\"菜市场2\",\"HYCYRY\":\"蔡青(10000001370090),测试2(10000010740073)\",\"HYFBDW\":\"肖调金(领导)\",\"HYZTC\":\"蔡青\",\"HYDZ\":\"622会议室\",\"HYJSSJ\":\"23:17\",\"HYLX\":\"0\",\"XZQDM\":\"410000\",\"HYLRRID\":\"10000001170008\",\"HYLSH\":\"410000-1607779034149\",\"HYCYRYNAME\":\"蔡青,测试2\",\"HYWJ\":[{\"id\":\"10000020290252\",\"name\":\"uz_icon.png\"},{\"id\":\"10000020290252\",\"name\":\"uz_icon.png\"},{\"id\":\"10000020290254\",\"name\":\"uz_splash_bg.png\"}],\"HYNR\":\"彩色电视\",\"NOTICE_TYPE\":\"1\",\"NOTICE_TIME_H\":\"0\",\"NOTICE_TIME_M\":\"15\",\"NOTICE_RIGHT_NOW\":\"1\",\"M_TYPE\":\"1\",\"MEETING_NOTES\":\"\",\"HYCYRYIDS\":\"10000001370090,10000010740073\",\"SENDBACK\":\"0\",\"HYKSSJ\":\"21:17\",\"TITLE_PAGE_FILE\":\"\",\"P_TYPE\":\"\",\"sub_OA_HYSSYQK_ST\":[{\"HYLSH\":\"410000-1607779034149\",\"HYSKEY\":\"622\",\"HYSSHZT\":0}],\"SYSTEM_ID\":\"\",\"HYCYKSID\":\"\",\"HYFBDWID\":\"10000001170008\",\"M_TYPE_TERM\":\"sort\",\"TERM_NUM\":\"\",\"TERM_EDIT_TYPE\":\"add-1\"}";
//        String[] split = str.split(",");
//        Map<String,Object> map = new HashMap<>(20);
//        for(String equalStr : split){
//            StringBuilder tempStr = new StringBuilder();
//            if(equalStr.contains("{")){
//                tempStr.append(equalStr.replace("{", ""));
//            }else if(equalStr.contains("}")){
//                tempStr.append(equalStr.replace("}", ""));
//            }else{
//                tempStr.append(equalStr);
//            }
//            String[] equalArr = tempStr.toString().split("=");
//            map.put(equalArr[0].trim(), "null".equals(equalArr[1].trim()) ? "" : equalArr[1].trim());
//        }
//        map.forEach((key,val) -> System.out.println("key:"+key+" + val:"+val));
//
        JSONObject json = JSONObject.parseObject(str);
        json.forEach((key,val) -> System.out.println("key:"+key+" + val:"+val));

    }

}
