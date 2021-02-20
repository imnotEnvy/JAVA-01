学习笔记


# Spring笔记

# Spring历史和发展

Spring源于 Rod Johnson的一本书 《J2EE Development without EJB》。

背景：

1. J2EE的核心功能（EJB,Applet,JMS, JTA事务 ）由J2EE容器JBoss, WebLogic等应用服务器提供，当时项目开发依赖于J2EE容器提供的功能
2. 开发人员主要负责单薄的业务层，其他代码组织和功能交给J2EE应用服务器。

Spring解决了什么问题？

1. EJB，J2EE容器的依赖
2. 复杂项目和业务的开发模式(View, Controller, Service, DAO, Entity等等)

## 版本发展

Spring 1.x  Bean工厂和XML配置

Spring 2.x Java5带来注解和反射机制，支持注解配置

Spring 3.x

Spring 4.x

Spring 5.x

## 生态发展

- Spring Boot
- Spring Cloud
- Spring Cloud Data Flow

# Spring框架设计

常用模块

![Spring%E7%AC%94%E8%AE%B0%20fcd43c4c3a41434d807d40d5dcd5bf56/Untitled.png](Spring%E7%AC%94%E8%AE%B0%20fcd43c4c3a41434d807d40d5dcd5bf56/Untitled.png)

其中Bean和AOP是核心部分。

Spring早期的核型功能是对Java对象的生命周期管理和对象的装配。 为了实现该技术，一个方案是实现一层中间代理层。

IOC/DI，控制反转和依赖注入

循环依赖：

1. 属性依赖，Spring可以处理
2. 构造器依赖，Spring不可以处理

## Spring AOP

动态代理和字节码增强（CGLib）是实现Spring AOP的两种技术。

## Spring Bean核心原理

ApplicationContext接口到BeanFactory接口的关系

![Spring%E7%AC%94%E8%AE%B0%20fcd43c4c3a41434d807d40d5dcd5bf56/Untitled%201.png](Spring%E7%AC%94%E8%AE%B0%20fcd43c4c3a41434d807d40d5dcd5bf56/Untitled%201.png)

### Bean的生命周期

1. 创建对象
2. 属性赋值
3. 初始化
    1. 检查Aware装配
    2. 前置处理
    3. 调用init-method
    4. 后置处理
4. 注销接口注册
5. 使用
6. 销毁

# Spring和Spring Boot

# Spring Boot核心原理