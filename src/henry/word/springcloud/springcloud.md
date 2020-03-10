# SpringCloud笔记

## 一、SpringCloud简介
Spring提供了一系列工具，可以帮助开发人员迅速搭建分布式系统中的公共组件（比如：配置管理，服务发现，断路器，智能路由，微代理，控制总线，一次性令牌，全局锁，主节点选举， 分布式session, 集群状态）。协调分布式环境中各个系统，为各类服务提供模板性配置。使用SpringCloud， 开发人员可以搭建实现了这些样板的应用，并且在任何分布式环境下都能工作得非常好，小到笔记本电脑， 大到数据中心和云平台。

SpringCloud官网的定义比较抽象，我们可以从简单的东西开始。**SpringCloud是基于SpringBoot的，** 最适合用于管理SpringBoot创建的各个微服务应用。要管理分布式环境下的各个SpringBoot微服务，必然存在服务的注册问题。所以我们先从服务的注册谈起。既然是注册，必然有个管理注册中心的服务器，各个在SpringCloud管理下的SprinBoot应用就是需要注册的client

SpringCloud使用eureka server,client注册上去。eureka是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳，在默认情况下eureka server也是一个eureka client，必须要指定一个server然后所有需要访问配置文件的应用都作为一个eureka。

*SpringBoot和SpringCloud的关系与区别：*

*1、<u>SpringBoot只是一个**快速开发框架</u>**，使用注解简化了xml配置，内置了Servlet容器，以Java应用程序进行执行。*

*2、SpringCloud是一<u>系列框架的集合，可以包含SpringBoot。*</u>