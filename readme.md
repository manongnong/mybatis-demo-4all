# mybatis例子
# 1 mybatis-demo-xml
原生mybatis例子 对应网址 https://mybatis.org/mybatis-3/zh/getting-started.html
包括XML方式定义SQL和注解方式定义SQL
核心类
SqlSessionFactory MapperBuilderAssistant MappedStatement
MapperProxyFactory MapperMethod
# 2 mybatis-demo-spring
Spring版本的Mybatis 对应网址 http://mybatis.org/spring/
核心类
MapperFactoryBean 
# 3 mybatis-demo-springboot
网址 http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
核心类
MybatisAutoConfiguration 
@MapperScan MapperScannerRegistrar

# 4 mybatis-plus-demo-springboot
网址 https://baomidou.com/pages/226c21/
核心类
MybatisSqlSessionFactoryBean 
MybatisConfiguration MybatisMapperRegistry MybatisMapperAnnotationBuilder
# 常见问题
## 问题1 Mysql版本和驱动类型
com.mysql.jdbc.Driver(5.1.X) VS com.mysql.cj.jdbc.Driver(8.X) 
## 问题2 @MapperScan  @Mapper @MapperScan优先级高于@Mapper
https://blog.csdn.net/Yuwen_forJava/article/details/118386651
