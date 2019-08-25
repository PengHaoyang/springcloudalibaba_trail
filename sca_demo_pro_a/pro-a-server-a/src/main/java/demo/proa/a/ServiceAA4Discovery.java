package demo.proa.a;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: penghaoyang
 * @Date: 2019/8/25 17:19
 * @Description: ServiceAA4Discovery
 */
@Service
public class ServiceAA4Discovery {

    /**
     * 提供当前服务实例信息
     */
    @Autowired
    private ServiceInstance serviceInstance;

    /**
     * 提供服务发现（来自服务中心）的服务实例信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @return 当前 （AA） 服务 中维护的（来自服务中心同步的）发现服务实例信息
     * 如 该DEMO中的 AB 服务， AC 服务 等
     */
    public JSONObject getDiscoveryDetail(){
        JSONObject discoveryDetail = new JSONObject();
        JSONObject serInsBrief = new JSONObject();

        discoveryDetail.put("instances", serInsBrief);
        List<String> serviceNames = discoveryClient.getServices(); /* 各发现服务的注册name */
        for (String sn : serviceNames) {
            List<ServiceInstance> instances = discoveryClient.getInstances(sn); /* 各发现服务的实例集合ServiceInstances  */
            serInsBrief.put(sn, instances);
        }

        discoveryDetail.put("description", discoveryClient.description());
        discoveryDetail.put("order", discoveryClient.getOrder());
        return discoveryDetail;
    }

    /**
     * @return 当前 （AA） 服务自己的服务实例信息
     */
    public JSONObject getSelfDetail(){
        return (JSONObject) JSONObject.toJSON(serviceInstance);
    }

    /**
     * @return 当前 （AA） 服务自己的 Uri 信息
     */
    public String getSelfUri(){
        return serviceInstance.getUri().toString();
    }

}
