package demo.proa.c;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:34
 * @Description: PojoAA
 */
public class PojoAC {

    private String fieldAC1;

    private String fieldAC2;

    private int fieldAC3;

    private long fieldAC4;

    private String fieldAC5;

    private String fieldAC6;

    private Map<String, Object> fieldACMap = new JSONObject();

    public String getFieldAC1() {
        return fieldAC1;
    }

    public void setFieldAC1(String fieldAC1) {
        this.fieldAC1 = fieldAC1;
    }

    public String getFieldAC2() {
        return fieldAC2;
    }

    public void setFieldAC2(String fieldAC2) {
        this.fieldAC2 = fieldAC2;
    }

    public int getFieldAC3() {
        return fieldAC3;
    }

    public void setFieldAC3(int fieldAC3) {
        this.fieldAC3 = fieldAC3;
    }

    public long getFieldAC4() {
        return fieldAC4;
    }

    public void setFieldAC4(long fieldAC4) {
        this.fieldAC4 = fieldAC4;
    }

    public String getFieldAC5() {
        return fieldAC5;
    }

    public void setFieldAC5(String fieldAC5) {
        this.fieldAC5 = fieldAC5;
    }

    public String getFieldAC6() {
        return fieldAC6;
    }

    public void setFieldAC6(String fieldAC6) {
        this.fieldAC6 = fieldAC6;
    }

    public Map<String, Object> getFieldACMap() {
        return fieldACMap;
    }

    public void setFieldACMap(Map<String, Object> fieldACMap) {
        this.fieldACMap = fieldACMap;
    }
}
