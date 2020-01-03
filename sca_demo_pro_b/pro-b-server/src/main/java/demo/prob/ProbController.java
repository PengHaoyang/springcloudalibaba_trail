package demo.prob;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/3 15:06
 * @Description: ProbController
 */
@RestController
@RequestMapping("/api")
public class ProbController {

    @Autowired
    private ProbService probService;

    @RequestMapping("/peek")
    public ResponseEntity<String> peekData(){
        Map<String, Pojob> data = probService.peekData();
        return ResponseEntity.ok(JSONObject.toJSONString(data, true));
    }

}
