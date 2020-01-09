package salonika.ariadne.core.sample;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 14:02
 * @Description: BasicPlace
 */
class BasicPlace {
    /** key 就是key */
    String key = "good one"; /* 这是注释 */
    {
        long y = 1222L + 3555L;
        int x = (int) (54 + (y * 24));
        key = "nice one";
        System.out.println("begin BasicPlace, " + x);
    }
}

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 14:01
 * @Description: City
 */
public class City extends BasicPlace {
    static {
        int x = 34 * 16;
        System.out.println("begin City, " + x);
    }
    @Autowired
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
