package demo.proa.b;

import demo.proa.b.clients.IClientAC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:52
 * @Description: ServiceAB
 */
@Service
public class ServiceAB {

    @Autowired
    private SysPropsAB props;

    @Autowired(required = false)
    private IClientAC clientAC;

    @Autowired
    private ServiceInstance serviceInstance;

    public PojoAB getOne() {
        PojoAB p = new PojoAB();
        p.setFieldAB1(props.getId() + ":" + serviceInstance.getUri().toString());
        p.setFieldAB2(Instant.now().toString());
        p.setFieldAB3(Instant.now().getNano());
        p.setFieldAB4(Instant.now().getEpochSecond());
        p.getFieldABMap().put("ac", clientAC.getOne());
        return p;
    }

    public PojoAB getOneWithDelay(int ms) throws InterruptedException {
        if(ms > 0){
            Thread.sleep(ms);
        }

        PojoAB p = new PojoAB();
        p.setFieldAB1(props.getId() + ":" + serviceInstance.getUri().toString());
        p.setFieldAB2(Instant.now().toString());
        p.setFieldAB3(Instant.now().getNano());
        p.setFieldAB4(Instant.now().getEpochSecond());
        p.getFieldABMap().put("ac", clientAC.getOneWithDelay(ms));
        return p;
    }

    public PojoAB getOneWithDelayAC(int ms) throws InterruptedException {
        PojoAB p = new PojoAB();
        p.setFieldAB1(props.getId() + ":" + serviceInstance.getUri().toString());
        p.setFieldAB2(Instant.now().toString());
        p.setFieldAB3(Instant.now().getNano());
        p.setFieldAB4(Instant.now().getEpochSecond());
        p.getFieldABMap().put("ac", clientAC.getOneWithDelay(ms));
        return p;
    }

}
