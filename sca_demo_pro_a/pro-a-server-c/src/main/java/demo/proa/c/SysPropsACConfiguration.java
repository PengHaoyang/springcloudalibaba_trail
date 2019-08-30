package demo.proa.c;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: penghaoyang
 * @Date: 2019/8/30 14:06
 * @Description: SysPropsACConfiguration
 */
@Configuration
@EnableConfigurationProperties(SysPropsAC.class)
public class SysPropsACConfiguration {
}
