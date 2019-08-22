package demo.proa.a.clients;

import com.alibaba.fastjson.JSONObject;
import demo.proa.a.SysPropsAA;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
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

            @Override
            public JSONObject getOneWithDelayAC(int ms) {
                String url = String.format("http://%s/api/ab/delay/ac/%d", props.getServerAB(), ms);
                String result = null;
                try {
                    result = restTemplate.getForEntity(url, String.class).getBody();
                } catch (RestClientException e) {
                    /* FIX ME 调用方ab不可用, 临时方案*/
                    JSONObject resultJson = new JSONObject();
                    JSONObject exJson = new JSONObject();
                    exJson.put("className", e.getClass().getName());
                    exJson.put("message", e.getMessage());
                    exJson.put("stackTrace", ExceptionUtils.getStackTrace(e));
                    resultJson.put("exception", exJson);
                    return resultJson;
                }
                return JSONObject.parseObject(result);
            }
        };
    }

}
