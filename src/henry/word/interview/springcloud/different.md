# Spring、SpringMVC、SpringBoot、SpringCloud概念、关系及区别

### 一、正面解读：

Spring主要是基于IOC反转Beans管理Bean类，主要依存于SSH框架（Struts+Spring+Hibernate）这个MVC框架，所以定位很明确，Struts主要负责表示层的显示，Spring利用它的IOC和AOP来处理控制业务（负责对数据库的操作），Hibernate主要作用是数据的持久化到数据库。
  

SpringMVC是基于Spring的一个MVC框架，用以替代初期的SSH框架;(spring Framework本身没有Web功能，Spring MVC使用WebApplicationContext类扩展ApplicationContext，使得拥有web功能)。
  

Spring Boot是基于Spring4的条件注册的一套快速开发整合包


三者的发展与联系：
  

Spring 最初利用“工厂模式”（ DI ）和“代理模式”（ AOP ）解耦应用组件。大家觉得挺好用，于是按照这种模式搞了一个 MVC 框架（一些用 Spring 解耦的组件），用开发 web 应用（ SpringMVC ）。然后有发现每次开发都要搞很多依赖，写很多样板代码很麻烦，于是搞了一些懒人整合包（ starter ），这套就是 Spring Boot 。
 
  

升级云-Spring Cloud：现在是大数据、云时代，上云是必然选择，那么Spring Cloud应运而生，

### 二、概念解读

#### 什么是spring


  关于spring的定义无论是从官方还是市面上已经很多能够清晰明了的做出解释了。我姑且简单定义它为一个轻量级的控制反转（IoC）和面向切面（AOP）的容器,Java 开发框架，至于控制反转、面向切面、轻量级、容器等这些自行百度，很多大牛解释的非常清楚

#### 什么是springMVC


  这里我姑且把名词分开来讲、spring与mvc可以更好地解释什么是springMvc，MVC为现代web项目开发的一种很常见的模式，简言之C（控制器）将V（视图、用户客户端）与M（模块，业务）分开构成了MVC ，业内常见的mvc模式的开发框架有Struts1，Struts2等。spring作为专业的开发web项目的开源框架，springMvc为内部的一个模块环节，同样采取mvc设计模式。 所以在使用spring开发web项目时，作为核心环节的MVC可以使用struts1/struts2/springMVc


#### 什么是Spring-boot


我的理解是这样的、spring系列大家族里面产品超级多了、那么使用spring整合基础框架作为项目架构时，大多数初级人员在搭建项目时话费了很多时间也未必能搭建明白。 spring-boot就是为了解决开发人员这个痛点而诞生的，说白了就是把以前的手动配置的过程自动化封装了，提供默认的配置，借用大牛总结的特点就是：
   

简单易用，初学者和大牛都可以轻松上手，其中的注解会给使用者提供方便；
   

Spring boot对第三方技术进行了很好的封装和整合，提供了大量第三方接口；
   

可以通过依赖自动配置，不需要XML等配置文件
   

还提供了安全等特性姑且先不做理会。


完了现在boot总结就是可以快速启动，快速构建项目，在配置文件环节省去大量时间和精力，傻瓜式带你进入项目大门，进行业务逻辑编写。现在跟很多框架整合了 按照规范去配置 分分钟上手写代码



#### 什么是spring-cloud


  微服务是当前架构领域的热门话题，要想知道什么是spring-cloud，麻烦先去弄清楚什么是微服务。spring-colud是一种云端分布式架构解决方案，基于spring boot,在spring boot做较少的配置，便可成为 spring cloud 中的一个微服务。 说点有点冠冕堂皇了 我也没用过、不过简单理解为：spring cloud也就是提供了一些常用的分布式组件，都是应用型的，就根spring mvc差不多。

### 三、深入解读Spring Cloud与 Spring Boot的概念与关系。

#### 什么是 Spring Boot
    
Spring Booti简化了基于 Spring的应用开发,通过少量的代码就能创建一个独立的、产品级別的 Spring应用。 Spring Boot为 Spring平台及第三方库提供开箱即用的设置,这样你就可以有条不素地开始。多数 SpringBoot应用只需要很少的 Spring配置。
    

Spring Boot是由 Pivotal团队提供的全新框架,其设计目的是用来简化新 Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置,从而使开发人员不再需要定义样板化的配置。用我的话来理解,就是Spring Boot其实不是什么新的框架,它默认配置了很多框架的使用方式,就像 maven整合了所有的jar包，Spring Boot整合了所有的框架。
    

Spring Boot的核心思想就是约定大于配置,一切自动完成。采用 Spring Boot可以大大的简化你的开发模式,所有你想集成的常用框架,它都有对应的组件支持。
    

#### 什么是Spring Cloud
    

Spring Cloud是一系列框架的有序集合。它利用 Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发,如服务发现注册、配置中心、消息总线线、负载均衠、断路器、数据监控等,都可以用 Spring Boot的开发风格做到一键启动和部署。 Spring并没有重复制造轮子,它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组台起来,通过 Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理,最终给开发者留出了一套简单易懂、易部署和易维护的分布式系統开发工具包。
    

微服务是可以独立部署、水平扩展、独立访问(或者有独立的数据库)的服务单元, Spring Cloud就是这些微服务的大管家,采用了微服务这种架构之后,项目的数量会非常多, Spring Cloud做为大管家就需要提供各种方案来维护整个生态。
    

Spring Cloud就是一套分布式服务治理的框架,既然它是一套服务治理的框架,那么它本身不会提供具体功能性的操作,更专注于服务之间的通讯、熔断、监控等。因此就需要很多的组件来支持一套功能。
    

#### Spring Boot和Spring Cloud的关系
    

Spring Boot是 Spring的一套快速配置脚手架,可以基于 Spring Boot快速开发单个微服务, SpringCloud是一个基于 Spring Boot实现的云应用开发工具; Spring Boot专注于快速、方便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架; Spring Boot使用了默认大于配置的理念,很多集成方案已经帮你选择好了,能不配置就不配置, Spring Cloud很大的一部分是基于 Spring Boot来实现,可以不基于 Spring Boot吗?不可以。 Spring Boot可以离开 Spring Cloud独立使用开发项目,但是 Spring Cloud离不开 Spring Boot,属于依赖的关系
  

Spring Ioc 和 Spring Aop 两个强大的功能才有了 Spring ，Spring 生态不断的发展才有了 Spring Boot ，使用 Spring Boot 让 Spring 更易用更有生命力，Spring Cloud 是基于 Spring Boot 开发的一套微服务架构下的服务治理方案， Spring ioc/aop > Spring > Spring Boot > Spring Cloud
 

#### Spring Cloud架构
  
我们从整体来看一下 Spring Cloud主要的组件,以及它的访间流程
  

1、外部或者内部的非 Spring Cloud目都统一通过API网关(Zuul)来访可内部服务
  

2、网关接收到请求后,从注册中心(Eureka)获取可用服务
 

3、由 Ribbon进行均负载后,分发到后端的具体实例
  

4、徹服务之间通过 Feign进行通信处理业务
  

5、 Hystrix负责处理服务超时熔断
  

6、 Turbine监控服务间的调用和焠断相关指标