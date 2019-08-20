package demo.proa.b;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:34
 * @Description: PojoAB
 */
public class PojoAB {

    private String fieldAB1;

    private String fieldAB2;

    private int fieldAB3;

    private long fieldAB4;

    private Map<String, Object> fieldABMap = new JSONObject();

    public String getFieldAB1() {
        return fieldAB1;
    }

    public void setFieldAB1(String fieldAB1) {
        this.fieldAB1 = fieldAB1;
    }

    public String getFieldAB2() {
        return fieldAB2;
    }

    public void setFieldAB2(String fieldAB2) {
        this.fieldAB2 = fieldAB2;
    }

    public int getFieldAB3() {
        return fieldAB3;
    }

    public void setFieldAB3(int fieldAB3) {
        this.fieldAB3 = fieldAB3;
    }

    public long getFieldAB4() {
        return fieldAB4;
    }

    public void setFieldAB4(long fieldAB4) {
        this.fieldAB4 = fieldAB4;
    }

    public Map<String, Object> getFieldABMap() {
        return fieldABMap;
    }

    public void setFieldABMap(Map<String, Object> fieldABMap) {
        this.fieldABMap = fieldABMap;
    }
}
