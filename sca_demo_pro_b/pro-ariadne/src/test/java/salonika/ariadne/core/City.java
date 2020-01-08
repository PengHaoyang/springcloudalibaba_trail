package salonika.ariadne.core;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 14:02
 * @Description: BasicPlace
 */
class BasicPlace {
    /** key 就是key */
    String key = "good one"; /* 这是注释 */
}

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 14:01
 * @Description: City
 */
public class City extends BasicPlace {
   /** name 就是名字 */
   private String name; /* 这也是注释 */
   public String show(int num){
       int temp= 12 * num; // 临时的值
       for (int i = 0; i < 10; i++) { // 循环
           System.out.println("haha");
       }
       String str1 = JSONObject.toJSONString(temp); // 调用方法
       return name + str1 + key; // 加起来
   }
}