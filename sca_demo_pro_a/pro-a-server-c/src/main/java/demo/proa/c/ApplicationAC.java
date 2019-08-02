package demo.proa.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 14:59
 * @Description: ApplicationAC
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationAC {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAC.class, args);
    }

}
