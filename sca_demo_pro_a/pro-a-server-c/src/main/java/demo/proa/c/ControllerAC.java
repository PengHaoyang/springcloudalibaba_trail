package demo.proa.c;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:52
 * @Description: ControllerAA
 */
@RestController
@RequestMapping("/api")
public class ControllerAC {

    @Autowired
    private ServiceAC serviceAC;

    /**
     * 注意：这里定义的返回类型（ResponseEntity中的范型）要与Feign 接受的类型一致（实际上应该反过来描述- -）
     * @return ResponseEntity<JSONObject>
     */
    @GetMapping("/ac")
    public ResponseEntity<JSONObject> getAC() {
        PojoAC one = serviceAC.getOne();
        return ResponseEntity.ok((JSONObject) JSONObject.toJSON(one));
    }

    /**
     * 注意 同上
     * @param ms int 模拟延迟的毫秒数
     * @return ResponseEntity<JSONObject>
     * @throws InterruptedException emm...
     */
    @GetMapping("/ac/delay/each/{ms}")
    public ResponseEntity<JSONObject> getAAWithDelay(@PathVariable("ms") int ms) throws InterruptedException {
        PojoAC one = serviceAC.getOneWithDelay(ms);
        return ResponseEntity.ok((JSONObject) JSONObject.toJSON(one));
    }

}
