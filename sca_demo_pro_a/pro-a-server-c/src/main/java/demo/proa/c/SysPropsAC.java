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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
