package demo.proa.b;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:49
 * @Description: SysPropsAB
 */
@Configuration
public class SysPropsAB {

    @Value("${demo.my.id}")
    private String id;

    @Value("${demo.my.restConnectTimeout:1000}")
    private String restConnectTimeout;

    @Value("${demo.my.restReadTimeout:1000}")
    private String restReadTimeout;

    @Value("${demo.serverAC.name}")
    private String serverAC;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerAC() {
        return serverAC;
    }

    public void setServerAC(String serverAC) {
        this.serverAC = serverAC;
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
