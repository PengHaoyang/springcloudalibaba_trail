package demo.logio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: penghaoyang
 * @Date: 2019/12/14 17:25
 * @Description: ApplicationDemoLogio
 */
@SpringBootApplication
public class ApplicationDemoLogio implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemoLogio.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ok, bye");
    }
}
