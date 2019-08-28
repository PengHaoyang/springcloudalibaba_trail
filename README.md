<<<<<<< HEAD
# sca_trail

#### 介绍
spring cloud alibaba 组件实验demo项目

#### 软件架构
软件架构说明


#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 使用说明

1. xxxx
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

=======
# spring cloud alibaba leaning

> CNCF 将云原生定义为在“现代动态环境”中运行的“可扩展应用程序”，这些应用程序使用容器、微服务和声明性 API 等技术

## 搭建 spring cloud 简单项目

### demo 准备

#### 1. 准备 spring boot 项目，1pom3module, 每个module都是一个服务

#### 2. 准备 spring boot 项目，额外2pom，1个带sdk，1个不带

#### 3. 定义各服务的主要接口，定义服务间传递的结果封装，实现rest调用关系
每个服务包含的基本功能：
* 该服务特有的pojo，用于定义1实体数据
* 作为服务端开放该pojo表示的资源操作（增删改查）
* 作为客户端调用其他某些服务端的资源操作

### 服务发现

#### 4. 实现注册中心（eureka/nacos，这里选择后者）

#### 5. sb服务转为sc服务，服务注册

### ribbon

#### 6. 添加负载均衡

#### 7. 调用服务的声明修改

### feign 和 hystrix

#### 8. 修改restTemplate调用为feign声明式调用

#### 9. 添加
>>>>>>> master
