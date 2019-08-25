package demo.proa.a;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private ServiceAA4Discovery discovery;

    @GetMapping("/aa")
    public ResponseEntity<String> getAA() {
        PojoAA one = serviceAA.getOne();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

    @GetMapping("/aa/delay/each/{ms}")
    public ResponseEntity<String> getAAWithDelay(@PathVariable("ms") int ms) {
        PojoAA one = serviceAA.getOneWithDelay(ms);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }

    @GetMapping("/aa/delay/ac/{ms}")
    public ResponseEntity<String> getAAWithDelayAC(@PathVariable("ms") int ms) {
        PojoAA one = serviceAA.getOneWithDelayAC(ms);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(JSONObject.toJSONString(one, SerializerFeature.PrettyFormat));
    }


    /**
     * @return ResponseEntity<String> 当前 （AA） 服务 中维护的（来自服务中心同步的）发现服务实例信息
     * 如 该DEMO中的 AB 服务， AC 服务 等
     */
    @GetMapping("/aa/discovery/detail")
    public ResponseEntity<String> getAADiscoveryDetail() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(JSONObject.toJSONString(discovery.getDiscoveryDetail(), SerializerFeature.PrettyFormat));
    }

    /**
     * @return ResponseEntity<String> 当前 （AA） 服务自己的服务实例信息
     */
    @GetMapping("/aa/self/detail")
    public ResponseEntity<String> getAASelfDetail() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(JSONObject.toJSONString(discovery.getSelfDetail(), SerializerFeature.PrettyFormat));
    }

}
