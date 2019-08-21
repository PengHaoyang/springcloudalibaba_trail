package demo.proa.a.clients;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:54
 * @Description: IClientAB
 */
public interface IClientAB {

    JSONObject getOne();

    JSONObject getOneWithDelay(int ms);

}
