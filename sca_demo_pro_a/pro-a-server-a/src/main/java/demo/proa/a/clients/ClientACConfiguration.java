package demo.proa.a.clients;

import com.alibaba.fastjson.JSONObject;
import demo.proa.a.SysPropsAA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:45
 * @Description: ClientACConfiguration
 */
@Configuration
public class ClientACConfiguration {

    @Autowired
    private SysPropsAA props;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public IClientAC restClientAC() {
        return new IClientAC() {
            @Override
            public JSONObject getOne() {
                String url = String.format("http://%s/api/ac", props.getServerAC());
                String result = restTemplate.getForEntity(url, String.class).getBody();
                return JSONObject.parseObject(result);
            }

            @Override
            public JSONObject getOneWithDelay(int ms) {
                String url = String.format("http://%s/api/ac/delay/each/%d", props.getServerAC(), ms);
                String result = restTemplate.getForEntity(url, String.class).getBody();
                return JSONObject.parseObject(result);
            }
        };
    }
}
