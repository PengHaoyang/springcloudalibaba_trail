package demo.proa.b;

import demo.proa.b.clients.IClientAC;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IClientAC clientAC;

    public PojoAB getOne() {
        PojoAB p = new PojoAB();
        p.setFieldAB1(props.getId());
        p.setFieldAB2(Instant.now().toString());
        p.setFieldAB3(Instant.now().getNano());
        p.setFieldAB4(Instant.now().getEpochSecond());
        p.getFieldABMap().put("ac", clientAC.getOne());
        return p;
    }

}
