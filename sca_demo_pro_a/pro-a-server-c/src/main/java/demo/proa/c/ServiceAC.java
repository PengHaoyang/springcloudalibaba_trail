package demo.proa.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:52
 * @Description: ServiceAA
 */
@Service
public class ServiceAC {

    @Autowired
    private SysPropsAC props;

    @Autowired
    private ServiceInstance serviceInstance;

    public PojoAC getOne() {
        PojoAC p = new PojoAC();
        p.setFieldAC1(props.getId() + ":" + serviceInstance.getUri().toString());
        p.setFieldAC2(Instant.now().toString());
        p.setFieldAC3(Instant.now().getNano());
        p.setFieldAC4(Instant.now().getEpochSecond());
        return p;
    }

    public PojoAC getOneWithDelay(int ms) throws InterruptedException {
        if(ms > 0){
            Thread.sleep(ms);
        }
        return getOne();
    }

}
