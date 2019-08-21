package demo.proa.a;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:52
 * @Description: ControllerAA
 */
@RestController
@RequestMapping("/api")
public class ControllerAA {

    @Autowired
    private ServiceAA serviceAA;

    @GetMapping("/aa")
    public ResponseEntity<String> getAA() {
        PojoAA one = serviceAA.getOne();
        return ResponseEntity.ok(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

    @GetMapping("/aa/delay/each/{ms}")
    public ResponseEntity<String> getAAWithDelay(@PathVariable("ms") int ms) throws InterruptedException {
        PojoAA one = serviceAA.getOneWithDelay(ms);
        return ResponseEntity.ok(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

}
