package demo.proa.b.clients;

import com.alibaba.fastjson.JSONObject;
import demo.proa.b.SysPropsAB;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                JSONObject result = null;
                try {
                    result = restTemplate.getForEntity(url, JSONObject.class).getBody();
                } catch (Exception e) {
                    /* FIX ME 调用方ac不可用, 临时方案*/
                    result = new JSONObject();
                    JSONObject exJson = new JSONObject();
                    exJson.put("className", e.getClass().getName());
                    exJson.put("message", e.getMessage());
                    exJson.put("stackTrace", ExceptionUtils.getStackTrace(e));
                    result.put("exception", exJson);
                }
                return result;
            }
        };
    }

    /**
     * 定义 Feign 客户端, 使用了 hystrix FallbackFactory, 加载方法见对应的配置类
     * 详细的配置, 见 application.yml 的 feign.client.config
     */
    @FeignClient(
            value = "server-ac",
            fallbackFactory = FeignClientACFallbackFactory.class,
            configuration = FeignClientACConfiguration.class
    )
//    @RequestMapping("/api") /* 这个不能用 */
    public interface IFeignClientAC extends IClientAC {

        /**
         * 和定义endpoint 的地方声明一致, 唯一不同的是 Mapping的路径(因为Feign类上的@RequestMapping不能用)
         * @return JSONObject
         */
        @Override
        @GetMapping("/api/ac")
        JSONObject getOne();

        @Override
        @GetMapping("/api/ac/delay/each/{ms}")
        JSONObject getOneWithDelay(@PathVariable("ms") int ms);
    }

    /**
     * 提供 hystrix Fallback 工厂类的实例Bean
     * 暂不由 Spring 的方式定义，直接由 OpenFeign 的方式定义，
     * 详见 @FeignClient 注解类
     */
    static class FeignClientACConfiguration {
        @Bean
        public FeignClientACFallbackFactory echoServiceFallback() {
            return new FeignClientACFallbackFactory();
        }
    }

    /**
     * IFeignClientAC 的 hystrix Fallback 工厂类
     * 需要一个 Configuration 类 来提供 hystrix Fallback 工厂类的实例Bean
     */
    static class FeignClientACFallbackFactory implements FallbackFactory<ClientACConfiguration.IFeignClientAC> {

        /**
         * Returns an instance of the fallback appropriate for the given cause
         *
         * @param cause Throwable
         */
        @Override
        public ClientACConfiguration.IFeignClientAC create(Throwable cause) {
            return new ClientACConfiguration.IFeignClientAC() {

                private JSONObject getFallbackResult(Throwable cause){
                    JSONObject result = new JSONObject();
                    JSONObject exJson = new JSONObject();
                    exJson.put("hystrixFallback", Boolean.TRUE);
                    exJson.put("className", cause.getClass().getName());
                    exJson.put("message", cause.getMessage());
                    exJson.put("stackTrace", ExceptionUtils.getStackTrace(cause));
                    result.put("exception", exJson);
                    return result;
                }

                @Override
                public JSONObject getOne() {
                    return getFallbackResult(cause);
                }

                @Override
                public JSONObject getOneWithDelay(int ms) {
                    return getFallbackResult(cause);
                }
            };
        }
    }
}
