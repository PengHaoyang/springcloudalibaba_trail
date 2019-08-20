package demo.proa.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:59
 * @Description: ApplicationAB
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationAB {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAB.class, args);
    }

}
