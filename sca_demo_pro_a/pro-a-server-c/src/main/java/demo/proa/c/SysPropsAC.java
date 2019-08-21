package demo.proa.c;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:49
 * @Description: SysPropsAC
 */
@Configuration
public class SysPropsAC {

    @Value("${demo.my.id}")
    private String id;

    @Value("${demo.my.restConnectTimeout:500}")
    private String restConnectTimeout;

    @Value("${demo.my.restReadTimeout:500}")
    private String restReadTimeout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestConnectTimeout() {
        return restConnectTimeout;
    }

    public void setRestConnectTimeout(String restConnectTimeout) {
        this.restConnectTimeout = restConnectTimeout;
    }

    public String getRestReadTimeout() {
        return restReadTimeout;
    }

    public void setRestReadTimeout(String restReadTimeout) {
        this.restReadTimeout = restReadTimeout;
    }
}
