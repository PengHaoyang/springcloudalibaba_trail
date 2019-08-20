package demo.proa.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:49
 * @Description: SysPropsAA
 */
@Configuration
public class SysPropsAA {

    @Value("${demo.my.id}")
    private String id;

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
}
