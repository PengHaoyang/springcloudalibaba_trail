## spring cloud alibaba leaning

#### 19.12.17

实现了log4j2的打印日志
 
暂时都打印到了同一个日志文件下

#### 19.12.14-2

这次要实验一些日志框架

#### 19.12.14-1

最初目的：实验spring cloud alibaba 的各个组件

++不过目录也可以做其他框架的实验++

#### 19.08.28

到这一刻创建了三个项目，并验证了nacos作为服务注册中心、ribbon客户端负载均衡、feign声明式restful接口调用功能

* `sca_demo_pro_a` 包含三个子模块，`pro-a-server-a`、`pro-a-server-b`、`pro-a-server-a` 用于实验同一个父pom下的子pom各自作为服务时，使用sca互相调用的实现
调用的关系是

```
graph LR
pro-a-server-a-->pro-a-server-b
pro-a-server-b-->pro-a-server-c
pro-a-server-a-->pro-a-server-c
```

* `sca_demo_pro_b` 有独立的pom，视作没有公共源码的不同服务，之间仅仅靠restful来交与a的服务交互；待完成

* `sca_demo_pro_c` 也有独立的pom，视作没有公共源码的不同服务，但会实现client代码，供a的服务依赖；待完成 
