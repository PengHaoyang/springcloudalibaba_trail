package demo.proa.b.clients;

import com.alibaba.fastjson.JSONObject;
import demo.proa.b.SysPropsAB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:45
 * @Description: ClientACConfiguration
 */
@Configuration
public class ClientACConfiguration {

    @Autowired
    private SysPropsAB props;

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

//    @Bean
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
                JSONObject result = restTemplate.getForEntity(url, JSONObject.class).getBody();
                return result;
            }
        };
    }

    @FeignClient(value = "server-ac")
//    @RequestMapping("/api") /* 这个不能用 */
    public interface IFeignClientAC extends IClientAC {

        /**
         * 和定义endpoint 的地方声明一致, 唯一不同的是 Mapping的路径(因为Feign类上的@RequestMapping不能用)
         * @return
         */
        @Override
        @GetMapping("/api/ac")
        JSONObject getOne();

        @Override
        @GetMapping("/api/ac/delay/each/{ms}")
        JSONObject getOneWithDelay(@PathVariable("ms") int ms);
    }
}
