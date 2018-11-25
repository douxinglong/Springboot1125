# Spring

## 第一种注入方式：使用.xml配置通过构造器和setter注入。

### 1.bean1.xml

##### <bean id="helloService" class ="cn.com.taiji.controller.Helloserver">

#####           <property name="name" value="world"></property>

##### 	<constructor-arg type="String" value="spring"></constructor-arg>

##### </bean> 

##### <context:component-scan base-package="cn.com.taiji.controller"></context:component-scan>

### 2.Text.java测试类

ApplicationContext context;

@Test
	public  void text() {
		context=new ClassPathXmlApplicationContext("bean1.xml");
		 Object bean=context.getBean("helloService");
		 System.out.println("123:");
		 System.out.println(bean.getClass());
	}



##第二种注入方式：注解注入。

测试类扫描包中的“ser”，运行dou()方法，在Ser.java中通过@Autowired自动装配获得user调用a()。

### 1.User.java

@Component("user")
public class User {
	public void a() {
		System.out.println("111111111111");
	}

}

####2.Ser.java

@Component("ser")
public class Ser {
	@Autowired
private User user;
public void dou() {
	System.out.println("2222222222");
	user.a();
}

}

### 3.Text()测试方法

#### `@Test`

##### `public void text2() {`

##### 	@SuppressWarnings("resource")

##### 	AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();	    context1.scan("demo");

##### 	 context1.refresh();

##### 	 Ser d=(Ser)context1.getBean("ser");

##### 	 d.dou();

​	}



## 第三种注入方式:@Configuration配置类，通过配置类代替.xml配置文件。

@Configuration
public class Aser {
@Bean("abc")
public Bser b() {
Bser bser=new Bser();
	return bser;
}
}

### 2.Bser.java

@Component

### 3.Text()测试方法

	@Test
	public void text3() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Aser.class); 
		
		context.registerShutdownHook();
		 System.out.println("123");
		 System.out.println("123"+context.getBean("abc"));
		 
	}
# Spring Boot

##	@RequestMapping():return的值输出到页面上

## 1.hello()测试方法

@RequestMapping("/hello")
	public String hello() {

		return "hello,world!";
	}
## 2.启动时执行CommandLineRunner

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args ->{
			System.out.println("list:bean" + ctx.getBeanDefinitionCount());
			
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String string : beanNames) {
				System.out.println(beanNames);
			}
		};
	}
	@Bean
	public static CommandLineRunner testA() {
		CommandLineRunner runner =new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println("在这里");	
				
			}
		};
## 3.启动时执行ApplicationRunner

@Bean
	public ApplicationRunner oppRunner() {
		return args ->{
			System.out.println();
			System.out.println("ApplicationRunner: ");
			

			for (String opt : args.getOptionNames()) {
				System.out.println(opt);
				System.out.println("->");
				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(opt)));
			}
		};
	}
## 4.ApplicationListener监听器

	@Bean
	public ApplicationListener<ApplicationEvent> helloListener(){
		final String HELLO_URL="/hello";
		return (ApplicationEvent event)->{
			if(event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e=(ServletRequestHandledEvent) event;
				if(e.getRequestUrl().equals(HELLO_URL)) {
					System.out.println("123456"+demo2.getMessage());
				}
			}
		};
	}
## 5.Spring boot Admin监控

### 1.1123：8080

1. pom.xml

   ```xml
   		<!--引入admin server依赖-->
   		<dependency>
   			<groupId>de.codecentric</groupId>
   			<artifactId>spring-boot-admin-server</artifactId>
   			<version>1.5.6</version>
   		</dependency>
   		<!--admin server的展示-->
   		<dependency>
   			<groupId>de.codecentric</groupId>
   			<artifactId>spring-boot-admin-server-ui</artifactId>
   			<version>1.5.6</version>
   		</dependency>
   ```

2. 启动类上加注解

```java
@Configuration
@EnableAutoConfiguration
@EnableAdminServer

```

1.访问http://localhost:8080

### 2.demo3：8083

1. pom.xml

```xml
<dependency>
   <groupId>de.codecentric</groupId>
   <artifactId>spring-boot-admin-starter-client</artifactId>
   <version>1.5.6</version>
</dependency>
```

1. application.properties

```properties
spring.boot.admin.url=http://localhost:8080  
management.security.enabled=false
```

## 6.使用 spring.profiles.active 及 @profile 注解 动态化配置内部及外部配置

### 1.application.yml

name1: dou
hello: good evening
spring: 
   profiles: 

​      active: hello

spring: 
   profiles: googbye,dev

name1: everyone

spring: 
   profiles: hello
name1: david

### 2.@profile

@Profile({"hello","default","dev"})

## 7.端点

执行器端点允许你监控应用及与应用进行交互。Spring Boot包含很多内置的端点，你也可以添加自己的。例如，health端点提供了应用的基本健康信息。 

### 1.配置端点

management: 
   security: 
     enabled: false
   port: 8888
   context-path: /abc

### 2.自定义端点

endpoints:
  actuator:
    enabled: true
  shutdown:
    enabled: true
info:
  app:
    name: spring-boot-actuator
    version: 1.0.0

## 8.日志

常用日志级别有四个，优先级从高到低分别是ERROR、WARN、INFO、DEBUG 。

### 1.输出日志

### 1.输出日志

    public void queryObligations() {  
        log.debug("query obligations start...");  
        log.error("An error occurred during the query");  
        log.debug("query obligations end...");  
    }  
### 2.定义日志级别

logging.level.root=WARN
logging.level.org.springframework.web=DEBUG
logging.file=my.log

## 9.@PropertySource

​	通过@PropertySource注解将properties配置文件中的值存储到Spring的 Environment中，Environment接口提供方法去读取配置文件中的值，参数是properties文件中定义的key值。

@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.example")
public class User {...}