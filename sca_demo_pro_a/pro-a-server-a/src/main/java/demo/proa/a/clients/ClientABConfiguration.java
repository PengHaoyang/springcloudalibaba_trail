package demo.proa.a.clients;

import com.alibaba.fastjson.JSONObject;
import demo.proa.a.SysPropsAA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:45
 * @Description: ClientABConfiguration
 */
@Configuration
public class ClientABConfiguration {

    @Autowired
    private SysPropsAA props;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IClientAB restClientAB() {
        return new IClientAB() {
            @Override
            public JSONObject getOne() {
                String url = String.format("http://%s/api/ab", props.getServerAB());
                String result = restTemplate.getForEntity(url, String.class).getBody();
                return JSONObject.parseObject(result);
            }
        };
    }

}
