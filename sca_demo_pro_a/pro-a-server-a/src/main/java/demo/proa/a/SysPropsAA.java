package demo.proa.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:49
 * @Description: SysPropsAA
 */
@ConfigurationProperties
public class SysPropsAA {

    @Value("${demo.my.id}")
    private String id;

    @Value("${demo.my.restConnectTimeout:4000}")
    private String restConnectTimeout;

    @Value("${demo.my.restReadTimeout:4000}")
    private String restReadTimeout;

    @Value("${demo.serverAB.name}")
    private String serverAB;

    @Value("${demo.serverAC.name}")
    private String serverAC;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerAB() {
        return serverAB;
    }

    public void setServerAB(String serverAB) {
        this.serverAB = serverAB;
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
