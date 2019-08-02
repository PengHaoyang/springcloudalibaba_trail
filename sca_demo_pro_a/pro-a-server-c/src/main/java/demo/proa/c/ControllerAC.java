package demo.proa.c;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/ac")
    public ResponseEntity<JSONObject> getAC() {
        PojoAC one = serviceAC.getOne();
        return ResponseEntity.ok((JSONObject) JSONObject.toJSON(one));
    }

}
