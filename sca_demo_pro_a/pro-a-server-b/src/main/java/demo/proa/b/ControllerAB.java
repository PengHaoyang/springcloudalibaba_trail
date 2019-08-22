package demo.proa.b;

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
 * @Description: ControllerAB
 */
@RestController
@RequestMapping("/api")
public class ControllerAB {

    @Autowired
    private ServiceAB serviceAB;

    @GetMapping("/ab")
    public ResponseEntity<String> getAB() {
        PojoAB one = serviceAB.getOne();
        return ResponseEntity.ok(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

    @GetMapping("/ab/delay/each/{ms}")
    public ResponseEntity<String> getAAWithDelay(@PathVariable("ms") int ms) throws InterruptedException {
        PojoAB one = serviceAB.getOneWithDelay(ms);
        return ResponseEntity.ok(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

    @GetMapping("/ab/delay/ac/{ms}")
    public ResponseEntity<String> getAAWithDelayAC(@PathVariable("ms") int ms) throws InterruptedException {
        PojoAB one = serviceAB.getOneWithDelayAC(ms);
        return ResponseEntity.ok(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

}
