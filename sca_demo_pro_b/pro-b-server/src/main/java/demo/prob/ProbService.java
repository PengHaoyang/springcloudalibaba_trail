package demo.prob;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/3 15:07
 * @Description: ProbService
 */
@Service
public class ProbService {

    private Map<String, Pojob> data = new HashMap<>();

    @PostConstruct
    public void init(){
        for (int i = 0; i < 20; i++) {
            Pojob pojoB = Pojob.builder()
                    .fieldB1("value1-" + i)
                    .fieldB2("value2-" + i)
                    .fieldB3(i)
                    .fieldB4(i + 100000)
                    .fieldB5("value-" + i)
                    .build();
            pojoB.setFieldBMap(new HashMap<>());
            for (int j = 0; j < 30; j++) {
                pojoB.getFieldBMap().put("fieldB-" + j, "sub-value-" + j);
            }
            data.put(pojoB.getFieldB1(), pojoB);
        }
    }

    public Map<String, Pojob> peekData() {
        return new HashMap<>(data);
    }

}
