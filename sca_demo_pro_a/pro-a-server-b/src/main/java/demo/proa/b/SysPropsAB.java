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
}
