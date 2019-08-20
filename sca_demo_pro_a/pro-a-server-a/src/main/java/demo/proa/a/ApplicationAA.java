package demo.proa.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:59
 * @Description: ApplicationAA
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationAA {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAA.class, args);
    }

}
