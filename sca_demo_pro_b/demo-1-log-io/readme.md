#### 19.12.15

> 08:12

spring boot

控制台程序

简单打印日志功能

使用log4j2

Q: 日志框架是否会生效？

---

> 09:46

引入`spring-boot-starter`实现没有web功能的springboot终端程序，
- 主方法使用和web相同，标记`@SpringBootApplication`；但这里要实现`CommandLineRunner`接口；
- 启动程序，运行完`CommandLineRunner.run`后程序立即停止
- application.yml照样生效,读取各starter自动配置

引入`spring-shell-starter`实现cli功能
- 默认不需要任何系统配置
- 程序在`CommandLineRunner.run`之前阻塞，
- 持续与终端交互，直到结束指令收到，执行`CommandLineRunner.run`方法



