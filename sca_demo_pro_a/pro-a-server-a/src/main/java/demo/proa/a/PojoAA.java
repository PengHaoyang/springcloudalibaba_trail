package demo.proa.a;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:34
 * @Description: PojoAA
 */
public class PojoAA {

    private String fieldAA1;

    private String fieldAA2;

    private int fieldAA3;

    private Map<String, Object> fieldAAMap = new JSONObject();

    public String getFieldAA1() {
        return fieldAA1;
    }

    public void setFieldAA1(String fieldAA1) {
        this.fieldAA1 = fieldAA1;
    }

    public String getFieldAA2() {
        return fieldAA2;
    }

    public void setFieldAA2(String fieldAA2) {
        this.fieldAA2 = fieldAA2;
    }

    public int getFieldAA3() {
        return fieldAA3;
    }

    public void setFieldAA3(int fieldAA3) {
        this.fieldAA3 = fieldAA3;
    }

    public Map<String, Object> getFieldAAMap() {
        return fieldAAMap;
    }

    public void setFieldAAMap(Map<String, Object> fieldAAMap) {
        this.fieldAAMap = fieldAAMap;
    }
}
