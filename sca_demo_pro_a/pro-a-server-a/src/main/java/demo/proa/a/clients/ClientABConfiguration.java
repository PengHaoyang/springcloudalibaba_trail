package demo.proa.a.clients;

import com.alibaba.fastjson.JSONObject;
import demo.proa.a.SysPropsAA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
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
    @LoadBalanced
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(Integer.valueOf(props.getRestConnectTimeout()));
        requestFactory.setReadTimeout(Integer.valueOf(props.getRestReadTimeout()));
        return new RestTemplate(requestFactory);
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

            @Override
            public JSONObject getOneWithDelay(int ms) {
                String url = String.format("http://%s/api/ab/delay/each/%d", props.getServerAB(), ms);
                String result = restTemplate.getForEntity(url, String.class).getBody();
                return JSONObject.parseObject(result);
            }
        };
    }

}
